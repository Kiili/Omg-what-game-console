import java.awt.Dimension;
import java.awt.Toolkit;

public class Info{
	
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	
	public static int initx = 10, inity = 200, x = initx, y = inity, dia = 40,
			ScreenHeight = 740, ScreenWidth = (int)screenSize.getWidth();
	
	public static int StandDelay = 10, ground = ScreenHeight - 100, Wwidth = 50, Wheight = 200, Wx = 1100;
	
	public static double initxV = 50, inityV = 0, BounceRatio = 0.4, RollRatio = 0.04, yV = inityV;
	
	public static double xV = initxV, initGravityConstant = 0.98, GravityConstant = initGravityConstant;
	
	public static boolean bounce = true, move = true, stand = false, end = false, TimerUse = false, 
			Start = false, previewWall;

}
