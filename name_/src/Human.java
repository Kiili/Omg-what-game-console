public class Human {
	static double x = 0, y = 0, s = 0, speed = 0;
	
	public static void MakeHuman(double x, double y, double s, int speed){
		Human.x = x;
		Human.y = y;
		Human.s = s; //Diameter
		Human.speed = speed;
		
	}
	public static void Move(String dir){
		
		//Speed of human(if on road, +1)
		int v = (int) (Road.onRoad(x, y, s/2) ? speed+1 : speed);
		//Where is human going
		switch (dir){
			case "N": 
				//If human won't(!) be on a building after moving, then move
				if(!Building.onBuilding((int)x, (int)(y-v), (int)s)){
					y -= v;
					Stats.status = "Walking";
				}else{
				//If is next to building, lean
					Stats.status = "Leaning";
				}
				break;
			case "S":
				if(!Building.onBuilding((int)x, (int)(y+v), (int)s)){
					y += v;
					Stats.status = "Walking";
				}else{
					Stats.status = "Leaning";
				}
				break;
			case "W":
				if(!Building.onBuilding((int)(x-v), (int)y, (int)s)){
					x -= v;
					Stats.status = "Walking";
				}else{
					Stats.status = "Leaning";
				}
				break;
			case "E":
				if(!Building.onBuilding((int)(x+v), (int)y, (int)s)){
					x += v;
					Stats.status = "Walking";
				}else{
					Stats.status = "Leaning";
				}
				break;
		}
		if(Inside.isInside){
			Stats.status = "In " + Inside.building;
		}
		
	}
	
	public static void CarHit(String dir){
		//When you get hit by a car, get knocked back and lose HP
		
		switch (dir) {
		case "N":
			Human.y-=7;
			break;
		case "S":
			Human.y+=7;
			break;
		case "W":
			Human.x-=7;
			break;
		case "E":
			Human.x+=7;
			break;
		}
		Stats.health-=2;
		
	}
	
	
	
	
	public static double[] DrawHuman(){
		//return mid-circle co-ords and diameter for drawing;
		return new double[]{x + s/2, y + s/2, s};
	}
}
