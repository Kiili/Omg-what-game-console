import java.util.HashMap;
import java.util.Map;

public class Simpl{
	
	public static Map<String, MakeObstacle> thing = new HashMap<String, MakeObstacle>();
	
	public static int counter = 0;
	public static String name = "obj" + Integer.toString(counter);;

	public void make(int x, int width, int height){
		counter++;
		name = "obj" + Integer.toString(counter);
		thing.put(name, new MakeObstacle(x, width, height));
		
	}
}
