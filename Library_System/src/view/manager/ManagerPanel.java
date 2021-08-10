package view.manager;

import javax.swing.JPanel;

import view.component.DefaultPanel;
import view.component.DefaultSearchedTablePanel;

public class ManagerPanel extends DefaultPanel{
	
	public ManagerPanel() {
		super();
		
		JPanel title = new TitlePanel();
		JPanel table = new DefaultSearchedTablePanel();
		
		add(title);
	  	add(table);
	
	}
	

}
