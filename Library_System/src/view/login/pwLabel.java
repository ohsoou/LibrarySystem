package view.login;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class pwLabel extends JLabel {
	public pwLabel() {
		String imgPath = "./image/pw_img.png";	
		ImageIcon icon = new imageResizing(imgPath, 40, 40).getResizeIcon();
		setIcon(icon);
	}
}
