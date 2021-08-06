package view.login;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class idLabel extends JLabel{
	public idLabel() {
		String imgPath = "./Library_System/src/image/user_img.png";
		
		ImageIcon originIcon = new ImageIcon(imgPath);
		
		Image originImg = originIcon.getImage();
		
		Image changedImg = originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		ImageIcon icon = new ImageIcon(changedImg);
		
		setIcon(icon);
	}
}
