package view.rental;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.component.DefaultPanel;
import view.manager.SearchPanel;
import view.manager.TablePanel;
import view.manager.TitleLabel;

public class rentalPanel extends DefaultPanel{
	
	public rentalPanel() {
		super();
		JPanel selectBtn = new rentalTopPanel();
		//JPanel table = new TablePanel();
		JLabel title = new TitleLabel("선택 항목");
		JPanel table2 = new selectTable();

		add(selectBtn);
	  	add(table);
	  	add(title);
	  	add(table2);
	}

}
