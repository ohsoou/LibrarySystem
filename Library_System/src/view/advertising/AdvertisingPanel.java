package view.advertising;

import view.component.DefaultPanel;
import view.main.CenterPanel;
import view.main.TopPanel;
	/*
	 	[AdvertisingPanel]
	 	ž�г� �����г��� �پ��ִ� �����г�
	 */
public class AdvertisingPanel extends DefaultPanel{
	
	public AdvertisingPanel() {
		
		setLayout(null);
		
		add(new AdTopPanel());
		add(new AdCenterPanel());
		
		setVisible(true);
	}
}
