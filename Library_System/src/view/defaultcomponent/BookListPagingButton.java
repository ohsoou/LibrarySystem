package view.defaultcomponent;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JToggleButton;
import javax.swing.plaf.metal.MetalToggleButtonUI;


public class  BookListPagingButton extends JToggleButton{
	public BookListPagingButton(String text) {	
		super(text);
		
		setBounds(390, 420, 45, 35);
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
		if(isSelected()) {
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
