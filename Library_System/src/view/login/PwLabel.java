package view.login;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PwLabel extends JLabel {
	public PwLabel() {
		String imgPath = "./image/componentImg/password_img.png";

		ImageIcon icon = new ImageResize(imgPath,40,40).getResizeIcon();
		
		setIcon(icon);
	} 
}
