package view.manager;

import java.awt.Color;

import javax.swing.JPanel;

public class ManagerPanel extends JPanel{
	
	public ManagerPanel() {
		setBackground(new Color(225, 238, 246));
		
		JPanel title = new TitlePanel();
		JPanel search = new SearchPanel();
		
		add(title);
		add(search);
	}
	

}
