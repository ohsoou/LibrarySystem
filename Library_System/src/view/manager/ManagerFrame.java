package view.manager;


import java.awt.FlowLayout;


import javax.swing.JButton;
import javax.swing.JPanel;

import view.component.DefaultFrame;
import view.component.DefaultTablePanel;

public class ManagerFrame extends DefaultFrame{
	private DefaultTablePanel tablePanel;
	
	private SearchPanel searchPanel;
	private JButton searchButton;
	
	public ManagerFrame() {
		super();
		
		setLayout(new FlowLayout());
        
		JPanel titlePanel = new TitlePanel();
		tablePanel = new DefaultTablePanel();
		searchPanel = new SearchPanel(tablePanel);
		searchButton = searchPanel.getSearchButton();
		
		add(titlePanel);
		add(searchPanel);
		add(tablePanel);
		
		setVisible(true);
	
	}
	public JButton getSearchButton() {
		return searchButton;
	}
	
	public static void main(String[] args) {
		new ManagerFrame();
	}
	

}
