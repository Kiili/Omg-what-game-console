import java.util.ArrayList;
import java.util.Random;

public class Cars {
	public int x = 0, y = 0, s = 0, speed = 0;
	public String dir = ""; //N,S,W,E
	public Boolean vertical = false;
	public static int TempX = 100, TempY = 425, TempSpeed = 1;
	public static String TempDir = "N";
	public static int Size = 20;
	//how many cars will spawn
	public static int CarsRemoved = 10;
	//How frequent carspawns are
	public static final int freq = 500;
	
	public static ArrayList<Cars> CarsList = new ArrayList<Cars>();
	
	public Cars(int x, int y, int s, int speed, String dir){
		
		this.x = x;
		this.y = y;
		this.s = s;
		this.speed = speed;
		this.dir = dir;

	}
	
	public static void carSpawnAI(){
		
		Random rand = new Random();
		
		if(CarsRemoved > 0){
			int[] temp = Road.RoadList.get(rand.nextInt(Road.RoadList.size())).getRoad();
			//Each road's co-ords
			int 	x1 = temp[0], 
					y1 = temp[1], 
					s1 = temp[4];
			boolean v = temp[5] == 1; //If road is vertical
			
			if(rand.nextInt(2)==0){
				
				if(v){
					Cars.MakeCar(x1+(int)(s1/7), 0, Size, 3, "S");
				}else{
					Cars.MakeCar(0, y1+(int)(s1/5*3), Size, 3, "E");
				}
			}else{
				
				if(v){
					Cars.MakeCar(x1+(int)(s1/5*3), Main.frame.getHeight()-1, Size, 3, "N");
				}else{
					Cars.MakeCar(Main.frame.getWidth()-Main.UserIputPanelWidth-20-1, y1+(int)(s1/7), Size, 3, "W");
				}
				
			}
			
			
			CarsRemoved--;
		}
	}
	
	public static void MakeCar(int x, int y, int s, int speed, String dir){
		CarsList.add(new Cars(x, y, s, speed, dir));
	}
	
	
	public static void CarCollision(int xH, int yH, int sH){
		for(int i = 0; i<Cars.CarsList.size(); i++){
			String[] temp = Cars.CarsList.get(i).getCar();
			int 	x = Integer.parseInt(temp[0]), 
					y = Integer.parseInt(temp[1]), 
					h = Integer.parseInt(temp[2]),
					w = h*2/3;	
			String  dir = temp[3];
			
			
			if(	onCar(xH, yH+(sH/2), x, y, h, w, dir) || 
				onCar(xH+(sH/2), yH, x, y, h, w, dir) || 
				onCar(xH+(sH/2), yH+sH, x, y, h, w, dir) || 
				onCar(xH+sH, yH+(sH/2), x, y, h, w, dir)){
				
				Human.CarHit(dir);
				
			}
		}
	}
	
	public static boolean onCar(int xH, int yH, int x, int y, int h, int w, String dir){
		switch (dir){
		case "N": 
			if(xH>=x && xH<= x+w && yH>=y && yH<=y+h){
				return true;
			}
			break;
		case "S":
			if(xH>=x && xH<= x+w && yH>=y && yH<=y+h){
				return true;
			}
			break;
		case "W":
			if(yH>=y && yH <= y+w && xH>=x && xH<=x+h){
				return true;
			}
			break;
		case "E":
			if(yH>=y && yH <= y+w && xH>=x && xH<=x+h){
				return true;
			}
			break;
	}
		
		
		return false;
		
	}
	
	public String[] getCar(){
		return new String[]{Integer.toString(x), Integer.toString(y), Integer.toString(s), dir};
	}
	
	public int[] DrawCar(){
		return new int[]{x, y, s, vertical ? 1 : 0};
	}
	
	//TODO PAREMA K�E REEGEL
	
	public void CarMove(){
		
		//Remove car if out of bounds
		if(x<0-s || x > Main.frame.getWidth() - Main.UserIputPanelWidth || y < 0-s || y > Main.frame.getHeight()){
			CarsList.remove(this);
			CarsRemoved++;
			
		}else if(!UserInput.EditMode){
			//Move if in play mode
			switch(dir){
			case"N":
				y-=speed;
				vertical = true;
				break;
			case"S":
				y+=speed;
				vertical = true;
				break;
			case"W":
				x-=speed;
				vertical = false;
				break;
			case"E":
				x+=speed;
				vertical = false;
				break;
			}
			
		}
		
		

	}
}
