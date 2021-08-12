package view.advertising;


import javax.swing.JPanel;

import view.component.DefaultPanel;

	/*
	 	[AdvertisingPanel]
	 	탑패널 센터패널이 붙어있는 최종패널
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
