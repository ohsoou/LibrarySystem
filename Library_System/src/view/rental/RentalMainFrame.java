package view.rental;

import view.defaultcomponent.DefaultFrame;
import view.manager.ManagerFrame;

public class RentalMainFrame extends DefaultFrame {
	public RentalMainFrame() {
		super();
		setFrame();
		add(new RentalMain());
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
				RentalMainFrame frame = new RentalMainFrame();
				frame.setVisible(true);
			}
		});
	}
}
