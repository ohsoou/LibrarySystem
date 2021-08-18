package view.rental.rentalEndPage;

import javax.swing.JLabel;

import view.defaultcomponent.DefaultFrame;
import view.rental.RentalMainFrame;
import view.rental.rentalMain;

public class rentalEndFrame extends DefaultFrame {
	
		public static rentalEndFrame frame; 
		public rentalEndFrame() {
			super();
			setFrame();
			add(new EndpageLabel());
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

}
