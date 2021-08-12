package view.advertising;


import javax.swing.JPanel;

import view.DefaultFrame;
import view.component.DefaultPanel;

	/*
	 	[AdvertisingPanel]
	 	ž�г� �����г��� �پ��ִ� �����г�
	 */
public class AdvertisingFrame extends DefaultFrame{
	
	public AdvertisingFrame() {
		
		setLayout(null);
		
		JPanel top = new AdTopPanel();
		JPanel center = new AdCenterPanel();

		add(top);
		add(center);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				AdvertisingFrame frame = new AdvertisingFrame();
				frame.setVisible(true);
			}
		});

	}
	
	
}
