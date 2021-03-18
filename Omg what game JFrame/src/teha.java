import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class teha extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel nop, space;
	private JButton tagasinupp;
	public teha(){
		super("Teha");
		setLayout(new FlowLayout());
		space = new JLabel("                                                                                                                                                            ");
		tagasinupp = new JButton("Tagasi");
		nop = new JLabel("Veel ei funka");
		add(nop);
		add(space);
		add(tagasinupp);
		lamp kana = new lamp();
		tagasinupp.addActionListener(kana);
	}
	public class lamp implements ActionListener{
		public void actionPerformed(ActionEvent toiming563){
			if(toiming563.getActionCommand().equals("Tagasi")){
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