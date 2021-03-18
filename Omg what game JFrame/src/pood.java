import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class pood extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel suvakas115, suvakas116, suvakas117, suvakas118, suvakas119, suvakas138,
	suvakas120, suvakas121, suvakas122, suvakas123, suvakas124, suvakas125, suvakas136;
	private JButton tagasinupp, jaatis, suurkommikarp, pall, teler, jalgratas, arvuti,
	uhd, moodneauto, ilusmaja, villa, reismarsile;
	
	public pood(){
		super("Pood");
		setLayout(new FlowLayout());
		suvakas116 = new JLabel("                                                        "
				+ "                                                                        "
				+ "          ");
		add(suvakas116);
		suvakas115 = new JLabel("                                "
				+ "                      Sisenesid poodi. Mida osta vaja?           "
				+ "                                        ");
		add(suvakas115);
		jaatis = new JButton("J��tis - 2�");
		suurkommikarp = new JButton("Suur kommikarp - 5�");
		pall = new JButton("Pall - 15�");
		teler = new JButton("Teler - 50�");
		jalgratas = new JButton("Jalgratas - 120�");
		arvuti = new JButton("Arvuti - 700�");
		uhd = new JButton("4k UHD Teler - 1500�");
		moodneauto = new JButton("Moodne auto - 9000�");
		ilusmaja = new JButton("Ilus maja - 26 000�");
		villa = new JButton("Villa - 92 000�");
		reismarsile = new JButton("Reis Mars'ile - 72 666 000�");
		tagasinupp = new JButton("Tagasi");
		add(jaatis);
		suvakas117 = new JLabel("             ");add(suvakas117);
		add(suurkommikarp);
		suvakas118 = new JLabel("                  ");add(suvakas118);
		add(pall);
		suvakas138 = new JLabel("             ");add(suvakas138);
		add(teler);
		suvakas119 = new JLabel("                    ");add(suvakas119);
		add(jalgratas);
		suvakas120 = new JLabel("                   ");add(suvakas120);
		add(arvuti);
		suvakas121 = new JLabel("             ");add(suvakas121);
		add(uhd);
		suvakas122 = new JLabel("                            ");add(suvakas122);
		add(moodneauto);
		suvakas123 = new JLabel("             ");add(suvakas123);
		add(ilusmaja);
		suvakas124 = new JLabel("             ");add(suvakas124);
		add(villa);
		suvakas125 = new JLabel("             ");add(suvakas125);
		add(reismarsile);
		suvakas136 = new JLabel("                                                        "
				+ "                                                                        "
				+ "          ");
		
		add(suvakas136);
		add(tagasinupp);
		epicness juhan = new epicness();
		jaatis.addActionListener(juhan);
		suurkommikarp.addActionListener(juhan);
		pall.addActionListener(juhan);
		teler.addActionListener(juhan);
		jalgratas.addActionListener(juhan);
		arvuti.addActionListener(juhan);
		uhd.addActionListener(juhan);
		moodneauto.addActionListener(juhan);
		ilusmaja.addActionListener(juhan);
		villa.addActionListener(juhan);
		reismarsile.addActionListener(juhan);
		tagasinupp.addActionListener(juhan);
		
	}
	public class epicness implements ActionListener{
		public void actionPerformed(ActionEvent toiming3){
			int puudu = 0;
			if(toiming3.getActionCommand()=="J��tis - 2�"){
				if (stats.raha >= 2){
					stats.raha-=2;
					stats.j++;
					stats.kell++;
				}else{puudu=2-stats.raha;JOptionPane.showMessageDialog(null, "Sul pole piisavalt raha. "+puudu+"€ jääb puudu");}
			}else if(toiming3.getActionCommand()=="Suur kommikarp - 5�"){
				if (stats.raha >= 5){
					stats.s++;
					stats.kell++;
					stats.raha-=5;
				}else{puudu=5-stats.raha;JOptionPane.showMessageDialog(null, "Sul pole piisavalt raha. "+puudu+"€ jääb puudu");}
			}else if(toiming3.getActionCommand()=="Pall - 15�"){
				if (stats.raha >= 15){
					stats.p++;
					stats.kell++;
					stats.raha-=15;
				}else{puudu=15-stats.raha;JOptionPane.showMessageDialog(null, "Sul pole piisavalt raha. "+puudu+"€ jääb puudu");}
			}else if(toiming3.getActionCommand()=="Teler - 50�"){
				if (stats.raha >= 50){
					stats.t++;
					stats.kell++;
					stats.raha-=50;
				}else{puudu=50-stats.raha;JOptionPane.showMessageDialog(null, "Sul pole piisavalt raha. "+puudu+"€ jääb puudu");}
			}else if(toiming3.getActionCommand()=="Jalgratas - 120�"){
				if (stats.raha >= 120){
					stats.ja++;
					stats.kell++;
					stats.raha-=120;
				}else{puudu=120-stats.raha;JOptionPane.showMessageDialog(null, "Sul pole piisavalt raha. "+puudu+"€ jääb puudu");}
			}else if(toiming3.getActionCommand()=="Arvuti - 700�"){
				if (stats.raha >= 700){
					stats.a++;
					stats.kell++;
					stats.raha-=700;
				}else{puudu=700-stats.raha;JOptionPane.showMessageDialog(null, "Sul pole piisavalt raha. "+puudu+"€ jääb puudu");}
			}else if(toiming3.getActionCommand()=="Ilus maja - 26 000�"){
				if (stats.raha >= 26000){
					stats.uhd++;
					stats.kell++;
					stats.raha-=26000;
				}else{puudu=26000-stats.raha;JOptionPane.showMessageDialog(null, "Sul pole piisavalt raha. "+puudu+"€ jääb puudu");}
			}else if(toiming3.getActionCommand()=="Villa - 92 000�"){
				if (stats.raha >= 92000){
					stats.v++;
					stats.kell++;
					stats.raha-=92000;
				}else{puudu=92000-stats.raha;JOptionPane.showMessageDialog(null, "Sul pole piisavalt raha. "+puudu+"€ jääb puudu");}
			}else if(toiming3.getActionCommand()=="Reis Mars'ile - 72 666 000�"){
				if (stats.raha >= 72666000){
					stats.r++;
					stats.kell++;
					stats.raha-=72666000;
				}else{puudu=72666000-stats.raha;JOptionPane.showMessageDialog(null, "Sul pole piisavalt raha. "+puudu+"€ jääb puudu");}
			}else if(toiming3.getActionCommand()=="Tagasi"){
				stats.kell++;
				mainmenu hitler1 = new mainmenu();
				hitler1.setSize(500, 300);
				hitler1.setVisible(true);
				hitler1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				hitler1.setLocation(700, 400);
				hitler1.setResizable(false);
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}
}
