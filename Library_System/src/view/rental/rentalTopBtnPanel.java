package view.rental;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.defaultcomponent.DefaultButton;
import view.defaultcomponent.DefaultPanel;


public class rentalTopBtnPanel extends DefaultPanel implements ActionListener{
	
	
	JButton mainBtn;
	JButton selectBtn;
	public rentalTopBtnPanel() {
		
		setLayout(new FlowLayout(FlowLayout.LEFT, 700, 1));
		
		 mainBtn = new DefaultButton("����"); 

	     selectBtn = new DefaultButton("���ÿϷ�");
	     
	     add(mainBtn);
	     add(selectBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(mainBtn.getText().equals("����")) {
			
		}else if(selectBtn.getText().equals("���ÿϷ�")) {
			
		}
		
	}

}