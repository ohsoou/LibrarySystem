package view.login;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageResize {

	private String path;
	private ImageIcon originIcon;
	private Image originImg;
	private Image resizeImg;
	private ImageIcon resizeIcon;

	public ImageResize(String path,int width, int height) {

		this.path = path;

		originIcon = new ImageIcon(path);
		originImg = originIcon.getImage();

		resizeImg = originImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		resizeIcon = new ImageIcon(resizeImg);
	} 

	public ImageIcon getResizeIcon() {
		return resizeIcon;
	}
}
