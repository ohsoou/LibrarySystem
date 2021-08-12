package view.advertising;

import view.component.DefaultPanel;
import view.main.CenterPanel;
import view.main.TopPanel;
	/*
	 	[AdvertisingPanel]
	 	탑패널 센터패널이 붙어있는 최종패널
	 */
public class AdvertisingPanel extends DefaultPanel{
	
	public AdvertisingPanel() {
		
		setLayout(null);
		
		add(new AdTopPanel());
		add(new AdCenterPanel());
		
		setVisible(true);
	}
}
