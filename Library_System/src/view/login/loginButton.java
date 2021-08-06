package view.login;

import javax.swing.ImageIcon;

import view.component.DefaultBtn;

public class loginButton extends DefaultBtn{
	public loginButton() {
		super(null,100,40);
		String imgPath = "./image/login.png";
		ImageIcon icon = new imageResizing(imgPath, 250, 40).getResizeIcon();
		setIcon(icon);
	}
}