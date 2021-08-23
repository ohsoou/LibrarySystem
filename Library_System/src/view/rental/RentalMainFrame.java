package view.rental;

import view.defaultcomponent.DefaultFrame;

public class RentalMainFrame extends DefaultFrame {
	public RentalMainFrame() {
		super();
		setFrame();
		setDesign();
	}

	@Override
	public void setComp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDesign() {
		add(new RentalMain());

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
