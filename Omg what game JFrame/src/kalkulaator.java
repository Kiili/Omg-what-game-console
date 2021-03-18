import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.*;
public class kalkulaator extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JLabel introo, introo1, introo2, introo3;
	private JTextField arv1, arv2;
	private JButton k, jag, li, la, tagasi;
	private int nr1=0, nr2=0;
	private String mark = "";
	public kalkulaator(){
		super("Kalkulaator");
		setLayout(new FlowLayout());
		introo = new JLabel("                                                          Sisesta 2 arvu.                                                        ");
		add(introo);
		arv1 = new JTextField("", 5);
		arv2 = new JTextField("", 5);
		add(arv1);
		add(arv2);
		introo1 = new JLabel("                                                                                                                                                            ");
		add(introo1);
		li = new JButton("+");
		la = new JButton("-");
		k = new JButton("*");
		jag = new JButton("/");
		add(li);add(la);add(k);add(jag);
		introo2 = new JLabel("                                                                                                                                                            ");
		add(introo2);
		introo3 = new JLabel("                                                                                                                                                              ");
		add(introo3);
		tagasi = new JButton("Tagasi");
		add(tagasi);
		math heer = new math();
		li.addActionListener(heer);
		la.addActionListener(heer);
		k.addActionListener(heer);
		jag.addActionListener(heer);
		arv1.addActionListener(heer);
		arv2.addActionListener(heer);
		tagasi.addActionListener(heer);
	}
	
	
	
	
	public class math implements ActionListener{

		public void actionPerformed(ActionEvent toiming2){
		String tehe = "";
		int vastus = 0;
		tehe = toiming2.getActionCommand();
		if(toiming2.getActionCommand().equals("Tagasi")){
		
			
			
			stats.kell++;
			mainmenu hyena = new mainmenu();
			hyena.setSize(500, 300);
			hyena.setVisible(true);
			hyena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			hyena.setLocation(700, 400);
			hyena.setResizable(false);
			
		}
		
		if(toiming2.getSource()==arv1){
			int nomero = Integer.parseInt(tehe);
			nr1=nomero;
		}
		if(toiming2.getSource()==arv2){
			int nomero = Integer.parseInt(tehe);
			nr2=nomero;
		}
		if(toiming2.getActionCommand().equals("+")){
			vastus= nr1+nr2;
			mark = "+";
			JOptionPane.showMessageDialog(null, nr1+mark+nr2+"="+vastus);
		}else if(toiming2.getActionCommand().equals("-")){
			vastus= nr1-nr2;
			mark = "-";
			JOptionPane.showMessageDialog(null, nr1+mark+nr2+"="+vastus);
		}else if(toiming2.getActionCommand().equals("*")){
			vastus= nr1*nr2;
			mark = "*";
			JOptionPane.showMessageDialog(null, nr1+mark+nr2+"="+vastus);
		}else if(toiming2.getActionCommand().equals("/")){
			vastus= nr1/nr2;
			mark = "/";
			int jaak = nr1- vastus*nr2;
			JOptionPane.showMessageDialog(null, nr1+mark+nr2+"="+vastus+" J22k "+jaak);
		}
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		}
		
	}
}
