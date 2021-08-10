package view.login;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class IdLabel extends JLabel{
	public IdLabel() {
		String imgPath = "./image/user.png";
		
		ImageIcon icon = new ImageResize(imgPath,40,40).getResizeIcon();
		
		setIcon(icon);
	}
}
