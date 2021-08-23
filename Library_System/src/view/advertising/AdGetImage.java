package view.advertising;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class AdGetImage {
	
	public static ImageIcon makeImageIcon(String path, int width, int height) {
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
