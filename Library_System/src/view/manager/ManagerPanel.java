package view.manager;

import javax.swing.JPanel;

import view.component.DefaultPanel;

public class ManagerPanel extends DefaultPanel{
	
	public ManagerPanel() {
		super();
		
		JPanel title = new TitlePanel();
		JPanel table = new TablePanel();
		
		add(title);
	  	add(table);
	
	}
	

}
