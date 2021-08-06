package view.main;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

	/*
	 	[MainButton]
	 	LineBorder으로 버튼의 경계선이 없어지는 듯한 효과를 주고
	 	생성자에 이미지의 주소와 사이즈를 받아 넣어준다.
	*/
public class MainButton extends JButton{
	
	LineBorder line = new LineBorder(new Color(0xe1eef6));
	
	public MainButton(String path, int width, int height) {
		this.setBorder(line);
		this.setIcon(makeImageIcon(path,width,height));
	}
	
	private static ImageIcon makeImageIcon(String path, int width, int height) {
	      BufferedImage image;
	      try {
	         image = ImageIO.read(new File(path));
	      } catch (IOException e) {
	         e.printStackTrace();
	         image = null;
	      }
	      
	      return new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
	   }

}
