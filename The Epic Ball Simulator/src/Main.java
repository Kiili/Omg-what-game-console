import javax.swing.*;

public class Main{ 
	
	
	public static intro IntroBox = new intro();
	public static TheTimer Timerstarter = new TheTimer();
	
	public static void main(String[] args) {
		
		Timerstarter.TimerStart();
		
		IntroBox.setVisible(true);
		IntroBox.setResizable(false);
		IntroBox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		IntroBox.setSize((int)Info.ScreenWidth, (int)Info.ScreenHeight);
		IntroBox.setLocation(0, 50);
		
		/*
		
		*/
	}
}
