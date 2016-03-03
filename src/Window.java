import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window {

	public Window() throws IOException {
		 JFrame f = new JFrame("Password Encryptor");
		 f.setPreferredSize(new Dimension(450, 650));
		 f.setResizable(false);
		 
		
		 
		 
		 f.getContentPane().add(new JPanelImage("res/background.jpg"));
		 
		 f.pack();
		 f.setLocationRelativeTo(null);
		 f.setVisible(true);
	}
	
	public static void main(String[] args) throws IOException {
		new Window();
	}

}
