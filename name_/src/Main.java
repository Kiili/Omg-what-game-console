import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")

public class Main {
	
	public static GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
	public static GraphicsDevice device = env.getDefaultScreenDevice();
	public static JFrame frame = new JFrame();
	public static JPanel panel = new JPanel();
	
	public static final int UserIputPanelWidth = 400, ExitPanelHeight = 70, BigButtonWidth = UserIputPanelWidth - 100,
			SmallButtonWidth = UserIputPanelWidth - 200, ButtonHeight = 100;
	
	public static void main(String args[]){
		System.out.println("Starting game");
		frame.setUndecorated(true);
		frame.setResizable(false);
		
		device.setFullScreenWindow(frame);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    frame.setLayout(null);
	    
	    frame.setVisible(true);

	    //Initializes maingame panel
	    frame.add(getPanel());

		//Adds info panel
		frame.add(infoPanel());
	   
	    CharacterControl.StartGameCycle();
	}

	public static void ReDraw(){
		frame.repaint();
	}
	
	public static JPanel getPanel(){
		Main.panel = new JPanel() {

			@Override
            public void paintComponent(Graphics g) {
				
                super.paintComponent(g);
                if(Inside.isInside){
                	panel.add(Inside.getPanel());
                }else{
                	new Draw(g);
                }
            }
        };
        panel.setSize(frame.getWidth()-UserIputPanelWidth, frame.getHeight());
        panel.setLocation(0, 0);
		return panel;
	}
	
	public static JPanel infoPanel(){
		

		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(UserIputPanelWidth, frame.getHeight());
		panel.setLocation(frame.getWidth()-UserIputPanelWidth, 0);
		panel.setBackground(new Color (51, 153, 102));
		
		JLabel Menu = new JLabel("Menu", SwingConstants.CENTER);
		Menu.setSize(350, ExitPanelHeight);
		Menu.setFont(new Font("Serif", Font.PLAIN, 50));
		
		panel.add(Menu);
		panel.add(ExitButton());
		panel.add(UserInput.Display());

		return panel;
	}
	
	public static JButton ExitButton(){
		
		int size = ExitPanelHeight - 20;
	    JButton button = new JButton("X");
	    button.setSize(size, size);
	    button.setLocation(UserIputPanelWidth-size, 0);
	    button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
	    });

	    return button;

	}
	
}
