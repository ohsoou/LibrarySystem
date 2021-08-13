package view.rental;

import view.defaultcomponent.DefaultFrame;
import view.manager.ManagerFrame;

public class TestFrame extends DefaultFrame {
	public TestFrame() {
		super();
		setFrame();
		add(new rentalMain());
	}
	@Override
	public void setComp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDesign() {
		// TODO Auto-generated method stub

	}
	
	public static void main(String[] args) {
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				TestFrame frame = new TestFrame();
				frame.setVisible(true);
			}
		});
	}
}
