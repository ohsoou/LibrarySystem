package view.manager;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.dao.AllBookInfoDao;
import model.dto.AllBookInfo;
import view.component.DefaultBookCategoryDropDown;
import view.component.DefaultBookSearchBar;
import view.component.DefaultButton;
import view.component.DefaultPanel;
import view.component.DefaultTablePanel;


public class SearchPanel extends DefaultPanel{
	private JTextField searchBar;
	private JComboBox bookCategory;
	private JButton searchButton;
	private DefaultTablePanel tablePanel;
	private BookListWithSelectedBook currentTableState;
	public SearchPanel(DefaultTablePanel tablePanel) {
		setLayout(new FlowLayout(FlowLayout.LEFT, 50, 10));
		this.tablePanel = tablePanel;
		this.currentTableState = new BookListWithSelectedBook();
		
		bookCategory = new DefaultBookCategoryDropDown();
		searchBar = new DefaultBookSearchBar();
		searchButton = new DefaultButton("검색");
		searchButton.addActionListener(new searchListener());
		add(bookCategory);
		add(searchBar);
		add(searchButton);
		
	}
	public JButton getSearchButton() {
		return searchButton;
	}
	private class searchListener implements ActionListener {
		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<AllBookInfo> booklist = currentTableState.getBooklist();
			booklist.clear();
			currentTableState.setBooklist(booklist);

			int category = bookCategory.getSelectedIndex();
			String text = searchBar.getText();
			
			AllBookInfoDao allbookinfodao = AllBookInfoDao.getInstance();
			
			switch (category) {
			case 1: // 책이름
				booklist = allbookinfodao.listByBookName(text);
				break;
			case 2: // 저자
				booklist = allbookinfodao.listByAuthor(text);
				break;
			case 3: // 출판사
				booklist = allbookinfodao.listByPublisher(text);
				break;
			default: // 전체
				booklist = allbookinfodao.listBySomethig(text);
				break;
			} 
			currentTableState.setFilter(category);
			currentTableState.setSearchedText(text);
			currentTableState.setBooklist(booklist);
			tablePanel.getFirstPageButton().doClick();
			currentTableState.setSelectedBook(null);
		}
		
	}

}
