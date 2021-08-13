package view.advertising;


import javax.swing.JPanel;

import view.defaultcomponent.DefaultFrame;

	/*
	 	[AdvertisingPanel]
	 	ž�г� �����г��� �پ��ִ� �����г�
	 */
public class AdvertisingFrame extends DefaultFrame{
	
	private JPanel top;
	private JPanel center;
	public AdvertisingFrame() {
		super();
		setFrame();
		
		setComp();
		setDesign();
	}
	
	@Override
	public void setComp() {
		top = new AdTopPanel();
		center = new AdCenterPanel();
		
	}

	@Override
	public void setDesign() {
		setLayout(null);
		
		add(top);
		add(center);
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
