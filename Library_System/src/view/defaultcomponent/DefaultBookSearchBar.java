package view.defaultcomponent;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Action;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DefaultBookSearchBar extends JTextField {
	public DefaultBookSearchBar() {
		setPreferredSize(new Dimension(445,40));
		setFont(new Font("���� ����", Font.PLAIN, 14));
	}
	
	public String LetterAndTrimText() {
		return getText().toLowerCase().trim();
	}

}

