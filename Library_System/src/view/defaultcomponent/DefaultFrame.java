package view.defaultcomponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;


public abstract class DefaultFrame extends JFrame implements IFrame{
	
	public void setFrame() {
		setTitle("도서관 프로그램");
		getContentPane().setBackground(new Color(225, 238, 246));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(new Point(100, 100));
		setSize(new Dimension(980, 600));
		//setVisible(true);
	}
	
}

