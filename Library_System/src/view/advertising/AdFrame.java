package view.advertising;

import javax.swing.JPanel;

import view.DefaultFrame;

public class AdFrame extends DefaultFrame{
	public AdFrame() {
		
		JPanel adPanel = new AdvertisingPanel();
		
		add(adPanel);
		setVisible(true);
	}

	public static void main(String[] args) {
		new AdFrame();
	}
}
