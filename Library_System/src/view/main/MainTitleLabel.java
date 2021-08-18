package view.main;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;

import model.dto.Student;

public class MainTitleLabel extends JLabel{
	
	
	public MainTitleLabel(String string) {
		
		super("<html>Smart&nbsp;Library&nbsp;System</html>");
		setFont(new Font("±Ã¼­Ã¼", Font.BOLD, 52));
		setForeground(new Color(0, 78, 102));
		setBounds(20, 0, 200, 120);
	}
	
}
