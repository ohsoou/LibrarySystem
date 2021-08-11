package view.rental;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.dao.AllBookInfoDao;
import model.dto.AllBookInfo;
import view.component.DefaultPanel;
import view.manager.TitleLabel;

public class rentalMain extends DefaultPanel{
	
	private SearchedTopPanel topTable;
	private static AllBookInfo selectedBook;
	private static AllBookInfo selectedBook2;
	private JTable table;
	private JTable table2;
	private JPanel selectBtn;
	private rentalSearchPanel searchPanel;
	private SearchedTableUnderPanel underTable;
	private ArrayList<AllBookInfo> booklist;
	private ArrayList<AllBookInfo> selectionlist;
	public static boolean start;
	
	public rentalMain() {
		super();
		selectBtn = new rentalTopBtnPanel(); // 홈 대여 버튼있는 패널
		topTable = new SearchedTopPanel(); // 
		searchPanel = new rentalSearchPanel();
		underTable = new SearchedTableUnderPanel();
		table = topTable.getTable(); // 탑테이블
		table2 = underTable.getTable(); // 언더테이블
		table.getSelectionModel().addListSelectionListener(new selectTableRowListener());
		table2.getSelectionModel().addListSelectionListener(new selectTableRowListener2());

		add(selectBtn);// 메인 , 대여완료 버튼 판넬
	  	add(searchPanel); // 검색 판넬
		add(topTable); // 상단 책 고르는 판넬
	  	add(underTable); // 하단 대여목록 테이블
	  	
	}
	public static AllBookInfo getSelectedBook() {
		return selectedBook;
	}
	public static AllBookInfo getSelectedBook2() {
		return selectedBook2;
	}

	private class selectTableRowListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
				booklist = topTable.getBooklist();
				int startIndex = topTable.getStartIndex();
				selectedBook = booklist.get(startIndex + table.getSelectedRow());
				System.out.println(selectedBook);
				underTable.rentalbooklist.add(selectedBook);
				start = true;
			}

		}
	}
	private class selectTableRowListener2 implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
				booklist = underTable.getBooklist();
				int startIndex = underTable.getStartIndex();
				selectedBook2 = booklist.get(startIndex + table2.getSelectedRow());
				System.out.println(selectedBook2);
			}
			
		}
	}
	
	private class searchListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			booklist = topTable.getBooklist();
			booklist.clear();
			topTable.setBooklist(booklist);

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
			topTable.setBooklist(booklist);
			topTable.getFirstPageButton().doClick();
		}
		
	}

}
