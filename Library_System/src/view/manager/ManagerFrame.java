package view.manager;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.dao.AllBookInfoDao;
import model.dto.AllBookInfo;
import view.DefaultFrame;
import view.component.DefaultTablePanel;

public class ManagerFrame extends DefaultFrame{
	private DefaultTablePanel tablePanel;
	
	private SearchPanel searchPanel;
	private JButton searchButton;
	private BookListWithSelectedBook currentTableState;
	
	public ManagerFrame() {
		super();
		
		setLayout(new FlowLayout());
        
		currentTableState = new BookListWithSelectedBook();
		JPanel titlePanel = new TitlePanel();
		
		searchPanel = new SearchPanel();
		searchButton = searchPanel.getSearchButton();
		searchButton.addActionListener(new searchListener());
		
		tablePanel = new DefaultTablePanel();
		

		add(titlePanel);
		add(searchPanel);
		add(tablePanel);
		
		
		setVisible(true);
	
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


			int category = searchPanel.getBookCategory().getSelectedIndex();
			String text = searchPanel.getSearchBar().getText();
			
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
		}
		
	}
	

}
