package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.advertising.AdvertisingPanel;
import view.main.MainPanel;
import view.manager.ManagerPanel;
import view.rental.rentalMain;

public class DefaultFrame extends JFrame{

	public DefaultFrame() {
		super("도서관 프로그램");
		
		JPanel search = new ManagerPanel();
		
		//add(search);
		add(new rentalMain());
		//add(new MainPanel());
		//add(new AdvertisingPanel());

		
		
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

