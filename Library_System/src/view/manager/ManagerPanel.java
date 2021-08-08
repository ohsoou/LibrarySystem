package view.manager;


import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.BookListTable;
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
