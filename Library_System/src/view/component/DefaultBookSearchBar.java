package view.component;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DefaultBookSearchBar extends JTextField {
	public DefaultBookSearchBar() {
		setPreferredSize(new Dimension(445,40));
		setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
	}

}
