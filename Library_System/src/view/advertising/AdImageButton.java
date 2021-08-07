package view.advertising;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
	/*
	 	[AdImageButton]
	 	버튼에 들어갈 이미지와 텍스트 사이즈를 조정해주는 클래스.
	 */
public class AdImageButton extends JButton{

	
	public AdImageButton(String path, int width, int height,String txt, int x, int y) {
		LineBorder line = new LineBorder(new Color(225, 238, 246));
		this.setText(txt);
		this.setIcon(makeImageIcon(path,width,height));
		this.setLocation(x, y);
		setBackground(new Color(225, 238, 246));
		setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		setBorder(line);
		setSize(130,180);
		setVerticalTextPosition(SwingConstants.BOTTOM);
		setHorizontalTextPosition(SwingConstants.CENTER);
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
