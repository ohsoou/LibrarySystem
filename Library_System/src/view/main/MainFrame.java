package view.main;

import view.component.DefaultFrame;


public class MainFrame extends DefaultFrame{
	
	public MainFrame() {
		
		setLayout(null);
		
		add(new TopPanel());
		add(new CenterPanel());
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
			}
		});

	}

}
