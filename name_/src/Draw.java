import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Draw {

	private static Graphics g = null;
	
	public Draw(Graphics g){
		Draw.g = g;
		
		for(int i = 0; i < Road.RoadList.size(); i++){
			//Draw all road objects
			int[] temp = Road.RoadList.get(i).getRoad();
			Road(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5] == 1);
		}
		
		for(int i = 0; i < Building.BuildingList.size(); i++){
			//Draw all buildings
			String[] temp = Building.BuildingList.get(i).getBuilding();
			Building(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), 
					Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), temp[4], temp[5]);
		}
		
		for(int i = 0; i < Cars.CarsList.size(); i++){
			//Draw all cars
			int[] temp = Cars.CarsList.get(i).DrawCar();
			Car(temp[0], temp[1], temp[2], temp[3] == 1);
		}
		
		for(int i = 0; i < Trees.TreeList.size(); i++){
			//Draw all trees
			int[] temp = Trees.TreeList.get(i).DrawTree();
			Tree(temp[0], temp[1], temp[2], temp[3]);
		}

		//Draw human
		Human((int) Human.DrawHuman()[0], (int) Human.DrawHuman()[1], (int) Human.DrawHuman()[2]);
		
		
		//Draw templates while placing
		
		switch(UserInput.Page){
			case "AddRoad" :
				
				if(Road.TemplateVertical){
					Road(Road.TemplateX, 0, Road.TemplateX, Main.frame.getHeight(), 40, true);
				}else{
					Road(0, Road.TemplateY, Main.frame.getWidth(), Road.TemplateY, 40, false);
				}
				break;
			case "AddBuilding" :
				
				Building(Building.TemplateX, Building.TemplateY, Building.TemplateW, Building.TemplateH, 
						Building.TemplateRot, Building.TemplateName);
				break;
			case "AddTree" :
				
				Tree(Trees.TemplateX, Trees.TemplateY, Trees.TemplateW, Trees.TemplateH);
				break;
			case "AddCar" :
				boolean vertical = Cars.TempDir == "N" || Cars.TempDir == "S";
				Car(Cars.TempX, Cars.TempY, Cars.Size, vertical);
				break;
 	}
		
		
		
		
		
	}
	
	public static void Car(int x, int y, int s, Boolean vertical){

		g.setColor(new Color(255, 0, 0));
		
		if(vertical){
			g.fillRect(x, y, s*2/3, s);
		}else{
			g.fillRect(x, y, s, s*2/3);
		}
	}
	
	public static void Building(int x, int y, int w, int h, String s, String name){
		// String s; Door location. North, South, West, East; (N,S,W,E)
		g.setColor(Color.gray);
		g.fillRect(x, y, w, h);
		g.setColor(new Color(139, 69, 19));
		switch(s){
			case"N":
				g.fillRect(x+w/2-w/8, y, w/4, 5);
				break;
			case"S":
				g.fillRect(x+w/2-w/8, y+h-5, w/4, 5);
				break;
			case"W":
				g.fillRect(x, y+h/2-h/8, 5, h/4);
				break;
			case"E":
				g.fillRect(x+w-5, y+h/2-h/8, 5, h/4);
				break;
		}
		if(w>=h){
			g.setColor(new Color(128, 255, 128));
			g.setFont(new Font(Font.SERIF, Font.PLAIN, 2*w/(name.length()+1)));
			g.drawString(name, x, y+h/2);
			
		}else{
			g.setColor(new Color(128, 255, 128));
			g.setFont(new Font(Font.SERIF, Font.PLAIN, 2*w/(name.length()+1)));
			g.drawString(name, x, y+h/2);
		}
	}
	
	public static void Human(int x, int y, int s){
		//x and y are circle's center co-ords
		g.setColor(Color.blue);
		g.fillOval(x-s/2, y-s/2, s, s);
		g.setColor(Color.black);
		g.drawOval(x-s/2, y-s/2, s, s);
		g.drawOval(x-s/2, y-s/2, s-1, s-1);
	}
	
	public static void Tree(int x, int y, int w, int h){
		g.setColor(new Color(139, 69, 19));
		g.fillRect(x-w/10+w/2, y+h*1/2, w/5, h*1/2);
		g.setColor(new Color(0, 220, 0, 200));
		g.fillOval(x, y, w, h*2/3);
	}
	
	public static void Road(int x1, int y1, int x2, int y2, int s, boolean vertical){
		
		// s = size
		g.setColor(Color.black);
		g.drawLine(x1, y1, x2, y2);
		
		if(vertical){
			g.setColor(new Color(191, 191, 191));
			g.fillRect(x1+1, y1, s-1, y2);
			
			g.setColor(Color.black);
			g.drawLine(x1+s, y1, x2+s, y2);
			
			for(int i = y1; i<y2; i+=s){
				g.drawLine(x1+s/2, i, x2+s/2, i+s/6);
			}
		}else{
			g.setColor(new Color(191, 191, 191));
			g.fillRect(x1, y1+1 , x2, s);
			
			g.setColor(Color.black);
			g.drawLine(x1, y1+s, x2, y2+s);
			
			for(int i = x1; i<x2; i+=s){
				g.drawLine(i, y1+s/2, i+s/6, y2+s/2);
			}
		}
		//draw crossings
		
		if(!Road.Crossings.isEmpty()){
			for(int i = 0; i < Road.Crossings.size(); i++){
				g.setColor(new Color(191, 191, 191));
				g.drawRect(Road.Crossings.get(i)[0], Road.Crossings.get(i)[1], Road.Crossings.get(i)[2], Road.Crossings.get(i)[3]);
			}
		}
	}
}
