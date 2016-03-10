import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JPanelImage extends JPanel {
	private Image img;
	private  JTextField  passwd;
	String mdp = "";
	private Encoding enc;
	final JCheckBox hide;
	int n = 12;

	public JPanelImage(Image img) {
		this.img = img;
		this.setLayout(null);
		
		JLabel passlab = new JLabel("<html><u>Entrez votre mot de passe</u></html>");
		passlab.setBounds(145, 190, 200, 30);
		JLabel labelenco = new JLabel("Encodage");
		labelenco.setBounds(60, 265, 90, 15);
		Font font = new Font("Arial",Font.BOLD,11);
		labelenco.setFont(font);
		passwd = new  JTextField();
		passwd.setBounds(50, 230, 245, 30);
		hide = new JCheckBox("Cacher", false);
		hide.setBounds(300, 233, 100, 20);
		Encoding[] elements = new Encoding[]{Encoding.MD5,Encoding.SHA1,Encoding.SHA256};
		final JComboBox<Encoding> encodingchoice = new JComboBox(elements);
		JButton generate = new JButton("Générer");
		generate.setBounds(170, 320, 120, 30);
		encodingchoice.setBounds(50, 280, 70, 28);
		JLabel labnb = new JLabel("Longueur voulue : ");
		labnb.setBounds(135, 277, 120, 30);
		final JTextField size = new JTextField("entre 4 et 40");
		Font fontsize = new Font("Arial",Font.ITALIC,11);
		size.setFont(fontsize);
		size.setBounds(240, 277, 70, 30);
		
		generate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mdp = passwd.getText();
				enc = (Encoding) encodingchoice.getSelectedItem();
				Encryption en = new Encryption(mdp, enc,n);
				System.out.println(en.getPasswordEncrypted());
			}
		});
		hide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(hide.isSelected())
					passwd.setForeground(Color.WHITE);
				else
					passwd.setForeground(Color.BLACK);
			}
		});
		add(size);
		add(labnb);
		add(hide);
		add(generate);
		add(labelenco);
		add(encodingchoice);
		add(passlab);
		add(passwd);

	}

	public void paintComponent(Graphics g) {
	//	g.drawImage(img, 0, 0, null);
		g.drawRect(40, 170, 365, 400);
	}
}
