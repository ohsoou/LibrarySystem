package view.defaultcomponent;

import java.awt.Color;

import javax.swing.JPanel;

public class DefaultPanel extends JPanel{
	
	public DefaultPanel() {
		this(new Color(225, 238, 246));
	}
	
	public DefaultPanel(Color color) {
		setBackground(color);
	}
	

}

