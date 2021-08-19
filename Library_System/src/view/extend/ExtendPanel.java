package view.extend;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.defaultcomponent.DefaultPanel;

public class ExtendPanel extends DefaultPanel{

	public ExtendPanel() {
		super(); 
		
		setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		JLabel title = new ExtendTitleLabel("연장 페이지 입니다.");
		JPanel extendTable = new ExtendTable();
		
		add(title);
		add(extendTable);
	
	}
} 
