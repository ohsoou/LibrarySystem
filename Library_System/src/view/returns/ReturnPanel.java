package view.returns;

import java.util.Vector;

import javax.swing.BorderFactory;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.defaultcomponent.DefaultPanel;

public class ReturnPanel extends DefaultPanel{

	public ReturnPanel() {
		super(); 
		
		// right, left border
		setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		JLabel title = new ReturnTitleLable("반납 페이지 입니다.");
		JPanel returnTable = new ReturnTable();
		
		add(title);
		add(returnTable);
	
	}
} 
 