package view.rental.rentalEndPage;


import view.defaultcomponent.DefaultFrame;

public class rentalEndFrame extends DefaultFrame {
	
		String path = "./image/componentImg/rentalEnd_btn.png";
		public static rentalEndFrame frameRental;
		
		public rentalEndFrame() {
			super();
			setFrame();
			EndPageTimeLabel endPageTimeLabel = new EndPageTimeLabel();
			add(new EndpageLabel());
			add(new rentalEndHomeBtn(path,150,150));
			add(endPageTimeLabel);		
			endPageTimeLabel.setEnabled(false);			
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
}
