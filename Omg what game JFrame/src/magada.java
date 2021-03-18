import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class magada extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton magamisnupp, tagasinupp;
	private JLabel intro1, intro, intro2, intro3;
	public magada(){
		super("Magama");
		setLayout(new FlowLayout());
		intro1 = new JLabel("                                                                                                                                          ");
		intro = new JLabel("Magad 8h, et saada 40 enesetunnet");
		intro2 = new JLabel("                                                                                                                                                      ");
		magamisnupp = new JButton("Maga");
		intro3 = new JLabel("                                                                                                                                                ");
		tagasinupp = new JButton("Tagasi");
		add(intro1);
		add(intro);
		add(intro2);
		add(magamisnupp);
		add(intro3);
		add(tagasinupp);
		muna juust = new muna();
		magamisnupp.addActionListener(juust);
		tagasinupp.addActionListener(juust);
	}public class muna implements ActionListener{
		public void actionPerformed(ActionEvent toiming7) {
			if(toiming7.getActionCommand()=="Maga"){
				stats.kell+=8;
				stats.tunne+=40;
				mainmenu hitler621 = new mainmenu();
				hitler621.setSize(500, 300);
				hitler621.setVisible(true);
				hitler621.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				hitler621.setLocation(700, 400);
				hitler621.setResizable(false);
			}else if(toiming7.getActionCommand()=="Tagasi"){
				mainmenu hitler621 = new mainmenu();
				hitler621.setSize(500, 300);
				hitler621.setVisible(true);
				hitler621.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				hitler621.setLocation(700, 400);
				hitler621.setResizable(false);
			}
		}
	}
}
