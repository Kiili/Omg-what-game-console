import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MainFrame extends JPanel{
	
	
	private BufferedImage GroundBlock, SkyBlock;
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBounds(0, 0, Info.ScreenWidth - 340, Info.ScreenHeight);
		
		ImageObserver o = this; // for MakeObs(g, o)
		try {
			//Make pictures
			SkyBlock = ImageIO.read(Main.class.getResource("resources/SkyBlock.png"));
			GroundBlock = ImageIO.read(Main.class.getResource("resources/GroundBlock.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < Info.ScreenWidth - 340; i += 100){
		//Backround
			g.drawImage(SkyBlock, i, 0, this);
		}
		
		for(int i = 1; i < MakeObstacle.counter + 1; i++){
		//Wall
			MakeObstacle.thing.get("obj" + Integer.toString(i)).MakeObs(g, o);
		}
		
		if(Info.previewWall){
		//Preview Wall
			g.setColor(Color.RED);
			g.fillRect(Info.Wx, Info.ground - Info.Wheight, Info.Wwidth, Info.Wheight);
			Info.previewWall = false;
		}
		
		for(int i = 0; i < Info.ScreenWidth - 340; i += 100){
		//Ground
			g.drawImage(GroundBlock, i, Info.ground, this);
		}
		
		//ball
		g.setColor(Color.YELLOW);
		g.fillOval(Info.x, Info.y, Info.dia, Info.dia);
	}

	public static void calculations(){
		//moving
		Info.y+=Info.yV;
		Info.x+=Info.xV;
		
		
		for(int i = 0; i <= MakeObstacle.counter ; i++){
			if(i > 0){
				MakeObstacle.thing.get("obj" + Integer.toString(i)).CollisionDetector();
			}
		}
		
		if(Info.y > Info.ground - Info.dia){
			//bounce y
			Info.y = Info.ground - Info.dia;
			Info.yV = Info.yV * (- Info.BounceRatio);
		}
		
		if(Info.bounce){
			//normal falling
			Info.yV += Info.GravityConstant;
			Info.GravityConstant = 1.01 * Info.GravityConstant;
			
		}
			
		if(Info.yV < 5 && Info.yV > 0 && Info.y == (Info.ground - Info.dia)){
			Info.bounce = false;
			Info.yV = 0;
		}
		
		//decrement of xV
		if(Info.xV != 0){
			Info.xV -= Info.xV * Info.RollRatio;
		}
			
		if(Info.xV < 1 && Info.xV > -1 ){
			Info.move = false;
		}
		
		if(!Info.move && !Info.bounce){
			Info.stand = true;
		}
		
		if(Info.stand){
			Info.StandDelay--;
		}
		
		if(Info.StandDelay == 0){
			Info.end = true;
		}
		
		
		
		if(!Info.end){
			NextFrame();
		}else{
			Info.TimerUse = false;
		}
	}
	
	public static void NextFrame(){
		Main.IntroBox.remove(intro.GraphicsFrame);
    	Main.IntroBox.revalidate();
    	Main.IntroBox.repaint();
    	Main.IntroBox.add(intro.GraphicsFrame);
	}	
}
