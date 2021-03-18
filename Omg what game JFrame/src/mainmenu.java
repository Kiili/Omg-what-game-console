import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class mainmenu extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel suvakas112, suvakas113, yleminehud, yleminehud1, yleminehud2, suvakas114;
	private JButton kalkulaator, pood, pank, rahateenida, magada, info, teha;
	public mainmenu(){
		super("Title.exe Has stopped working");
		setLayout(new FlowLayout());
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(60);
		if (stats.kell > 23){stats.kell = stats.kell-24;stats.paev++;}
		if (stats.tunne > 100){stats.tunne = 100;}
		if (stats.tunne >= 90){stats.nagu = ":D";}
		if (stats.tunne < 90){stats.nagu = ":)";}
		if (stats.tunne < 60){stats.nagu = ":/";}
		if (stats.tunne < 40){stats.nagu = ":(";}
		if (stats.tunne < 20){stats.nagu = ":'(";}
		if (stats.tunne <= 0){}
		suvakas112 = new JLabel("                                                                                                                                          ");
		add(suvakas112);
		suvakas113 = new JLabel("                                                                                                                                          ");
		add(suvakas113);
		yleminehud = new JLabel("           Enesetunne: "+stats.tunne+" "+stats.nagu+"   Päev: "+stats.paev+"    Kell: ");
		add(yleminehud);
		if (stats.kell > 9){
			if (randomInt < 10){
				yleminehud1 = new JLabel(stats.kell+":0"+randomInt);
			}else{yleminehud1 = new JLabel(stats.kell+":"+randomInt);}
		}else{
			if (randomInt < 10){
				yleminehud1 = new JLabel("0"+stats.kell+":0"+randomInt);
			}else{yleminehud1 = new JLabel("0"+stats.kell+":"+randomInt);}
		}
		add(yleminehud1);
		yleminehud2 = new JLabel(stats.xp+"xp  "+stats.raha+"€   ");
		add(yleminehud2);
		suvakas114 = new JLabel("                                                                                                                                                            ");
		add(suvakas114);      
		kalkulaator= new JButton("Kalkulaator");
		add(kalkulaator);
		pood= new JButton("Pood");
		add(pood);
		pank= new JButton("Pank");
		add(pank);
		rahateenida= new JButton("Töö");
		add(rahateenida);
		magada= new JButton("Magada");
		add(magada);
		info= new JButton("Info");
		add(info);
		teha= new JButton("Midagi teha");
		add(teha);
		rocking kiili = new rocking();
		kalkulaator.addActionListener(kiili);
		pood.addActionListener(kiili);
		pank.addActionListener(kiili);
		rahateenida.addActionListener(kiili);
		magada.addActionListener(kiili);
		info.addActionListener(kiili);
		teha.addActionListener(kiili);
	}public class rocking implements ActionListener{
		public void actionPerformed(ActionEvent toiming1){
			if(toiming1.getActionCommand()=="Kalkulaator"){
				kalkulaator nr1 = new kalkulaator();
				nr1.setSize(500, 300);
				nr1.setVisible(true);
				nr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				nr1.setLocation(700, 400);
				nr1.setResizable(false);
			}else if(toiming1.getActionCommand()=="Pood"){
				pood nr2 = new pood();
				nr2.setSize(500, 300);
				nr2.setVisible(true);
				nr2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				nr2.setLocation(700, 400);
				nr2.setResizable(false);
			}else if(toiming1.getActionCommand()=="Pank"){
				pank nr3 = new pank();
				nr3.setSize(500, 300);
				nr3.setVisible(true);
				nr3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				nr3.setLocation(700, 400);
				nr3.setResizable(false);
			}else if(toiming1.getActionCommand()=="Töö"){
				rahateenida nr4 = new rahateenida();
				nr4.setSize(500, 300);
				nr4.setVisible(true);
				nr4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				nr4.setLocation(700, 400);
				nr4.setResizable(false);
			}else if(toiming1.getActionCommand()=="Magada"){
				magada nr5 = new magada();
				nr5.setSize(500, 300);
				nr5.setVisible(true);
				nr5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				nr5.setLocation(700, 400);
				nr5.setResizable(false);
			}else if(toiming1.getActionCommand()=="Info"){
				info nr6 = new info();
				nr6.setSize(500, 300);
				nr6.setVisible(true);
				nr6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				nr6.setLocation(700, 400);
				nr6.setResizable(false);
			}else if(toiming1.getActionCommand()=="Midagi teha"){
				teha nr7 = new teha();
				nr7.setSize(500, 300);
				nr7.setVisible(true);
				nr7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				nr7.setLocation(700, 400);
				nr7.setResizable(false);
			}
		}
	}
}