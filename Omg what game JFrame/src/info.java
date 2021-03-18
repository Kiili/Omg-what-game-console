import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class info extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel tyhi,tyhi1, info, info1, info2, info3;
	private JButton tagasinupp;
	public info(){
		super("Info");
		setLayout(new FlowLayout());
		tyhi = new JLabel("                                                                                                                                          ");
		info = new JLabel("                  Sina, "+stats.nimi+" oled "+stats.vanus+" aastat vana.                   ");
		info1 = new JLabel("Sul on "+stats.xp+" xp, "+stats.raha+"€, oled "+stats.maksta+"� v�lgu, hetkel on "+stats.paev+". päev.");
		info2 = new JLabel("Jäätiseid: "+stats.j+" Suuri kommikarpe: "+stats.s+" Palle: "+stats.p+" Telereid: "+stats.t+" Jalgrattaid: "+stats.ja+" Arvuteid: "+stats.a);
		info3 = new JLabel("UHD telereid: "+stats.uhd+" Moodsaid autosid: "+stats.m+" Ilusaid maju: "+stats.i+" Villasid: "+stats.v+" Reise marsile: "+stats.r);
		tyhi1 = new JLabel("                                                                                                                                          ");
		tagasinupp = new JButton("Tagasi");
		add(tyhi);
		add(info);
		add(info1);
		add(info2);
		add(info3);
		add(tyhi1);
		add(tagasinupp);
		jutt monn = new jutt();
		tagasinupp.addActionListener(monn);
	}public class jutt implements ActionListener{
		public void actionPerformed(ActionEvent toiming9) {
			if(toiming9.getActionCommand()=="Tagasi"){
				stats.kell++;
				mainmenu hitler661 = new mainmenu();
				hitler661.setSize(500, 300);
				hitler661.setVisible(true);
				hitler661.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				hitler661.setLocation(700, 400);
				hitler661.setResizable(false);
			}
		}
	}
}