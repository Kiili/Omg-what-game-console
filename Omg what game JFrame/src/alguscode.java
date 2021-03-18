import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
public class alguscode extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel tervitus, tervitus1, suvakas112, enterrr;
	private JTextField nimif, vanusf;
	private JButton valmis;


	public alguscode(){
		super("The Game");
		setLayout(new FlowLayout());
		tervitus = new JLabel("                                           Tere. Mis su nimi on?                                            ");
		add(tervitus);
		nimif = new JTextField("", 10);
		add(nimif);
		enterrr = new JLabel("                                                          (Vajuta enter)                                                           ", 10);
		add(enterrr);
		suvakas112 = new JLabel("                                                                                                                                          ");
		add(suvakas112);
		tervitus1 = new JLabel("                                                 Kui vana sa oled?                                                 ");
		add(tervitus1);
		vanusf = new JTextField("", 10);
		add(vanusf);
		enterrr = new JLabel("                                                          (Vajuta enter)                                                           ", 10);
		add(enterrr);
		
		suvakas112 = new JLabel("                                                                                                                                          ");
		add(suvakas112);
		valmis = new JButton("Valmis");
		add (valmis);
		
		sike muna = new sike();
		vanusf.addActionListener(muna);
		nimif.addActionListener(muna);
		valmis.addActionListener(muna);
		
	}
	public class sike implements ActionListener{
		public void actionPerformed(ActionEvent toiming){
			
			String name = "";
			
			name = String.format("%s", toiming.getActionCommand());
			if(toiming.getSource()==nimif){stats.nimi = name;}
			if(toiming.getSource()==vanusf){stats.vanus = name;}

			
			if(toiming.getActionCommand()=="Valmis"){
				mainmenu hyena = new mainmenu();
				hyena.setSize(500, 300);
				hyena.setVisible(true);
				hyena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				hyena.setLocation(700, 400);
				hyena.setResizable(false);
			}

				
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
	}
}
