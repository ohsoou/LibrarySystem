package view.main;

import view.defaultcomponent.DefaultFrame;


public class MainFrame extends DefaultFrame{
	
	public MainFrame() {

		super();
		setFrame();
		
		setLayout(null);
		
		setComp();
		setDesign();
	}
	
	@Override
	public void setComp() {

	}

	@Override
	public void setDesign() {
		add(new TopPanel());
		add(new CenterPanel());
		
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
