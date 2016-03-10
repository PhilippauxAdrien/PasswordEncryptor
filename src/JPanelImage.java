import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
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
	private  JTextField  passwd, res;
	String mdp = "";
	private Encoding enc;
	final JCheckBox hide;
	final JComboBox size;
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
	    size = new JComboBox();		
		size.setBounds(240, 277, 60, 30);
		res = new JTextField();
		res.setBounds(70, 400, 300, 30);
		res.setEditable(false);
		for(int i=4; i<41; i++)
			size.addItem(i);	
		 
			generate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mdp = passwd.getText();
				enc = (Encoding) encodingchoice.getSelectedItem();
				// Récupération des valeurs (conversion en int)
				n = ((Integer)size.getSelectedItem()).intValue() + 1;
				Encryption en = new Encryption(mdp, enc,n);
				res.setText(en.getPasswordEncrypted());
				//System.out.println(en.getPasswordEncrypted());
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
		JButton copier = new JButton("Copier");
		copier.setBounds(170, 435, 120, 30);
		copier.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Toolkit toolKit = Toolkit.getDefaultToolkit();
				Clipboard cb = toolKit.getSystemClipboard();
				cb.setContents(new StringSelection(res.getText()), null);
				JLabel ok = new JLabel("Copié!");
				ok.setFont(new Font("Arial", Font.ITALIC, 13));
				ok.setBounds(210, 460, 70, 30);
				add(ok);
				repaint();
			}
		});
		add(copier);
		add(res);
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
		super.paintComponent(g);
	//	g.drawImage(img, 0, 0, null);
		g.drawRect(40, 170, 365, 400);
	}
}
