import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class rahateenida extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton tagasinupp, korvilukkaja, koristaja, taksojuht, opetaja,
	firmalooja, firmaomanik, firmasuurendaja, suurefirmaomanik, jumal;
	private JLabel intro, suvakas4, suvakas333;
	public rahateenida(){
		super("T��");
		setLayout(new FlowLayout());
		intro = new JLabel("Kellena tahad t��data?");
		suvakas4 = new JLabel("                                                                                                                                          ");
		korvilukkaja = new JButton("Korvil�kkajana");
		koristaja = new JButton("Koristajana");
		taksojuht = new JButton("Taksojuhina");
		opetaja = new JButton("�petajana");
		firmalooja = new JButton("Firma loojana");
		firmaomanik = new JButton("Firma omanikuna");
		firmasuurendaja = new JButton("Firma suurendajana");
		suurefirmaomanik = new JButton("Suure firma omanikuna");
		jumal = new JButton("Jumalana");
		suvakas333 = new JLabel("                                                                                                                                          ");
		tagasinupp = new JButton("Tagasi");
		add(intro);
		add(suvakas4);
		add(korvilukkaja);
		add(koristaja);
		add(taksojuht);
		add(opetaja);
		add(firmalooja);
		add(firmaomanik);
		add(firmasuurendaja);
		add(suurefirmaomanik);
		add(jumal);
		add(suvakas333);
		add(tagasinupp);
		korvilukkaja.setToolTipText("5h --> 10� 20xp");
		koristaja.setToolTipText("3h --> 12� 25xp");
		taksojuht.setToolTipText("6h --> 40� 50xp");
		opetaja.setToolTipText("8h --> 70� 100xp");
		firmalooja.setToolTipText("8h --> -20� 800xp");
		firmaomanik.setToolTipText("6h --> 150� 220xp");
		firmasuurendaja.setToolTipText("8h --> -100� 2400xp");
		suurefirmaomanik.setToolTipText("4h --> 600� 300xp");
		jumal.setToolTipText("2h --> 4200� 420xp");
		if(stats.xp<100){
			koristaja.setBorderPainted(true);
			koristaja.setEnabled(false);
			koristaja.setToolTipText("Sul on veel vaja " + (100-stats.xp) + " xp'd");
		}if(stats.xp<450){
			taksojuht.setBorderPainted(true);
			taksojuht.setEnabled(false);
			taksojuht.setToolTipText("Sul on veel vaja " + (450-stats.xp) + " xp'd");
		}if(stats.xp<1200){
			opetaja.setBorderPainted(true);
			opetaja.setEnabled(false);
			opetaja.setToolTipText("Sul on veel vaja " + (1200-stats.xp) + " xp'd");
		}if(stats.xp<2400){
			firmalooja.setBorderPainted(true);
			firmalooja.setEnabled(false);
			firmalooja.setToolTipText("Sul on veel vaja " + (2400-stats.xp) + " xp'd");
		}if(stats.xp<12000){
			firmaomanik.setBorderPainted(true);
			firmaomanik.setEnabled(false);
			firmaomanik.setToolTipText("Sul on veel vaja " + (12000-stats.xp) + " xp'd");
		}if(stats.xp<23000){
			firmasuurendaja.setBorderPainted(true);
			firmasuurendaja.setEnabled(false);
			firmasuurendaja.setToolTipText("Sul on veel vaja " + (23000-stats.xp) + " xp'd");
		}if(stats.xp<78000){
			suurefirmaomanik.setBorderPainted(true);
			suurefirmaomanik.setEnabled(false);
			suurefirmaomanik.setToolTipText("Sul on veel vaja " + (78000-stats.xp) + " xp'd");
		}if(stats.xp<420420){
			jumal.setBorderPainted(true);
			jumal.setEnabled(false);
			jumal.setToolTipText("Sul on veel vaja " + (420420-stats.xp) + " xp'd");
		}megaman112 jaagup = new megaman112();
		tagasinupp.addActionListener(jaagup);
		korvilukkaja.addActionListener(jaagup);
		koristaja.addActionListener(jaagup);
		taksojuht.addActionListener(jaagup);
		opetaja.addActionListener(jaagup);
		firmalooja.addActionListener(jaagup);
		firmaomanik.addActionListener(jaagup);
		firmasuurendaja.addActionListener(jaagup);
		suurefirmaomanik.addActionListener(jaagup);
		jumal.addActionListener(jaagup);
	}public class megaman112 implements ActionListener{
		public void actionPerformed(ActionEvent  toiming31) {
			if(toiming31.getActionCommand()=="Tagasi"){
				mainmenu hitler61 = new mainmenu();
				stats.kell++;
				hitler61.setSize(500, 300);
				hitler61.setVisible(true);
				hitler61.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				hitler61.setLocation(700, 400);
				hitler61.setResizable(false);
			}else if(toiming31.getActionCommand()=="Korvilükkajana"){
				stats.kell+=5;
				stats.xp+=20;
				stats.raha+=10;
				stats.tunne-=15;
				mainmenu hitler61 = new mainmenu();
				hitler61.setSize(500, 300);
				hitler61.setVisible(true);
				hitler61.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				hitler61.setLocation(700, 400);
				hitler61.setResizable(false);
			}else if(toiming31.getActionCommand()=="Koristajana"){
				stats.kell+=3;
				stats.xp+=25;
				stats.raha+=12;
				stats.tunne-=14;
				mainmenu hitler61 = new mainmenu();
				hitler61.setSize(500, 300);
				hitler61.setVisible(true);
				hitler61.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				hitler61.setLocation(700, 400);
				hitler61.setResizable(false);
			}else if(toiming31.getActionCommand()=="Taksojuhina"){
				stats.kell+=6;
				stats.xp+=50;
				stats.raha+=40;
				stats.tunne-=7;
				mainmenu hitler61 = new mainmenu();
				hitler61.setSize(500, 300);
				hitler61.setVisible(true);
				hitler61.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				hitler61.setLocation(700, 400);
				hitler61.setResizable(false);
			}else if(toiming31.getActionCommand()=="Õpetajana"){
				stats.kell+=8;
				stats.xp+=100;
				stats.raha+=70;
				stats.tunne-=9;
				mainmenu hitler61 = new mainmenu();
				hitler61.setSize(500, 300);
				hitler61.setVisible(true);
				hitler61.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				hitler61.setLocation(700, 400);
				hitler61.setResizable(false);
			}else if(toiming31.getActionCommand()=="Firma loojana"){
				stats.kell+=8;
				stats.xp+=800;
				stats.raha-=20;
				stats.tunne-=6;
				mainmenu hitler61 = new mainmenu();
				hitler61.setSize(500, 300);
				hitler61.setVisible(true);
				hitler61.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				hitler61.setLocation(700, 400);
				hitler61.setResizable(false);
			}else if(toiming31.getActionCommand()=="Firma omanikuna"){
				stats.kell+=6;
				stats.xp+=220;
				stats.raha+=150;
				stats.tunne-=5;
				mainmenu hitler611 = new mainmenu();
				hitler611.setSize(500, 300);
				hitler611.setVisible(true);
				hitler611.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				hitler611.setLocation(700, 400);
				hitler611.setResizable(false);
			}else if(toiming31.getActionCommand()=="Firma suurendajana"){
				stats.kell+=8;
				stats.xp+=2400;
				stats.raha-=100;
				stats.tunne-=7;
				mainmenu hitler61 = new mainmenu();
				hitler61.setSize(500, 300);
				hitler61.setVisible(true);
				hitler61.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				hitler61.setLocation(700, 400);
				hitler61.setResizable(false);
			}else if(toiming31.getActionCommand()=="Suure firma omanikuna"){
				stats.kell+=4;
				stats.xp+=300;
				stats.raha+=600;
				stats.tunne-=4;
				mainmenu hitler61 = new mainmenu();
				hitler61.setSize(500, 300);
				hitler61.setVisible(true);
				hitler61.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				hitler61.setLocation(700, 400);
				hitler61.setResizable(false);
			}else if(toiming31.getActionCommand()=="Jumalana"){
				stats.kell+=2;
				stats.xp+=420;
				stats.raha+=4200;
				stats.tunne-=2;
				mainmenu hitler61 = new mainmenu();
				hitler61.setSize(500, 300);
				hitler61.setVisible(true);
				hitler61.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				hitler61.setLocation(700, 400);
				hitler61.setResizable(false);
			}
		}
	}
}