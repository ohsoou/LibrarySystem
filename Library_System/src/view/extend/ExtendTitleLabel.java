package view.extend;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class ExtendTitleLabel extends JLabel{
	public ExtendTitleLabel(String text) {
		super(text,JLabel.CENTER);
		 
		setFont(new Font("¸¼Àº °íµñ",Font.BOLD | Font.PLAIN,52));
		setForeground(new Color(0, 78, 102));
	} 
}
