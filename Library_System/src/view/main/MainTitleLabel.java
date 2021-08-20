package view.main;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;

import model.dto.Student;

public class MainTitleLabel extends JLabel{
	
	
	public MainTitleLabel(String string) {
		
		super("Smart Library System");
		setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 52));
		setForeground(new Color(0, 78, 102));
		setBounds(20, 0, 200, 120);
	}
	
}
