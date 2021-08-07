package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.advertising.AdCenterPanel;
import view.advertising.AdTopPanel;
import view.advertising.AdvertisingPanel;
import view.manager.ManagerPanel;

public class DefaultFrame extends JFrame{

	public DefaultFrame() {
		super("도서관 프로그램");
		
		JPanel search = new ManagerPanel();
		
		add(search);
		add(new AdvertisingPanel());
		
		
		getContentPane().setBackground(new Color(225, 238, 246));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(new Point(100, 100));
		setSize(new Dimension(980, 600));
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DefaultFrame();
	}
}
