package view.rental;

import java.awt.FlowLayout;
import javax.swing.JButton;
import view.defaultcomponent.DefaultButton;
import view.defaultcomponent.DefaultPanel;


public class RentalTopBtnPanel extends DefaultPanel{
	
	
	JButton mainBtn;
	JButton selectBtn;
	public static RentalMainFrame rentalMain;
	public RentalTopBtnPanel() {
			
		setLayout(new FlowLayout(FlowLayout.LEFT, 700, 1));
		 mainBtn = new DefaultButton("메인");
		 mainBtn.addActionListener(new SelectBtnActionMain(mainBtn));
		 
	     selectBtn = new DefaultButton("선택완료");
	     selectBtn.addActionListener(new SelectBtnAction(selectBtn));	     
	     
	     add(mainBtn);
	     add(selectBtn);
	}	
}
