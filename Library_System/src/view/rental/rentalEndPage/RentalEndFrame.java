package view.rental.rentalEndPage;


import view.defaultcomponent.DefaultFrame;

public class RentalEndFrame extends DefaultFrame {
	
		String path = "./image/componentImg/rentalEnd_btn.png";
		public static RentalEndFrame frameRental;
		
		public RentalEndFrame() {
			super();
			setFrame();
			add(new EndpageLabel());
			add(new RentalEndHomeBtn(path,150,150));
			add(new EndPageTimeLabel());			
			add(new EndPanel());
			
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
		new RentalEndFrame();
	}
}
