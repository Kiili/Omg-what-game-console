import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class MakeObstacle {

	private BufferedImage WallBlock;
	public int x, y, height, width; 
		
	public static Map<String, MakeObstacle> thing = new HashMap<String, MakeObstacle>();
		
	//wall counter
	public static int counter = 0;
	
	public static String name = "obj" + Integer.toString(counter);

	//make new wall
	public static void make(int x, int width, int height){
		counter++;
		name = "obj" + Integer.toString(counter);
		thing.put(name, new MakeObstacle(x, width, height));
	}
	
	public MakeObstacle(int x, int width, int height){
		this.x = x;
		this.height = height;
		this.y = Info.ScreenHeight - (Info.ScreenHeight - Info.ground) - this.height;
		this.width = width;
	}
	
	public void MakeObs(Graphics g, ImageObserver o){
		try {
			WallBlock = ImageIO.read(Main.class.getResource("resources/BrickBlock.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = y; i < height + y; i += 50){
			for(int j = x; j < x + width; j += 50){
				
				if(j + 50 > width + x){
					g.drawImage(WallBlock, j, i, width - (j - x), 50, o);
				}else{
					g.drawImage(WallBlock, j, i, o);
				}
			}
		}
	}
	
	public void CollisionDetector(){
		
		
		if(x <= Info.x + (0.5*Info.dia) && x + width >= Info.x + (0.5*Info.dia) && Info.y + Info.dia >= y){
			
			Info.y = y - Info.dia + 1;
			Info.yV = Info.yV * (- Info.BounceRatio);
			
		
		}else if(x < Info.x + Info.dia && y < Info.y + Info.dia && x + width > Info.x){
			//sideways bounce
			Info.xV = -Info.xV;
		}
		



		//TODO COLLISION






	}
}
