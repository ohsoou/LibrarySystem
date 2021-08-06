package view.login;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class idLabel extends JLabel{
	public idLabel() {
		String imgPath = "./image/user_img.png";
		ImageIcon icon = new imageResizing(imgPath, 40, 40).getResizeIcon();
		setIcon(icon);
	}
}
