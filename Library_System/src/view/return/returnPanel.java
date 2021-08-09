package view.returns;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.component.DefaultPanel;

public class returnPanel extends DefaultPanel{

	public returnPanel() {
		super(); 
		
		// right, left border
		setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		JLabel title = new returnTitleLable("반납 페이지 입니다.");
		JPanel returnTable = new returnTable();
		
		add(title);
		add(returnTable);
		
	}
}
