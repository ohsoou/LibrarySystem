package view.rental;

import java.awt.FlowLayout;
import javax.swing.JButton;
import view.defaultcomponent.DefaultButton;
import view.defaultcomponent.DefaultPanel;


public class rentalTopBtnPanel extends DefaultPanel{
	
	
	JButton mainBtn;
	JButton selectBtn;
	public static RentalMainFrame rentalMain;
	public rentalTopBtnPanel() {
			
		setLayout(new FlowLayout(FlowLayout.LEFT, 700, 1));
		 mainBtn = new DefaultButton("����");
		 mainBtn.addActionListener(new selectBtnActionMain(mainBtn));
		 
	     selectBtn = new DefaultButton("���ÿϷ�");
	     selectBtn.addActionListener(new selectBtnAction(selectBtn));	     
	     
	     add(mainBtn);
	     add(selectBtn);
	}	
}
