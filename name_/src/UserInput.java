import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UserInput {
	public static JPanel UserInputPanel = new JPanel();
	public static String Page = "none";
	public static boolean EditMode = true;
	public static String BuildingAddingMode = "location", TreeAddingMode = "location", CarAddingMode = "location";
	private static JTextField WrittenInputField;
	private static JLabel StatLabel = new JLabel("");
	private static JLabel InstructionLabel = new JLabel("", SwingConstants.CENTER);
	private static JButton CancelButton = new JButton("Cancel");
	private static JLabel SpeedLabel = new JLabel("", SwingConstants.CENTER);
	private static Listener action = new Listener();
	private static JButton ModeChange = new JButton();
	
	public static void initialize() {

		UserInputPanel.setLayout(null);
		
		InstructionLabel.setBounds((Main.UserIputPanelWidth - Main.BigButtonWidth)/2, 100, 
				Main.BigButtonWidth, Main.ButtonHeight);
		InstructionLabel.setForeground(new Color(0, 0, 255));
		
		CancelButton.setBounds((Main.UserIputPanelWidth - Main.BigButtonWidth)/2, Main.frame.getHeight()-180, 
				Main.BigButtonWidth, Main.ButtonHeight);
		CancelButton.setFont(getFont(50));
		CancelButton.addActionListener(action);
		
		SpeedLabel.setFont(getFont(45));
		SpeedLabel.setBounds((Main.UserIputPanelWidth - Main.BigButtonWidth)/2, 450, 
				Main.BigButtonWidth, Main.ButtonHeight);
		SpeedLabel.setForeground(new Color(0, 0, 255));
		
		
		
		
		
		
	}
	
	public static JPanel Display(){
		
		switch(Page){
		
			case "none" : 
				UserInputPanel.removeAll();
				ModeChange.setBounds((Main.UserIputPanelWidth - Main.BigButtonWidth)/2, 
						Main.frame.getHeight()-180, Main.BigButtonWidth, Main.ButtonHeight);
				ModeChange.setFont(getFont(50));
				ModeChange.addActionListener(action);
				if(!Inside.isInside){
					ModeChange.setText("Build Mode");
				}else{
					ModeChange.setText("Exit");
				}
				
				EditMode = false;
				
				StatLabel.setBounds(40, 50, 400, 400);
				StatLabel.setFont(getFont(30));
				StatLabel.setText("<html><body>"
						+ "Health: " + Stats.health + "<br>"
						+ "Time: " + Stats.time + "<br>"
						+ "Money: " + Math.round(Stats.money) + "<br>"
						+ "Stamina: " + Math.round(Stats.stamina) + "<br>"
						+ "Happyness: " + Stats.happyness + "<br>"
						+ "Intelligence: " + Math.round(Stats.intelligence) + "<br>"
						+ "Strenght: " + Stats.strenght + "<br>"
						+ "Sleepiness: " + Math.round(Stats.sleepiness) + "<br>"
						+ "Status: " + Stats.status + "<br>"
						+ "</body></html>");
				
				UserInputPanel.add(ModeChange);
				UserInputPanel.add(StatLabel);
				
				break;
				
			case "question" :

				UserInputPanel.removeAll();
				
				EditMode = true;
				
				JLabel question = new JLabel("What to add?", SwingConstants.CENTER);
				question.setFont(getFont(60));
				question.setBounds(0, 0, Main.UserIputPanelWidth, Main.ButtonHeight);
				
				JButton Road, Car, building, Tree, Back;
				
				Road = new JButton("Road");
				Road.setBounds((Main.UserIputPanelWidth - Main.SmallButtonWidth)/2, 150, 
						Main.SmallButtonWidth, Main.ButtonHeight);
				Road.setFont(getFont(50));

				Car = new JButton("Car");
				Car.setBounds((Main.UserIputPanelWidth - Main.SmallButtonWidth)/2, 300, 
						Main.SmallButtonWidth, Main.ButtonHeight);
				Car.setFont(getFont(50));

				building = new JButton("Building");
				building.setBounds((Main.UserIputPanelWidth - Main.SmallButtonWidth)/2, 450,
						Main.SmallButtonWidth, Main.ButtonHeight);
				building.setFont(getFont(40));
				
				Tree = new JButton("Tree");
				Tree.setBounds((Main.UserIputPanelWidth - Main.SmallButtonWidth)/2, 600, 
						Main.SmallButtonWidth, Main.ButtonHeight);
				Tree.setFont(getFont(50));
				
				Back = new JButton("Play Mode");
				Back.setBounds((Main.UserIputPanelWidth - Main.BigButtonWidth)/2, Main.frame.getHeight()-180, 
						Main.BigButtonWidth, Main.ButtonHeight);
				Back.setFont(getFont(45));
				
				UserInputPanel.add(question);
				UserInputPanel.add(Road);
				UserInputPanel.add(Car);
				UserInputPanel.add(building);
				UserInputPanel.add(Tree);
				UserInputPanel.add(Back);
				
				Road.addActionListener(action);
				Car.addActionListener(action);
				building.addActionListener(action);
				Tree.addActionListener(action);
				Back.addActionListener(action);
				
				break;
			case "AddRoad":
				
				UserInputPanel.removeAll();
				UserInputPanel.add(CancelButton);
				
				InstructionLabel.setText("Place Road");
				InstructionLabel.setFont(getFont(50));
				
				UserInputPanel.add(InstructionLabel);
				UserInputPanel.add(getButtonPicture(200));
				
				break;
			case "AddCar":
				
				
				JButton CarAddingBackButton = new JButton("Back");
				CarAddingBackButton.setFont(getFont(50));
				CarAddingBackButton.setBounds((Main.UserIputPanelWidth - Main.BigButtonWidth)/2, Main.frame.getHeight()-330, Main.BigButtonWidth, Main.ButtonHeight);
				CarAddingBackButton.addActionListener(action);
				
				UserInputPanel.removeAll();
				
				if(!(CarAddingMode == "location")){
					UserInputPanel.add(CarAddingBackButton);
				}
				
				switch (CarAddingMode){
					case "location" :
						InstructionLabel.setText("Set car location");
						InstructionLabel.setFont(getFont(45));
						UserInputPanel.add(getButtonPicture(200));
						
						break;
					case "speed" :
						InstructionLabel.setText("Set car speed");
						InstructionLabel.setFont(getFont(45));
						UserInputPanel.add(getTwoButtonPicture(200));
						
						
						SpeedLabel.setText(Integer.toString(Cars.TempSpeed));
						UserInputPanel.add(SpeedLabel);
						
						break;
					case "direction" :
						InstructionLabel.setText("Set driving direction");
						InstructionLabel.setFont(getFont(35));
						UserInputPanel.add(getButtonPicture(200));
						break;
				}
				
				UserInputPanel.add(CancelButton);
				UserInputPanel.add(InstructionLabel);
				
				break;
			case "AddBuilding":
				
				JButton BuildingAddingBackButton = new JButton("Back");
				BuildingAddingBackButton.setFont(getFont(50));
				BuildingAddingBackButton.setBounds((Main.UserIputPanelWidth - Main.BigButtonWidth)/2, Main.frame.getHeight()-330, Main.BigButtonWidth, Main.ButtonHeight);
				BuildingAddingBackButton.addActionListener(action);
				
				UserInputPanel.removeAll();
				
				if(!(BuildingAddingMode == "location")){
					UserInputPanel.add(BuildingAddingBackButton);
				}
				
				switch(BuildingAddingMode){
					case "location" :
						
						InstructionLabel.setText("Place building");
						InstructionLabel.setFont(getFont(45));
						
						UserInputPanel.add(getButtonPicture(200));
						
						break;
					case "size" :
						
						InstructionLabel.setText("Resize building");
						InstructionLabel.setFont(getFont(45));
						
						UserInputPanel.add(getButtonPicture(200));
						
						break;
					case "name" :
						
						InstructionLabel.setText("Set name");
						InstructionLabel.setFont(getFont(45));
						
						WrittenInputField = new JTextField(Building.TemplateName, 50);
						WrittenInputField.setBounds((Main.UserIputPanelWidth - Main.BigButtonWidth)/2, 200, Main.BigButtonWidth, Main.ButtonHeight);
						WrittenInputField.setFont(getFont(50));
						WrittenInputField.addActionListener(action);
						
						UserInputPanel.add(WrittenInputField);
						UserInputPanel.add(getEnterPicture((Main.UserIputPanelWidth - 130)/2, 350));
						
						break;
					case "doorLocation" :
						
						InstructionLabel.setText("Set door location");
						InstructionLabel.setFont(getFont(40));
						
						UserInputPanel.add(getButtonPicture(200));
						
						break;
				}
				
				UserInputPanel.add(CancelButton);
				UserInputPanel.add(InstructionLabel);
				
				break;
				
			case "AddTree":
				
				UserInputPanel.removeAll();
				
				InstructionLabel.setFont(getFont(40));
				
				switch (TreeAddingMode){
					case "location" :
						InstructionLabel.setText("Set tree location");
						
						break;
					case "size" :
						InstructionLabel.setText("Set tree size");
						JButton TreeAddingBackButton = new JButton("Back");
						TreeAddingBackButton.setFont(getFont(50));
						TreeAddingBackButton.setBounds((Main.UserIputPanelWidth - Main.BigButtonWidth)/2, 
								Main.frame.getHeight()-330, Main.BigButtonWidth, Main.ButtonHeight);
						TreeAddingBackButton.addActionListener(action);
						
						UserInputPanel.add(TreeAddingBackButton);
						
						break;
				}
				
				UserInputPanel.add(getButtonPicture(200));
				UserInputPanel.add(InstructionLabel);
				UserInputPanel.add(CancelButton);
				
				break;
		}
		
		UserInputPanel.setBounds(0, Main.ExitPanelHeight, Main.UserIputPanelWidth, Main.frame.getHeight()-70);
		UserInputPanel.setBackground(new Color (230, 230, 255));
		return UserInputPanel;
	}
	
	public static JLabel getButtonPicture(int y){
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(Main.class.getResource("resources/BUTTONS.png"));
		} catch (IOException e) {}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(0, y, Main.UserIputPanelWidth, Main.UserIputPanelWidth-50);
		return picLabel;
	}
	
	public static JLabel getTwoButtonPicture(int y){
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(Main.class.getResource("resources/TWOBUTTONS.png"));
		} catch (IOException e) {}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(0, y, Main.UserIputPanelWidth, Main.UserIputPanelWidth-50);
		return picLabel;
	}
	
	public static JLabel getEnterPicture(int x, int y){
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(Main.class.getResource("resources/ENTERBUTTON.JPG"));
		} catch (IOException e) {}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(x, y, (Main.UserIputPanelWidth-140)/2, 100);
		return picLabel;
	}
	
	public static Font getFont(int x){
		return new Font(Font.SERIF, Font.PLAIN, x);
	}
	
	public static void RefreshPanel(){
		Display();
	}

	public static class Listener implements ActionListener{
		

		public void actionPerformed(ActionEvent done){
			
			String WrittenInput = String.format("%s", done.getActionCommand());
			
			if(done.getActionCommand()=="Build Mode"){
				Page = "question";
				EditMode = true;
				RefreshPanel();
				
			}else if(done.getActionCommand()=="Road"){
				Page = "AddRoad";
				RefreshPanel();
				
			}else if(done.getActionCommand()=="Exit"){
				Inside.isInside = false;
				Main.panel.removeAll();
				RefreshPanel();
				
			}else if(done.getActionCommand()=="Car"){
				Page = "AddCar";
				RefreshPanel();
				
			}else if(done.getActionCommand()=="Building"){
				Page = "AddBuilding";
				RefreshPanel();
				
			}else if(done.getActionCommand()=="Tree"){
				Page = "AddTree";
				RefreshPanel();
				
			}else if(done.getActionCommand()=="Play Mode"){
				Page = "none";
				EditMode = false;
				RefreshPanel();
				
			}else if(done.getActionCommand()=="Cancel"){
				Page = "question";
				BuildingAddingMode = "location";
				TreeAddingMode = "location";
				CarAddingMode = "location";
				EditMode = false;
				RefreshPanel();
				
			}else if(done.getActionCommand()=="Back"){
				if(Page == "AddBuilding"){
					switch (BuildingAddingMode){
						case "size" :
							BuildingAddingMode = "location";
							break;
						case "name" :
							BuildingAddingMode = "size";
							break;
						case "doorLocation" :
							BuildingAddingMode = "name";
							break;
					}
					RefreshPanel();
				}else if(Page == "AddTree"){
					TreeAddingMode = "location";
				}else if(Page == "AddCar"){
					switch (CarAddingMode){
						case "speed" :
							CarAddingMode = "location";
							break;	
						case "direction" :
							CarAddingMode = "speed";
							break;	
					}
				}
				
				
				RefreshPanel();
				
			}else if(done.getSource()==WrittenInputField){
				Building.TemplateName = WrittenInput;
			}
		}
	}

	
}
