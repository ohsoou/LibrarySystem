package view.manager;

import javax.swing.JPanel;

import view.component.DefaultPanel;

public class ManagerPanel extends DefaultPanel{
	
	public ManagerPanel() {
		super();
		
		JPanel title = new TitlePanel();
		JPanel search = new SearchPanel();
		
		add(title);
		add(search);
	  
		add(new TablePanel());
	
	  //add(new BookListTable());
	}
	

}
