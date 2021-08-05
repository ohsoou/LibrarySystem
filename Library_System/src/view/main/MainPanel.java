package view.main;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class MainPanel extends JPanel{
	
	public MainPanel() {
		LineBorder line = new LineBorder(new Color(0xe1eef6));
		//EmptyBorder b1 = new EmptyBorder(5,3,5,3);
		//BevelBorder b4 = new BevelBorder(BevelBorder.RAISED);
		//EtchedBorder b3 = new EtchedBorder();


		
		JButton[] btn = new JButton[4];
		for(int i = 0; i < btn.length; ++i) {
			btn[i] = new JButton();
			btn[i].setBorder(line); 
			btn[i].addActionListener(new Myaction(i));
		}
		
		
		setLayout(null);
		btn[0].setBounds(100,220,200,300);		
		btn[0].setIcon(makeImageIcon("./image/rentalbtn.png",200,300));
			
		btn[1].setBounds(400,220,200,300);
		btn[1].setIcon(makeImageIcon("./image/returnbtn.png",200,300));
		
		btn[2].setBounds(700,220,200,300);
		btn[2].setIcon(makeImageIcon("./image/extentionbtn.png",200,300));
		
		btn[3].setBounds(50,50,50,50);
		btn[3].setIcon(makeImageIcon("./image/backbtn.png",50,50));
		
		add(btn[0]);
		add(btn[1]);
		add(btn[2]);
		add(btn[3]);
		
		setBackground(new Color(0xe1eef6));
		setBounds(700,200,980,600);
		setVisible(true);
		
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
