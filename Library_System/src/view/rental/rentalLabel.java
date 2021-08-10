package view.rental;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class rentalLabel extends JLabel{
	
	public rentalLabel(String text) {
		super(text);
		setFont(new Font("궁서체", Font.BOLD, 45));
		setForeground(new Color(0, 78, 102));
		setBounds(20, 0, 200, 120);
	}

}
