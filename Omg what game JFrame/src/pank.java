import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class pank extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel tere, suvakas112, suvakas113, intress, suvakas1, suvakas2, suvakas3, suvakas4;
	private JTextField slott, tagasimaksma;
	private JButton laenu, tagasinupp, maksanupp;
	private JLabel exdee;
	int nomero=0;
	public pank(){
		super("Pank");
		setLayout(new FlowLayout());
		suvakas112 = new JLabel("                                                                                                                                          ");
		add(suvakas112);
		slott = new JTextField("", 10);
		suvakas113 = new JLabel("                                                                                                                                          ");
		intress = new JLabel("                                                      Laenu intress on 7,3%                                                  ");
		tere = new JLabel("Sisenesid panka.");
		suvakas1 = new JLabel("                                                                                                                                          ");
		suvakas2 = new JLabel("                                                                      (Vajuta enter)                                                                       ");
		suvakas3 = new JLabel("                                                                                                                                          ");
		suvakas4 = new JLabel("                                                                                                                                          ");
		tagasinupp = new JButton("Tagasi");
		add(tere);
		laenu = new JButton("V�tan laenu");
		exdee = new JLabel("Oled pangale v�lgu "+stats.maksta+"�");
		tagasimaksma = new JTextField("", 10);
		maksanupp = new JButton("Maksan");
		if(stats.maksta<1){
			add(suvakas113);
			add(suvakas1);
			add(intress);
			add(slott);
			add(suvakas2);
			add(laenu);
			add(suvakas3);
			add(suvakas4);
			add(tagasinupp);
		}else{
			add(suvakas113);
			add(exdee);
			add(suvakas4);
			add(tagasimaksma);
			add(suvakas2);
			add(maksanupp);
			add(suvakas1);
			add(tagasinupp);
		}	
		juku qwerty = new juku();
		slott.addActionListener(qwerty);
		tagasinupp.addActionListener(qwerty);
		laenu.addActionListener(qwerty);
		tagasimaksma.addActionListener(qwerty);
		maksanupp.addActionListener(qwerty);
	}
	public class juku implements ActionListener{
		public void actionPerformed(ActionEvent mote){
			String name;
			name = String.format("%s", mote.getActionCommand());
			if(mote.getActionCommand()=="Tagasi"){
				stats.kell++;
				mainmenu hitler12 = new mainmenu();
				hitler12.setSize(500, 300);
				hitler12.setVisible(true);
				hitler12.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				hitler12.setLocation(700, 400);
				hitler12.setResizable(false);
			}else if(mote.getSource()==slott){
				nomero = Integer.parseInt(name);
			}else if(mote.getActionCommand()=="Võtan laenu"){
				stats.maksta1 = nomero*1.073;
				stats.maksta =(int) stats.maksta1;
				stats.raha+=nomero;
				JOptionPane.showMessageDialog(null, "Võtsid "+nomero+"€ Laenu. Tagasi pead maksma "+stats.maksta+"€");
				mainmenu hyen1a = new mainmenu();
				hyen1a.setSize(500, 300);
				hyen1a.setVisible(true);
				hyen1a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				hyen1a.setLocation(700, 400);
				hyen1a.setResizable(false);
			}else if(mote.getSource()==tagasimaksma){
				nomero = Integer.parseInt(name);
			}else if(mote.getActionCommand()=="Maksan"){
				if(nomero>stats.raha){JOptionPane.showMessageDialog(null, "Sul pole piisavalt raha.");
				}else{stats.raha-=nomero;
					stats.maksta-=nomero;
					stats.kell++;
					mainmenu hitler112 = new mainmenu();
					hitler112.setSize(500, 300);
					hitler112.setVisible(true);
					hitler112.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					hitler112.setLocation(700, 400);
					hitler112.setResizable(false);}
			}	
		}
	}
}
