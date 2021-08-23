package view.returns;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class ReturnTitleLable extends JLabel {
	public ReturnTitleLable(String text) {
		
		super(text,JLabel.CENTER);
		
		setFont(new Font("¸¼Àº °íµñ",Font.BOLD | Font.PLAIN,52));
		setForeground(new Color(0, 78, 102));
		 
	} 
}

