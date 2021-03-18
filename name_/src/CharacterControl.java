import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class CharacterControl{

	public static Boolean isRunning = true;
	
	public static void Time(){
		Stats.minutes+=1;
		  
		 if(Stats.minutes >= 60){
			 Stats.minutes = 0;
			 Stats.hours++;
			 
			 //Calculate investments
			 Bank.Investments();
		 }
		 if(Stats.hours >= 24){
			 Stats.hours = 0;
			 Stats.day++;
		 }
		 StringBuilder sb = new StringBuilder();
		 if(Stats.hours <= 9){
			 sb.append("0" + Stats.hours);
		 }else{
			 sb.append(Stats.hours);
		 }
		 sb.append(":");
		 if(Stats.minutes <= 9){
			 sb.append("0" + Stats.minutes);
		 }else{
			 sb.append(Stats.minutes);
		 }
		 Stats.time = sb.toString();
	}
	


	public static void StartGameCycle(){
		
		//Place to make Objects
		Human.MakeHuman(841, 400, 15, 1);
		Road.MakeRoad(0, 400, 1520, 400, 40, false);
		Road.MakeRoad(700, 0, 700, 1080, 40, true);
		Road.MakeRoad(900, 0, 900, 1080, 40, true);
		Road.MakeRoad(0, 640, 1520, 640, 40, false);
		Cars.MakeCar(705, 0, 20, 3, "S");
		Cars.MakeCar(0, 425, 20, 3, "E");
		Building.MakeBuilding(941, 441, 299, 199, "W", "Discohouse");
		Building.MakeBuilding(941, 300, 150, 100, "S", "Home");
		Building.MakeBuilding(0, 300, 150, 100, "S", "House");
		Building.MakeBuilding(500, 100, 200, 300, "S", "SuperMarket");
		Building.MakeBuilding(741, 441, 159, 97,  "N", "Bank");
		Trees.MakeForest(740, 300, 25, 50);
		Trees.MakeForest(760, 300, 25, 50);
		Trees.MakeForest(790, 300, 25, 50);
		Trees.MakeForest(830, 300, 25, 50);
		
		//initialize userinput frame
		UserInput.initialize();
		
		//Initialize Inside frames
		Inside.init();
		
		//Update stats panel every second
		Timer timer1 = new Timer();
		
		timer1.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
				  
				  
				  if(!UserInput.EditMode){
					  
					  switch (Stats.status){
					  	case "Walking" :
					  		Stats.stamina-=0.7;
					  		Stats.sleepiness +=0.00877;
					  		break;
					  	case "Leaning" :
					  		Stats.stamina+=0.3;
					  		break;
					  	case "Standing" :
					  		Stats.stamina-=0.2;
					  		break;
					  }
					  if(Stats.stamina > 100){
						  Stats.stamina = 100;
					  }
					  Stats.sleepiness += 0.0877;
					  Time();
					  UserInput.RefreshPanel();
				  }
				  
				  
			  }
			}, 1000, 1000);
		
		//Main game loop
		Timer timer2 = new Timer();
		timer2.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				
				if(!Inside.isInside){
					//Check for keyboard input
					CharControl();

					//Move cars
					for(int i = 0; i<Cars.CarsList.size(); i++){
						Cars.CarsList.get(i).CarMove();
					}

					//car collision with human
					Cars.CarCollision((int)Human.x, (int)Human.y, (int)Human.s);
				}
				//Update frame
				Main.ReDraw();
				
			}
		}, 1000/60, 1000/60);
	
		
		Timer timer3 = new Timer();
		
		timer3.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if(!UserInput.EditMode && !Inside.isInside){
					Cars.carSpawnAI();
					  
				}
					  
					  
			}
		}, Cars.freq, Cars.freq);
		
	
	
	}
	//Keyboard commands
	private static boolean LEFTPressed = false, RIGHTPressed = false, UPPressed = false, DOWNPressed = false, ENTERPressed = false;
	
	public static void CharControl(){
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
   
			public boolean dispatchKeyEvent(KeyEvent ke) {
	                
				switch(ke.getID()) {
                	case KeyEvent.KEY_PRESSED:
                		switch(ke.getKeyCode()){
                		case KeyEvent.VK_LEFT :
                			 LEFTPressed = true;
                			break;
                		case KeyEvent.VK_RIGHT :
                			RIGHTPressed = true;
                			break;
                		case KeyEvent.VK_UP :
                			UPPressed = true;
                			break;
                		case KeyEvent.VK_DOWN :
                			DOWNPressed = true;
                			break;
                		case KeyEvent.VK_ENTER :
                			ENTERPressed = true;
                			break;
                		case KeyEvent.VK_ESCAPE :
                			System.exit(0);
                	}
                    break;
                	
                  
                	case KeyEvent.KEY_RELEASED:
                		//Smooth movement
                    	switch(ke.getKeyCode()){
                    		case KeyEvent.VK_LEFT :
                    			LEFTPressed = false;
                    			break;
                    		case KeyEvent.VK_RIGHT :
                    			RIGHTPressed = false;
                    			break;
                    		case KeyEvent.VK_UP :
                    			UPPressed = false;
                    			break;
                    		case KeyEvent.VK_DOWN :
                    			DOWNPressed = false;
                    			break;
                    		case KeyEvent.VK_ENTER :
                    			ENTERPressed = false;
                    			break;
                    	}
                        break;
				}
				return false;      
			}
		});
		
		if(!UserInput.EditMode){
			if(LEFTPressed){
				Human.Move("W");
			}
			if (RIGHTPressed){
				Human.Move("E");
			}
			if (UPPressed){
				Human.Move("N");
			}
			if (DOWNPressed){
				Human.Move("S");
			}
			if(!LEFTPressed && !RIGHTPressed && !UPPressed && !DOWNPressed && Stats.status != "Leaning"){
				Stats.status = "Standing";
			}
		}else{
			
			
			switch(UserInput.Page){
				case "AddRoad" :
					if(LEFTPressed){
						Road.TemplateX-=1;
						Road.TemplateVertical = true;
					}
					if (RIGHTPressed){
						Road.TemplateX+=1;
						Road.TemplateVertical = true;
					}
					if (UPPressed){
						Road.TemplateY-=1;
						Road.TemplateVertical = false;
					}
					if (DOWNPressed){
						Road.TemplateY+=1;
						Road.TemplateVertical = false;
					}
					if(ENTERPressed){
						if(Road.TemplateVertical){
		    				Road.MakeRoad(Road.TemplateX, 0, Road.TemplateX, Main.frame.getHeight(), 40, true);
		    			}else{
		    				Road.MakeRoad(0, Road.TemplateY, Main.frame.getWidth()-400, Road.TemplateY, 40, false);
		    			}
		    			UserInput.Page = "question";
		    			UserInput.RefreshPanel();
		    			KeyPressDelay();
					}
					
					break;
					
				case "AddBuilding" :
					switch(UserInput.BuildingAddingMode){
						case "location" :
							if(LEFTPressed){
								Building.TemplateX-=1;
							}
							if (RIGHTPressed){
								Building.TemplateX+=1;
							}
							if (UPPressed){
								Building.TemplateY-=1;
							}
							if (DOWNPressed){
								Building.TemplateY+=1;
							}
							if(ENTERPressed){
								UserInput.BuildingAddingMode = "size";
								UserInput.RefreshPanel();
								KeyPressDelay();
							}
							break;
						case "size" :
							if(LEFTPressed){
								Building.TemplateW-=1;
							}
							if (RIGHTPressed){
								Building.TemplateW+=1;
							}
							if (UPPressed){
								Building.TemplateH-=1;
							}
							if (DOWNPressed){
								Building.TemplateH+=1;
							}
							if(ENTERPressed){
								UserInput.BuildingAddingMode = "name";
								UserInput.RefreshPanel();
								KeyPressDelay();
							}
							break;
							
						case "name" :
							if(ENTERPressed){
								UserInput.BuildingAddingMode = "doorLocation";
								UserInput.RefreshPanel();
	        					KeyPressDelay();
	        					
							}
							break;
						case "doorLocation" :
							if(LEFTPressed){
								Building.TemplateRot = "W";
							}
							if (RIGHTPressed){
								Building.TemplateRot = "E";
							}
							if (UPPressed){
								Building.TemplateRot = "N";
							}
							if (DOWNPressed){
								Building.TemplateRot = "S";
							}
							if(ENTERPressed){
								if(!(Building.TemplateRot == "")){
		    						Building.MakeBuilding(Building.TemplateX, Building.TemplateY, Building.TemplateW, 
		    								Building.TemplateH, Building.TemplateRot, Building.TemplateName);
		        					//go back
		        					UserInput.Page = "question";
		        					//set buildingmaking to start
		        					UserInput.BuildingAddingMode = "location";
		        					//reset building template stats
		        					Building.TemplateX = Main.panel.getWidth()/2; 
		        					Building.TemplateY = Main.panel.getHeight()/2;
		        					Building.TemplateW = 50;
		        					Building.TemplateH = 50;
		        					Building.TemplateName = "";
		        					Building.TemplateRot = "";
		        					UserInput.RefreshPanel();
		        					KeyPressDelay();
		    					}
							}
							break;
					}
				case "AddTree" :
					switch(UserInput.TreeAddingMode){
						case "location" :
							if(LEFTPressed){
								Trees.TemplateX--;
							}
							if (RIGHTPressed){
								Trees.TemplateX++;
							}
							if (UPPressed){
								Trees.TemplateY--;
							}
							if (DOWNPressed){
								Trees.TemplateY++;
							}
							if(ENTERPressed){
								UserInput.TreeAddingMode = "size";
								UserInput.RefreshPanel();
	        					KeyPressDelay();
							}
							break;
						case "size" :
							if(LEFTPressed){
								Trees.TemplateW--;
							}
							if (RIGHTPressed){
								Trees.TemplateW++;
							}
							if (UPPressed){
								Trees.TemplateH--;
							}
							if (DOWNPressed){
								Trees.TemplateH++;
							}
							if(ENTERPressed){
								Trees.MakeTree(Trees.TemplateX, Trees.TemplateY, Trees.TemplateW, Trees.TemplateH);
								UserInput.Page = "question";
								UserInput.TreeAddingMode = "location";
								UserInput.RefreshPanel();
	        					KeyPressDelay();
								
							}
							break;
					}
					break;
				case "AddCar" :
					switch (UserInput.CarAddingMode){
						case "location" :
							if(LEFTPressed){
								Cars.TempX--;
							}
							if (RIGHTPressed){
								Cars.TempX++;
							}
							if (UPPressed){
								Cars.TempY--;
							}
							if (DOWNPressed){
								Cars.TempY++;
							}
							if(ENTERPressed){
								UserInput.CarAddingMode = "speed";
								UserInput.RefreshPanel();
	        					KeyPressDelay();
							}
							break;
							
						case "speed" :
							if(LEFTPressed){
								Cars.TempSpeed--;
								UserInput.RefreshPanel();
								KeyPressDelay();
							}
							if (RIGHTPressed){
								Cars.TempSpeed++;
								UserInput.RefreshPanel();
								KeyPressDelay();
							}
							if(ENTERPressed){
								UserInput.CarAddingMode = "direction";
								UserInput.RefreshPanel();
								KeyPressDelay();
								
							}
							
							
							break;
							
						case "direction" :
							if(LEFTPressed){
								Cars.TempDir = "W";
							}
							if (RIGHTPressed){
								Cars.TempDir = "E";
							}
							if (UPPressed){
								Cars.TempDir = "N";
							}
							if (DOWNPressed){
								Cars.TempDir = "S";
							}
							if(ENTERPressed){
								Cars.MakeCar(Cars.TempX, Cars.TempY, Cars.Size, Cars.TempSpeed, Cars.TempDir);
								UserInput.CarAddingMode = "location";
								UserInput.Page = "question";
								UserInput.RefreshPanel();
	        					KeyPressDelay();
							}
							break;
					}
						
						
					break;
			}
		}
	}

	public static void KeyPressDelay(){
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
