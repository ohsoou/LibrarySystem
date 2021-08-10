package view.rental;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.component.DefaultPanel;
import view.manager.TitleLabel;

public class selectTable extends DefaultPanel{
	
	public selectTable() {
		JPanel tablePanel = new rentalTable();
		setBounds(600,200,200,200);
		add(tablePanel);
	}

}
