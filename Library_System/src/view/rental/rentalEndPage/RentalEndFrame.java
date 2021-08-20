package view.rental.rentalEndPage;


import view.defaultcomponent.DefaultFrame;

public class RentalEndFrame extends DefaultFrame {

	String path = "./image/componentImg/rentalEnd_btn.png";

	public RentalEndFrame() {
		super();
		setFrame();
		setComp();
		setDesign();
	}

	@Override
	public void setComp() {

	}

	@Override
	public void setDesign() {
		add(new EndPageTimeLabel(this));
		add(new EndpageLabel());
		add(new RentalEndHomeBtn(path, 150, 150));
		add(new EndPanel());

	}

	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				RentalEndFrame frame = new RentalEndFrame();
				frame.setVisible(true);
			}
		});
	}

}
