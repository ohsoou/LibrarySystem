package view.main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

public class MainButton extends JButton implements MouseListener{
	
	Border[] borders = new Border[3];
	
	public MainButton(String path, int width, int height) {
		borders[0] = new LineBorder(new Color(0xe1eef6));
		borders[1] = new BevelBorder(BevelBorder.RAISED);
		borders[2] = new SoftBevelBorder(SoftBevelBorder.LOWERED);
		this.setBorder(borders[0]);
		this.setIcon(makeImageIcon(path,width,height));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(this);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		setBorder(borders[2]);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		setBorder(borders[2]);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setBorder(borders[1]);
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setBorder(borders[0]);
		
	}

}
