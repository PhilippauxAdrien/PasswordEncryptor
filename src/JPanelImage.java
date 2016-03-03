import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelImage extends JPanel {

  private Image backgroundImage;
  private JTextField txt ;
  public JPanelImage(String fileName) throws IOException {
    backgroundImage = ImageIO.read(new File(fileName));
    setLayout(new FlowLayout());
    txt = new JTextField("Your Password");
	txt.setVisible(true);
	txt.setPreferredSize(new Dimension(200, 50));
	
	
	this.add(txt);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Draw the background image.
    g.drawImage(backgroundImage, 0, 0, this);
  }
}