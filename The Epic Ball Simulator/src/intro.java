import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("static-access")

public class intro extends JFrame {
	private JLabel dia, xh, xv, bounce, roll, gravy, wallx, wallw, wallh, initx, inity;
	private JButton okay, addOB, reset, clearwalls;
	private JSlider s3, s4, s5, s6, s7, s8, s9, s10, s11, s1, s2;
	private JPanel Ballx, Bally, BallDia, BallxV, BallyV, BallBRatio, BallRRatio, BallGravity, Wallx, WallWidth, WallHeight, Buttons, PANEL;
	public static MainFrame GraphicsFrame = new MainFrame();
	public intro(){
		super("THE ALMIGHTY EPIC BALL SIMULATOR");
		setLayout(null);
		
		add(GraphicsFrame);
		GraphicsFrame.setBounds(0, 0, Info.ScreenWidth - 340, Info.ScreenHeight);
		
		initx= new JLabel ("Ball initial X position: ", SwingConstants.CENTER);
		s1 =    new JSlider(JSlider.HORIZONTAL, 0, Info.ScreenWidth - 340, 10);
		inity= new JLabel ("Ball initial Y position: ", SwingConstants.CENTER);
		s2 =    new JSlider(JSlider.HORIZONTAL, 0, Info.ground - Info.dia, 50);
		dia = new JLabel ("Ball diameter: ",     SwingConstants.CENTER);
		s3 =     new JSlider(JSlider.HORIZONTAL, 300, 30);
		xh = new JLabel ("Horizontal speed: ",  SwingConstants.CENTER);
		s4 =     new JSlider(JSlider.HORIZONTAL, -240, 240, 40);
		xv = new JLabel ("Vertical speed: ",    SwingConstants.CENTER);
		s5 =     new JSlider(JSlider.HORIZONTAL, -100, 250, 0);
		bounce = new JLabel ("Bounce Ratio: ",      SwingConstants.CENTER);
		s6 =     new JSlider(JSlider.HORIZONTAL, 0, 100, 40);
		roll = new JLabel ("Roll Ratio: ",        SwingConstants.CENTER);
		s7 =     new JSlider(JSlider.HORIZONTAL, 0, 20, 4);
		gravy= new JLabel ("Gravity Strenght: ",  SwingConstants.CENTER);
		s8 =     new JSlider(JSlider.HORIZONTAL, 0, 200, 98);
		wallx =  new JLabel ("Wall x coordinate: ", SwingConstants.CENTER);
		s9 =     new JSlider(JSlider.HORIZONTAL, 0, (1600), Info.Wx);
		wallw =  new JLabel ("Wall width: ",        SwingConstants.CENTER);
		s10 =     new JSlider(JSlider.HORIZONTAL, 0, Info.ground, 250);
		wallh =  new JLabel ("Wall height: ",       SwingConstants.CENTER);
		s11 =     new JSlider(JSlider.HORIZONTAL, 0, 250, 50);
		
		
		addOB =  new JButton("Add wall");
		okay =   new JButton("Go");
		reset =  new JButton("Return Ball & Stop");
		clearwalls = new JButton("Clear Walls");
		
	
		JSlider sliders[] = {s3, s4, s5, s6, s7, s8, s9, s10, s11, s1, s2};
		for(int i = 0; i < sliders.length; i++){
			sliders[i].setPaintTicks(true);
			sliders[i].setPaintLabels(true);
		}
		
		s1.setMajorTickSpacing(300);
		s1.setMinorTickSpacing(50);

		s2.setMajorTickSpacing(100);
		s2.setMinorTickSpacing(25);
		
		s3.setMajorTickSpacing(50);
		s3.setMinorTickSpacing(10);

		s4.setMajorTickSpacing(80);
		s4.setMinorTickSpacing(20);

		s5.setMajorTickSpacing(50);
		s5.setMinorTickSpacing(10);
		
		s6.setMajorTickSpacing(20);
		s6.setMinorTickSpacing(5);

		s7.setMajorTickSpacing(4);
		s7.setMinorTickSpacing(1);
		
		s8.setMajorTickSpacing(40);
		s8.setMinorTickSpacing(10);

		s9.setMajorTickSpacing(300);
		s9.setMinorTickSpacing(50);

		s10.setMajorTickSpacing(100);
		s10.setMinorTickSpacing(25);

		s11.setMajorTickSpacing(50);
		s11.setMinorTickSpacing(25);
		


		
		Ballx = new JPanel();
		Ballx.add(initx);
		Ballx.add(s1);
		Ballx.setLayout(new BoxLayout(Ballx, BoxLayout.Y_AXIS));
		Ballx.setPreferredSize(new Dimension(250, 60));
		
		Bally = new JPanel();
		Bally.add(inity);
		Bally.add(s2);
		Bally.setLayout(new BoxLayout(Bally, BoxLayout.Y_AXIS));
		Bally.setPreferredSize(new Dimension(250, 60));
		
		BallDia = new JPanel();
		BallDia.add(dia);
		BallDia.add(s3);
		BallDia.setLayout(new BoxLayout(BallDia, BoxLayout.Y_AXIS));
		BallDia.setPreferredSize(new Dimension(250, 60));
		
		BallxV = new JPanel();
		BallxV.add(xh);
		BallxV.add(s4);
		BallxV.setLayout(new BoxLayout(BallxV, BoxLayout.Y_AXIS));
		BallxV.setPreferredSize(new Dimension(250, 60));
		
		BallyV = new JPanel();
		BallyV.add(xv);
		BallyV.add(s5);
		BallyV.setLayout(new BoxLayout(BallyV, BoxLayout.Y_AXIS));
		BallyV.setPreferredSize(new Dimension(250, 60));
		
		BallBRatio = new JPanel();
		BallBRatio.add(bounce);
		BallBRatio.add(s6);
		BallBRatio.setLayout(new BoxLayout(BallBRatio, BoxLayout.Y_AXIS));
		BallBRatio.setPreferredSize(new Dimension(250, 60));
		
		BallRRatio = new JPanel();
		BallRRatio.add(roll);
		BallRRatio.add(s7);
		BallRRatio.setLayout(new BoxLayout(BallRRatio, BoxLayout.Y_AXIS));
		BallRRatio.setPreferredSize(new Dimension(250, 60));
		
		BallGravity = new JPanel();
		BallGravity.add(gravy);
		BallGravity.add(s8);
		BallGravity.setLayout(new BoxLayout(BallGravity, BoxLayout.Y_AXIS));
		BallGravity.setPreferredSize(new Dimension(250, 60));
		
		Wallx = new JPanel();
		Wallx.add(wallx);
		Wallx.add(s9);
		Wallx.setLayout(new BoxLayout(Wallx, BoxLayout.Y_AXIS));
		Wallx.setPreferredSize(new Dimension(250, 60));
		
		WallWidth = new JPanel();
		WallWidth.add(wallh);
		WallWidth.add(s10);
		WallWidth.setLayout(new BoxLayout(WallWidth, BoxLayout.Y_AXIS));
		WallWidth.setPreferredSize(new Dimension(250, 60));
		
		WallHeight = new JPanel();
		WallHeight.add(wallw);
		WallHeight.add(s11);
		WallHeight.setLayout(new BoxLayout(WallHeight, BoxLayout.Y_AXIS));
		WallHeight.setPreferredSize(new Dimension(250, 60));
		
		Buttons = new JPanel();
		Buttons.add(addOB);
		Buttons.add(okay);
		Buttons.add(reset);
		//TODO CLEARWALLS
		//Buttons.add(clearwalls);
		Buttons.setLayout(new BoxLayout(Buttons, BoxLayout.X_AXIS));
		Buttons.setPreferredSize(new Dimension(300, 60));
		
		
		PANEL = new JPanel();
		
		PANEL.add(Ballx);
		PANEL.add(Bally);
		PANEL.add(BallDia);
		PANEL.add(BallxV);
		PANEL.add(BallyV);
		PANEL.add(BallBRatio);
		PANEL.add(BallRRatio);
		PANEL.add(BallGravity);
		PANEL.add(Wallx);
		PANEL.add(WallWidth);
		PANEL.add(WallHeight);
		PANEL.add(Buttons);
		
		PANEL.setLayout(new BoxLayout(PANEL, BoxLayout.Y_AXIS));
		PANEL.setBounds(Info.ScreenWidth - 320, 0, 300, Info.ScreenHeight);
		
		add(PANEL);

		
		Listener action = new Listener();
		
		okay.addActionListener(action);
		addOB.addActionListener(action);
		reset.addActionListener(action);

		MainFrame f = new MainFrame();
		
		s1.addChangeListener(new ChangeListener() {public void stateChanged(ChangeEvent e) {int value = s1.getValue();
		Info.initx = value;
		Info.GravityConstant = Info.initGravityConstant;
		if(!Info.TimerUse){
			Info.x = value;
		}else{
			Info.x = value;
			Info.bounce = true;
			Info.end = false;
			Info.TimerUse = true;
		 	Info.move = true;
		 	Info.StandDelay = 100;
		}

		f.NextFrame();
		}});
		s2.addChangeListener(new ChangeListener() {public void stateChanged(ChangeEvent e) {int value = s2.getValue();
			Info.inity = value;
			Info.y = value;
			if(Info.Start){
				Info.bounce = true;
				Info.end = false;
				Info.TimerUse = true;
				Info.move = true;
				Info.StandDelay = 100;
				Info.GravityConstant = Info.initGravityConstant;
			}
			f.NextFrame();
		}});
		s3.addChangeListener(new ChangeListener() {public void stateChanged(ChangeEvent e) {int value = s3.getValue();
			Info.dia = value; 	
			if(Info.TimerUse){
				if(!Info.bounce){
					Info.GravityConstant = Info.initGravityConstant;
				}
		 		Info.bounce = true;
		 		Info.end = false;
		 		Info.TimerUse = true;
		 		Info.move = true;
		 		Info.StandDelay = 100;
			}
		 	f.NextFrame();
		}});
		s4.addChangeListener(new ChangeListener() {public void stateChanged(ChangeEvent e) {int value = s4.getValue();
		 	Info.initxV = value;
		 	f.NextFrame();
		}});
		s5.addChangeListener(new ChangeListener() {public void stateChanged(ChangeEvent e) {int value = s5.getValue();
			Info.inityV = value;
			f.NextFrame();
		}});
		s6.addChangeListener(new ChangeListener() {public void stateChanged(ChangeEvent e) {Double value = (double) s6.getValue();
			Info.BounceRatio = value/100;
			f.NextFrame();
		}});
		s7.addChangeListener(new ChangeListener() {public void stateChanged(ChangeEvent e) {Double value = (double) s7.getValue();
			Info.RollRatio = value/100;
			f.NextFrame();
		}});
		s8.addChangeListener(new ChangeListener() {public void stateChanged(ChangeEvent e) {Double value = (double) s8.getValue();
			Info.initGravityConstant = value/100;
			f.NextFrame();
		}});
		s9.addChangeListener(new ChangeListener() {public void stateChanged(ChangeEvent e) {int value = s9.getValue();
			Info.Wx = value;
			Info.previewWall = true;
			f.NextFrame();
		}});
		s10.addChangeListener(new ChangeListener() {public void stateChanged(ChangeEvent e) {int value = s10.getValue();
			Info.Wheight = value;
			Info.previewWall = true;
			f.NextFrame();
		}});
		s11.addChangeListener(new ChangeListener() {public void stateChanged(ChangeEvent e) {int value = s11.getValue();
			Info.Wwidth = value;
			Info.previewWall = true;
			f.NextFrame();
		}});

	}
	
	public class Listener implements ActionListener{
		public void actionPerformed(ActionEvent done){
			
			if(done.getActionCommand()=="Return Ball & Stop"){
				
				Info.xV = Info.initxV;
				Info.yV = Info.inityV;
				Info.GravityConstant = Info.initGravityConstant;
				Info.Start = false;
				Info.move = false;
				Info.stand = true;
				Info.end = true;
				Info.bounce = false;
				Info.TimerUse = false;
				Info.StandDelay = 100;
				Info.x = Info.initx;
				Info.y = Info.inity;
				MainFrame.NextFrame();
			}
			
			if(done.getActionCommand()=="Add wall"){
				MakeObstacle.make(Info.Wx, Info.Wwidth, Info.Wheight);
				 MainFrame.NextFrame();
			}
			
			if(done.getActionCommand()=="Go"){
				Run obj = new Run();
				obj.RunAgain();
				Info.Start = true;
				Info.TimerUse = true;
			}
			if(done.getActionCommand()=="Clear Walls"){
				MakeObstacle.counter = 0;
				MakeObstacle.thing.clear();
				
			}
		}
	}
}
