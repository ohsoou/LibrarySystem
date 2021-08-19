package view.advertising;


import javax.swing.JPanel;

import view.defaultcomponent.DefaultFrame;

	/*
	 	[AdvertisingPanel]
	 	탑패널 센터패널이 붙어있는 최종패널
	 */
public class AdvertisingFrame extends DefaultFrame{
	
	public static JPanel top;
	public static JPanel center;
	public static AdvertisingFrame frame;
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
		center.invalidate();
		center.repaint();
		center.revalidate();
		top.invalidate();
		top.repaint();
		top.revalidate();
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
				frame = new AdvertisingFrame();
				frame.setVisible(true);
			}
		});
	}

	
}
