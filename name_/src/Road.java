import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Road {
	
	public static ArrayList<Road> RoadList = new ArrayList<Road>();
	public static ArrayList<int[]> Crossings = new ArrayList<int[]>();//x, y, w, h
	
	private int x1 = 0, y1 = 0, x2 = 0, y2 = 0, s = 0;
	private boolean vertical = false;
	
	public static int TemplateX = 1000, TemplateY = 500;
	public static boolean TemplateVertical = false;
	
	public Road(int x1, int y1, int x2, int y2, int s, boolean vertical){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.s = s;
		this.vertical = vertical;
	}
	
	public static void MakeCrossing(int s){
		ArrayList<int[]> Roads = new ArrayList<int[]>();
		for(int i = 0; i <= s; i++){
			Roads.add(Road.RoadList.get(i).getRoad());
		}
		
		if(Roads.get(s)[5] == 1){ //if created is vertical
			for(int i = 0; i <= s; i++){
				if(Roads.get(i)[5]==0){//check which ones are horisontal
					Crossings.add(new int[]{Roads.get(s)[0], Roads.get(i)[1], Roads.get(s)[4], Roads.get(i)[4]});
				}
			}
			
			
		}else{ //if created is horisontal
			for(int i = 0; i <= s; i++){
				if(Roads.get(i)[5]==1){//check which ones are vertical
					Crossings.add(new int[]{Roads.get(i)[0], Roads.get(s)[1], Roads.get(i)[4], Roads.get(s)[4]});
				}
			}
		}
		
	}
	
	public static void MakeRoad(int x1, int y1, int x2, int y2, int s, boolean vertical){
		RoadList.add(new Road(x1, y1, x2, y2, s, vertical));
		if(RoadList.size() > 1){
			//if there is a road already, check for crossing and send created ones index
			MakeCrossing(RoadList.size()-1);
		}
	}
	
	public int[] getRoad(){
		return new int[]{x1, y1, x2, y2, s, vertical ? 1 : 0};
	}

	public static boolean onRoad(double x, double y, double s /*HUMAN'S RADIUS (diameter elsewhere)*/ ){
		for(int i = 0; i < Road.RoadList.size(); i++){
			
			int[] temp = Road.RoadList.get(i).getRoad();
			
			//Each road's co-ords
			int 	x1 = temp[0], 
					y1 = temp[1], 
					x2 = temp[2], 
					y2 = temp[3], 
					s1 = temp[4];
			boolean v = temp[5] == 1; //If road is vertical
			
			//Compare to human's co-ords
			if(v && x > x1-s && x+s < x2+s1 && y > y1 && y < y2){
				return true;
			}else if(!v && x > x1 && x < x2 && y+s > y1 && y+s < y2+s1){
				return true;
			}
		}
		return false;
	}
}
