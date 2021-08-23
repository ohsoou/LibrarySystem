package main;
import view.advertising.AdvertisingFrame;

public class Main {

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				AdvertisingFrame frame = new AdvertisingFrame();
				frame.setVisible(true);
			}
		});
	}
}
