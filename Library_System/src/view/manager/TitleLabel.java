package view.manager;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TitleLabel extends JLabel{
	
	public TitleLabel(String text) {
		
		super(text);
		setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 52));
		setForeground(new Color(0, 78, 102));
		setBounds(20, 0, 200, 120);
	}

}
