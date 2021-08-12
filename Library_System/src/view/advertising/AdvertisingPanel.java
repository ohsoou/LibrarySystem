package view.advertising;


import javax.swing.JPanel;

import view.component.DefaultPanel;

	/*
	 	[AdvertisingPanel]
	 	ž�г� �����г��� �پ��ִ� �����г�
	 */
public class AdvertisingPanel extends DefaultPanel{
	
	public AdvertisingPanel() {
		
		setLayout(null);
		
		JPanel top = new AdTopPanel();
		JPanel center = new AdCenterPanel();

		add(top);
		add(center);
		
	}
	
	
}
