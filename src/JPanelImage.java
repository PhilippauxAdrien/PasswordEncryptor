import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelImage extends JPanel {
	private Image img;

	public JPanelImage(Image img) {
		this.img = img;
		Color colBtn = new Color(206,251,247);
		this.setLayout(null);
		JTextField passwd = new JTextField();
		
		passwd.setBounds(120,200,200,30);
		add(passwd);
		
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
