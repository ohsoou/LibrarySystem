package view.main;

import javax.swing.JPanel;

import view.component.DefaultPanel;

public class MainPanel extends DefaultPanel{
	
	public MainPanel() {
		
		setLayout(null);
		
		add(new TopPanel());
		add(new CenterPanel());
		
		setVisible(true);
		
	}

}
