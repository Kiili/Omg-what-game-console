import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Inside {
	
	public static Boolean isInside = false;
	public static String building = "";
	
	public static void init(){
		Bank.init();
	}
	
	public static JPanel getPanel(){
		switch (building){
			case "Bank":
				return Bank.getPanel();
		}
		return new JPanel();
	}
	public static Font getFont(int x){
		return new Font(Font.SERIF, Font.PLAIN, x);
	}
	
	public static void Enter(String s){
		isInside = true;
		building = s;
	}
	
	public static void Leave(){
		isInside = false;
	}
}
