import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Building {

	public static ArrayList<Building> BuildingList = new ArrayList<Building>();
	
	private int x = 0, y = 0, w = 0, h = 0;
	private String name = "", rot = "";
	
	public static int TemplateX = 750, TemplateY = 500, TemplateW = 50, TemplateH = 50;
	public static String TemplateName = "", TemplateRot = "";
	
	public Building(int x, int y, int w, int h, String rot, String name){
		
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.rot = rot;
		this.name = name;
		
	}
	
	public static void MakeBuilding(int x, int y, int w, int h, String rot, String name){
		BuildingList.add(new Building(x, y, w, h, rot, name));
	}
	//Get building's variables
	public String[] getBuilding(){
		return new String[]{Integer.toString(x), Integer.toString(y), Integer.toString(w), Integer.toString(h), rot, name};
	}
	
	//Check if want to go in building, then enter through door or lean on the wall
	public static boolean onBuilding(int xH, int yH, int s){
		//xH yH - human topleft corner co-ords;  s - human size
		for(int i = 0; i < Building.BuildingList.size(); i++){
			
			String[] temp = Building.BuildingList.get(i).getBuilding();
			
			//building's stats
			int     x = Integer.parseInt(temp[0]), 
					y = Integer.parseInt(temp[1]), 
					w = Integer.parseInt(temp[2]), 
					h = Integer.parseInt(temp[3]);
			String  Brot  = temp[4], //N, E, W, S; Where door is
					Bname = temp[5]; //Name of building
			
			
			
			//Check if in the building
			switch (Brot){
				case "N":
					if((yH+s*0.3)>=y && yH<=(y+h-5) && xH>=x+(3*w/8) && (xH+s)<=x+(5*w/8)){
						Enter(Bname);
					}
					break;
				case "S":
					if(yH>=y+s+5 && (yH+s*0.7)<=(y+h) && xH>=x+(3*w/8) && (xH+s)<=x+(5*w/8)){
						Enter(Bname);
					}
					break;
				case "E":
					if((xH+s)>=x+s+5 && (xH+s*0.7)<=(x+w) && (yH+s)>=y+(3*h/8) && yH<=y+(5*h/8)){
						Enter(Bname);
					}
					break;
				case "W":
					if((xH+s*0.3)>=x && xH<=(x+w-s-5) && (yH+s)>=y+(3*h/8) && yH<=y+(5*h/8)){
						Enter(Bname);
					}
					break;
			}
			
			//If on the wall(true) & if through the door(false) & nothing(false)
			if((xH+s)>=x && xH <= (x+w) && (yH+s) >= y && yH <= (y+h)){
				switch (Brot){
					case "N":
						if(!((yH+s)>=y && yH<=(y+h-s-5) && xH>=x+(3*w/8) && (xH+s)<=x+(5*w/8))){
							return true;
						}
						break;
					case "S":
						if(!((yH+s)>=y+s+5 && yH<=(y+h) && xH>=x+(3*w/8) && (xH+s)<=x+(5*w/8))){
							return true;
						}
						break;
					case "E":
						if(!((xH+s)>=x+s+5 && xH<=(x+w) && yH>=y+(3*h/8) && (yH+s)<=y+(5*h/8))){
							return true;
						}
						break;
					case "W":
						if(!((xH+s)>=x && xH<=(x+w-s-5) && yH>=y+(3*h/8) && (yH+s)<=y+(5*h/8))){
							return true;
						}
						break;
				}
			}
		}
		return false;
	}
	public static void Enter(String s){
		Inside.Enter(s);
	}
}
