package view.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.dao.AllBookInfoDao;
import model.dto.AllBookInfo;
import view.component.DefaultPanel;
import view.component.DefaultTablePanel;

public class ManagerPanel extends DefaultPanel{
	private DefaultTablePanel tablePanel;
	private JTable table;
	private AllBookInfo selectedBook;
	
	private SearchPanel searchPanel;
	private JButton searchButton;
	
	public ManagerPanel() {
		super();
		
		JPanel titlePanel = new TitlePanel();
		
		searchPanel = new SearchPanel();
		searchButton = searchPanel.getSearchButton();
		searchButton.addActionListener(new searchListener());
		
		tablePanel = new DefaultTablePanel();
		table = tablePanel.getTable();
		table.getSelectionModel().addListSelectionListener(new selectTableRowListener());
		
		
		add(titlePanel);
		add(searchPanel);
		add(tablePanel);
	 
	
	}
	
	public AllBookInfo getSelectedBook() {
		return selectedBook;
	}

	private class selectTableRowListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
				ArrayList<AllBookInfo> booklist = tablePanel.getBooklist();
				int startIndex = tablePanel.getStartIndex();
				selectedBook = booklist.get(startIndex + table.getSelectedRow());
				System.out.println(selectedBook);
			}

		}
	}
	
	private class searchListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<AllBookInfo> booklist = tablePanel.getBooklist();
			booklist.clear();
			tablePanel.setBooklist(booklist);

			int category = searchPanel.getBookCategory().getSelectedIndex();
			String text = searchPanel.getSearchBar().getText();
			
			AllBookInfoDao bookinfodao = AllBookInfoDao.getInstance();
			
			switch (category) {
			case 1: // 책이름
				booklist = bookinfodao.listByBookName(text);
				break;
			case 2: // 저자
				booklist = bookinfodao.listByAuthor(text);
				break;
			case 3: // 출판사
				booklist = bookinfodao.listByPublisher(text);
				break;
			default: // 전체
				booklist = bookinfodao.listBySomethig(text);
				break;
			} 
			tablePanel.setBooklist(booklist);
			tablePanel.getFirstPageButton().doClick();
		}
		
	}

}
