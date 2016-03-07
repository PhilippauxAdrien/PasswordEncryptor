import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JPanelImage extends JPanel {
	private Image img;
	private  JPasswordField  passwd;
	String mdp = "";
	private Encoding enc;
	public JPanelImage(Image img) {
		this.img = img;
		Color colBtn = new Color(206, 251, 247);
		this.setLayout(null);
		JLabel passlab = new JLabel("<html><u>Enter your Password</u></html>");
		passlab.setBounds(170, 150, 120, 30);
		JLabel labelenco = new JLabel("Encoding");
		labelenco.setBounds(310, 175, 90, 15);
		Font font = new Font("Arial",Font.BOLD,11);
		labelenco.setFont(font);
		passwd = new  JPasswordField();
		passwd.setBounds(90, 190, 200, 30);
		Encoding[] elements = new Encoding[]{Encoding.MD5,Encoding.SHA1,Encoding.SHA256};
		final JComboBox<Encoding> encodingchoice = new JComboBox(elements);
		JButton generate = new JButton("Generate");
		generate.setBounds(170, 240, 120, 30);
		generate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mdp = passwd.getText();
				enc = (Encoding) encodingchoice.getSelectedItem();
				Encryption en = new Encryption(mdp, enc);
				System.out.println(en.getPasswordEncrypted());
			}
		});
		encodingchoice.setBounds(300, 190, 70, 28);
		add(generate);
		add(labelenco);
		add(encodingchoice);
		add(passlab);
		add(passwd);

	}

	public void paintComponent(Graphics g) {
	//	g.drawImage(img, 0, 0, null);
		g.drawRect(80, 150, 300, 400);
	}
}
