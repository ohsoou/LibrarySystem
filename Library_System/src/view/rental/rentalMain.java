package view.rental;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import model.dao.AllBookInfoDao;
import model.dto.AllBookInfo;
import view.defaultcomponent.DefaultPanel;


public class rentalMain extends DefaultPanel{
	
	private SearchedTableTopPanel topTable;
	private JPanel selectBtn;
	private rentalSearchPanel searchPanel;
	private SearchedTableUnderPanel underTable;
	private ArrayList<AllBookInfo> booklist;
	private JButton searchButton;
	public static boolean start;
	
	public rentalMain() {
		super();
		selectBtn = new rentalTopBtnPanel(); // 홈 대여 버튼있는 패널
		topTable = new SearchedTableTopPanel(); 
		searchPanel = new rentalSearchPanel();
		underTable = new SearchedTableUnderPanel();
		searchButton = searchPanel.getSearchButton();
        searchButton.addActionListener(new searchListener());
		
		add(selectBtn);// 메인 , 대여완료 버튼 판넬
	  	add(searchPanel); // 검색 판넬
		add(topTable); // 상단 책 고르는 판넬
	  	add(underTable); // 하단 대여목록 테이블
	  	  	
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
