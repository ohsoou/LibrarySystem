package view.returns;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class returnTitleLable extends JLabel {
	public returnTitleLable(String text) {
		
		super(text,JLabel.CENTER);
		
		setFont(new Font("¸¼Àº °íµñ",Font.BOLD | Font.PLAIN,52));
		setForeground(new Color(0, 78, 102));
		setBorder(new EmptyBorder(40,0,20,0));
	} 
}

