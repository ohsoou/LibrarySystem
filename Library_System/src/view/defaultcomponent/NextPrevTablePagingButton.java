package view.defaultcomponent;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.plaf.metal.MetalToggleButtonUI;

public class NextPrevTablePagingButton extends JButton {
	public NextPrevTablePagingButton(String text) {
		super(text);
		
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		setPreferredSize(new Dimension(45, 30));
		setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		setBorderPainted(false); 
		
		setUI(new MetalToggleButtonUI() {
		    @Override
		    protected Color getSelectColor() {
		        return new Color(255, 95, 46);
		    }
		    
		});
	}
	
	public void paintComponent(Graphics g) {
		Color bg, txt;
		if(getModel().isPressed()) {
			bg = new Color(255, 95, 46);
			txt = new Color(255, 255, 255);
		} else {
			bg = new Color(255, 240, 240);
			txt = new Color(96, 96, 96);
		}
		setBackground(bg);
		setForeground(txt);
		super.paintComponent(g);
	}
}
