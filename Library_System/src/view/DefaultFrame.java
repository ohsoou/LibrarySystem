package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.manager.ManagerFrame;


public class DefaultFrame extends JFrame{

	public JPanel manager;
	public DefaultFrame() {
		super("도서관 프로그램");
		
		
		getContentPane().setBackground(new Color(225, 238, 246));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(new Point(100, 100));
		setSize(new Dimension(980, 600));
	}
	
	public static void main(String[] args) {
		new ManagerFrame();
	}

}

