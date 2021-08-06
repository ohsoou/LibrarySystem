package view.main;

import javax.swing.JPanel;

public class MainPanel extends JPanel{
	
	public MainPanel() {
		
		setLayout(null);
		
		add(new TopPanel());
		add(new UnderPanel());
		
		setVisible(true);
		
	}

}
