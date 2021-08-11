package view.rental;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import view.component.DefaultBookCategoryDropDown;
import view.component.DefaultBookSearchBar;
import view.component.DefaultButton;
import view.component.DefaultPanel;


public class rentalSearchPanel extends DefaultPanel{
	private JTextField searchBar;
	private JComboBox bookCategory;
	private JButton searchButton;
	
	public rentalSearchPanel() {
		setLayout(new FlowLayout(FlowLayout.LEFT, 50, 10));
		bookCategory = new DefaultBookCategoryDropDown();
		searchBar = new DefaultBookSearchBar();
		searchButton = new DefaultButton("검색");
		
		add(bookCategory);
		add(searchBar);
		add(searchButton);
	}
	
	// ManagerPanel Action에서 사용
	public JButton getSearchButton() {
		return searchButton;
	}

	public JTextField getSearchBar() {
		return searchBar;
	}

	public JComboBox getBookCategory() {
		return bookCategory;
	}

}
