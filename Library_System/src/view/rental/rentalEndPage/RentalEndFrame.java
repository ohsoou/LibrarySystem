package view.rental.rentalEndPage;


import view.defaultcomponent.DefaultFrame;

public class RentalEndFrame extends DefaultFrame {
	
		String path = "./image/componentImg/rentalEnd_btn.png";
		
		public RentalEndFrame() {
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
		add(new EndpageLabel());
		add(new RentalEndHomeBtn(path,150,150));
		add(new EndPageTimeLabel(this));			
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
