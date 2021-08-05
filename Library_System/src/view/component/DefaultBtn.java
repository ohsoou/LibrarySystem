package view.component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class DefaultBtn extends JButton{
	public DefaultBtn(String text) {
		this(text, 100, 40);
	}
	public DefaultBtn(String text, int width, int height) {
		super(text);
		setPreferredSize(new Dimension(width,height));
		
		setBackground(new Color(255, 95, 46)); 
		setForeground(new Color(255, 255, 255));
		setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		setBorderPainted(false); 
	}

}
