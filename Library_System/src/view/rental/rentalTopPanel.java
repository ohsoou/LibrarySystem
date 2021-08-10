package view.rental;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.component.DefaultButton;
import view.component.DefaultPanel;

public class rentalTopPanel extends DefaultPanel implements ActionListener{
	
	
	JButton mainBtn;
	JButton selectBtn;
	public rentalTopPanel() {
		
		setLayout(new FlowLayout(FlowLayout.LEFT, 700, 10));
		
		 mainBtn = new DefaultButton("메인"); 

	     selectBtn = new DefaultButton("선택완료");
	     
	     add(mainBtn);
	     add(selectBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(mainBtn.getText().equals("메인")) {
			
		}else if(selectBtn.getText().equals("선택완료")) {
			
		}
		
	}

}
