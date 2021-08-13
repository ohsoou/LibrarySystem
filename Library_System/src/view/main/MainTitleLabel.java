package view.main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class MainTitleLabel extends JLabel{
	
	public MainTitleLabel() {
		
		super("<html>Smart&nbsp;Library&nbsp;System</html>");
		setFont(new Font("�ü�ü", Font.BOLD, 52));
		setForeground(new Color(0, 78, 102));
		setBounds(20, 0, 200, 120);
	}

}
