import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bank {
	private static String page = "Banker";
	private static JPanel panel = new JPanel();
	private static Listener action = new Listener();
	private static JButton BackButton = new JButton("Back"), a1 = new JButton(), a2 = new JButton();
	private static JTextField InputField1 = new JTextField("", 5), InputField2 = new JTextField("", 5);
	
	public static void init(){
		
		panel.setSize(Main.frame.getWidth() - Main.UserIputPanelWidth, Main.frame.getHeight());
		panel.setLocation(0, 0);

		BackButton.setBounds(50, Main.frame.getHeight()-150, 350, 100);
		BackButton.setFont(getFont(60));
		
		BackButton.addActionListener(action);
		InputField1.addActionListener(action);
		InputField2.addActionListener(action);
		
		a1.setText("All");
		a1.setBounds(470, 190, 100, 60);
		a1.setFont(getFont(40));
		a1.addActionListener(action);
		
		a2.setText("All");
		a2.setBounds(470, 310, 100, 60);
		a2.setFont(getFont(40));
		a2.addActionListener(action);
		
	}
	
	public static JPanel getPanel(){
		panel.removeAll();
		panel.setLocation(0, 0);
		panel.setSize(Main.frame.getWidth() - Main.UserIputPanelWidth, Main.frame.getHeight());
		panel.add(getBankerPic());
		panel.setLayout(null);
		
		if(page != "Banker"){
			panel.add(BackButton);
		}
		switch (page){
			case "Banker": return Banker();
			case "Loans": return Loans();
			case "Investing": return Investing();
			case "Property": return Property();	
			case "Calculator": return Calculator();
			case "Work": return Work();
			case "Study": return Study();	
			case "Buy admin mode": return Admin();	
		}
		return null;
	}
	
	public static JPanel Banker(){
		ArrayList<JButton> Buttons = new ArrayList<JButton>();
		Buttons.add(new JButton("Loans"));
		Buttons.add(new JButton("Investing"));
		Buttons.add(new JButton("Property"));
		Buttons.add(new JButton("Calculator"));
		Buttons.add(new JButton("Work"));
		Buttons.add(new JButton("Study"));
		Buttons.add(new JButton("Buy admin mode"));
		
		int j = 50;
		for(int i = 0; i < Buttons.size(); i++){
			Buttons.get(i).setFont(getFont(40));
			Buttons.get(i).setBounds(50, j, 350, 100);
			Buttons.get(i).addActionListener(action);
			j+=150;
			panel.add(Buttons.get(i));
		}
		return panel;
	}
	
	public static JPanel Loans(){
		
		InputField1.setBounds(50, 200, 200, 100);
		InputField1.setFont(getFont(50));
		
		JLabel a = new JLabel("");
		a.setBounds(50, 50, 850, 100);
		a.setFont(getFont(50));
		
		JLabel b = new JLabel("€ (Enter)");
		b.setFont(getFont(80));
		b.setBounds(270, 200, 350, 100);
		
		
		if(Math.round(Stats.loan) <= 0){
			a.setText("You can take a loan");
		}else{
			a.setText("You have "+Math.round(Stats.loan)+"€ left to pay");
		}
		
		
		panel.add(InputField1);
		panel.add(a);
		panel.add(b);
		
		return panel;
	}
	
	public static JPanel Investing(){
		
		InputField1.setBounds(240, 170, 200, 100);
		InputField1.setFont(getFont(50));
		
		InputField2.setBounds(240, 290, 200, 100);
		InputField2.setFont(getFont(50));
		
		ArrayList<JButton> Buttons = new ArrayList<JButton>();
		Buttons.add(new JButton("LOW"));
		Buttons.add(new JButton("MED"));
		Buttons.add(new JButton("HI"));
		int j = 50;
		for(int i = 0; i < Buttons.size(); i++){
			Buttons.get(i).setBounds(j, 460, 100, 70);
			j+=150;
			Buttons.get(i).setFont(getFont(20));
			if(Buttons.get(i).getText() == Stats.InvestRisk){
				Buttons.get(i).setEnabled(false);
			}else{
				Buttons.get(i).setEnabled(true);
			}
			Buttons.get(i).addActionListener(action);
			panel.add(Buttons.get(i));
		}
		
		JButton b = new JButton("Study investment: " + Math.round(((Math.pow(Stats.investLevel, 2)*462)+1000)) + "€");
		b.setFont(getFont(30));
		b.setBounds(50, 600, 400, 100);
		
		//Listener here bcs int in the button's text
		b.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  if(Stats.money >= Math.round(((Math.pow(Stats.investLevel, 2)*462)+1000))){
						Stats.money -= Math.round(((Math.pow(Stats.investLevel, 2)*462)+1000));
						Stats.investLevel++;
						RefreshPanel();
					}
			  }
		});
		
		ArrayList<JLabel> Labels = new ArrayList<JLabel>();
		Labels.add(new JLabel("Stock worth: " + Math.round(Stats.invested) + "�"));
		Labels.add(new JLabel("Deposit"));
		Labels.add(new JLabel("Withdraw"));
		Labels.add(new JLabel("Level: "+ Stats.investLevel));
		Labels.add(new JLabel("Profit/Loss Ratio: " + (double)Math.round((0.4+(0.01*Stats.investLevel)) * 100) / 100));
		Labels.add(new JLabel("Risk:"));
		
		for(int i = 0; i < Labels.size(); i++){
			Labels.get(i).setFont(getFont(40));
			
			//Cast see ratio unless atleast lvl 2
			if(!(Stats.investLevel < 2)){
				panel.add(Labels.get(i));
			}else{
				if(i!=4){
					panel.add(Labels.get(i));
				}
			}
		}
		
		Labels.get(0).setBounds(50, 50, 500, 100);
		Labels.get(1).setBounds(50, 170, 500, 100);
		Labels.get(2).setBounds(50, 290, 500, 100);
		Labels.get(3).setBounds(170, 690, 500, 100);
		Labels.get(4).setBounds(50, 800, 500, 100);
		Labels.get(5).setBounds(210, 380, 500, 100);
		
		panel.add(a1);
		panel.add(a2);
		
		panel.add(b);
		panel.add(InputField1);
		panel.add(InputField2);
		
		return panel;
	}
	
	public static void Investments(){
		//AVG profit to loss ratio
		double PLR = 0.5+(0.01*Stats.investLevel);
		double risk;
		
		switch (Stats.InvestRisk){
			case "LOW":
				risk= 0.1;
				break;
			case "MED":
				risk= 0.2;
				break;
			case "HI":
				risk= 0.3;
				break;
			default: 
				risk = 0.0;
				break;
		}
		
		double x = Math.random();
		
		//If you get profit
		if(x <= (PLR)){
			while(true){
				x = Math.random();
				if(x <= risk){
					Stats.invested += (x)*Stats.invested;
					break;
				}
			}
		}else{
			while(true){
				x = Math.random();
				if(x <= risk){
					Stats.invested -= (x)*Stats.invested;
					break;
				}
			}
		}
		if(Stats.invested <= 0){
			Stats.invested = 0;
		}
	}
	
	public static JPanel Property(){
		
		return panel;
	}
	
	public static JPanel Calculator(){
		
		return panel;
	}
	
	public static JPanel Work(){
		
		return panel;
	}
	
	public static JPanel Study(){
		
		JLabel a = new JLabel("Study banking");
		a.setBounds(50, 50, 850, 100);
		a.setFont(getFont(50));
		
		JButton c = new JButton("Take a course: " + Math.round(2*(Math.pow(Stats.bankCourses, 2)+10)) + "�");
		c.setBounds(50, 200, 500, 100);
		c.setFont(getFont(40));
		
		if(Stats.bankCourses == 38){
			c.setEnabled(false);
			c.setText("Cannot take a course");
		}else{
			c.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					int x = (int) Math.round(2*(Math.pow(Stats.bankCourses, 2)+10));
					if(Stats.money >= x){
						Stats.intelligence+=0.4;
						Stats.money -= x;
						Stats.bankCourses++;
						RefreshPanel();
					}
				}
			});
		}
		
		JLabel b = new JLabel("Completed courses: " + Stats.bankCourses + "/38");
		b.setBounds(50, 700, 850, 100);
		b.setFont(getFont(50));
		
		JLabel d = new JLabel("");
		d.setFont(getFont(40));
		d.setBounds(50, 770, 850, 100);
		
		if(Stats.bankCourses < 5){
			d.setText("Learner");
		}else if (Stats.bankCourses < 15){
			d.setText("Beginner");
		}else if (Stats.bankCourses < 30){
			d.setText("Intermediate");
		}else if (Stats.bankCourses < 37){
			d.setText("Advanced");
		}else{
			d.setText("Expert");
		}
		
		panel.add(a);
		panel.add(b);
		panel.add(c);
		panel.add(d);
		
		return panel;
	}
	
	public static JPanel Admin(){
		return panel;
	}
	
	public static class Listener implements ActionListener{
		public void actionPerformed(ActionEvent done){
			
			String WrittenInput = String.format("%s", done.getActionCommand());
			
			if(done.getActionCommand()=="Back"){
				page = "Banker";
				RefreshPanel();
			}
			
			switch (page){
				case "Banker":
					switch(done.getActionCommand()){
						case "Loans":
							page = "Loans";
							break;
						case "Investing":
							page = "Investing";
							break;
						case "Property":
							page = "Property";		
							break;
						case "Calculator":
							page = "Calculator";
							break;
						case "Work":
							page = "Work";
							break;
						case "Study":
							page = "Study";
							break;
						case "Buy admin mode":
							page = "Buy admin mode";
							break;
					}
					RefreshPanel();
					break;
					
				case "Loans":
					if(done.getSource()==InputField1){
						double x = Double.parseDouble(WrittenInput);
						if(Math.round(Stats.loan) <= 0){
							Stats.loan += (x*1.1);
							Stats.money += x;
						}else{
							Stats.loan -= x;
							Stats.money -= x;
						}
						InputField1.setText("");
						page = "Banker";
						RefreshPanel();
					}
					break;
					
				case "Investing":
					
					if(done.getSource()==InputField1){
						double x = Double.parseDouble(WrittenInput);
						if(Stats.money >= x){
							Stats.money -= x;
							Stats.invested += x;
							InputField1.setText("");
							RefreshPanel();
						}else{
							InputField1.setText("");
						}
					}
					
					if(done.getSource()==InputField2){
						double x = Double.parseDouble(WrittenInput);
						if(Stats.invested >= x){
							Stats.money += x;
							Stats.invested -= x;
							InputField2.setText("");
							RefreshPanel();
						}else{
							InputField2.setText("");
						}
					}
					switch(done.getActionCommand()){
						case "LOW":
							Stats.InvestRisk = "LOW";
							RefreshPanel();
							break;
						case "MED":
							Stats.InvestRisk = "MED";
							RefreshPanel();
							break;
						case "HI":
							Stats.InvestRisk = "HI";
							RefreshPanel();
							break;
						case "All":
							if(done.getSource() == a1){
								Stats.invested += Stats.money;
								Stats.money = 0;
							}else if(done.getSource() == a2){
								Stats.money += Stats.invested;
								Stats.invested = 0;
							}
							RefreshPanel();
							break;
					
					}
					
					
					break;
					
				
				
			}
		}
	}
	
	public static void RefreshPanel(){
		panel.removeAll();
		getPanel();
	}
	
	public static JLabel getBankerPic(){
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(Main.class.getResource("resources/Banker.png"));
		} catch (IOException e) {e.printStackTrace();}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(500, 200, 1000, 1000);
		return picLabel;
	}
	
	public static Font getFont(int x){
		return new Font(Font.SERIF, Font.PLAIN, x);
	}
}
