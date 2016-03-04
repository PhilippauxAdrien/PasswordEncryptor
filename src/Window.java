import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JPanel{
	 private Image backgroundImage;

	public Window() throws IOException {
	    backgroundImage = ImageIO.read(new File("res/background.jpg"));

		 JFrame f = new JFrame("Password Encryptor");
		 f.getContentPane().setLayout(null);
		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 f.setPreferredSize(new Dimension(450, 650));
		 f.setResizable(false);
		 
		f.setContentPane(new JPanelImage(new ImageIcon("res/background.jpg").getImage()));		 
		 
		 
		 f.pack();
		 f.setLocationRelativeTo(null);
		 f.setVisible(true);
	}
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);

	    // Draw the background image.
	    g.drawImage(backgroundImage, 0, 0, this);
	  }
	public static void main(String[] args) throws IOException {
		new Window();
	}

}
