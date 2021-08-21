package view.rental;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.dao.AllBookInfoDao;
import model.dto.AllBookInfo;
import view.defaultcomponent.DefaultBookCategoryDropDown;
import view.defaultcomponent.DefaultBookSearchBar;
import view.defaultcomponent.DefaultButton;
import view.defaultcomponent.DefaultPanel;


public class RentalMain extends DefaultPanel{
	
	private SearchedTableTopPanel topTable;
	private JPanel selectBtn;
	private SearchedTableUnderPanel underTable;
	private ArrayList<AllBookInfo> booklist;
	private JButton searchButton;
	public static boolean start;
	
	private JComboBox bookCategory;
	private JTextField searchBar;
	private Container searchPane;
	
	private boolean trigger = true;
	
	public RentalMain() {
		super();
		selectBtn = new RentalTopBtnPanel(); // 홈 대여 버튼있는 패널
		topTable = new SearchedTableTopPanel(); 
		searchPane = setSearchPane();
		underTable = new SearchedTableUnderPanel();
		
		add(selectBtn);// 메인 , 대여완료 버튼 판넬
	  	add(searchPane); // 검색 판넬
		add(topTable); // 상단 책 고르는 판넬
	  	add(underTable); // 하단 대여목록 테이블
	  	  	
	}
	private Container setSearchPane() {
		Container con = new Container();
		con.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 10));
		
		bookCategory = new DefaultBookCategoryDropDown();
		searchBar = new DefaultBookSearchBar();
		searchButton = new DefaultButton("검색");
		searchButton.addActionListener(new searchListener());
		
		con.add(bookCategory);
		con.add(searchBar);
		con.add(searchButton);
		
		return con;
	}
	
	private class searchListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int category = bookCategory.getSelectedIndex();
			String text = ((DefaultBookSearchBar) searchBar).LetterAndTrimText();

			ArrayList<AllBookInfo> booklists = new ArrayList<>();
			if(trigger) {
			StoregeBook.setSelectedBooks(SearchedTableTopPanel.getBooklist());
			trigger = false;
			}
			SearchedTableTopPanel.setBooklist(StoregeBook.getSelectedBooks());
			
			switch (category) {
			case 1: // 책이름 찾을단어 text는 왼쪽 기준은 오른쪽
				for(int i = 0; i < SearchedTableTopPanel.getBooklist().size(); ++i) {

					if(SearchedTableTopPanel.getBooklist().get(i).getBook_name().toLowerCase().contains(text)) {
						booklists.add(SearchedTableTopPanel.getBooklist().get(i));
					}
				}
				booklist = booklists;
				break;
			case 2: // 저자
				for(int i = 0; i < SearchedTableTopPanel.getBooklist().size(); ++i) {
					if(SearchedTableTopPanel.getBooklist().get(i).getAuthor().toLowerCase().contains(text)) {
						booklists.add(SearchedTableTopPanel.getBooklist().get(i));
					}
				}
				booklist = booklists;
				break;
			case 3: // 출판사
				for(int i = 0; i < SearchedTableTopPanel.getBooklist().size(); ++i) {
					if(SearchedTableTopPanel.getBooklist().get(i).getPublisher().toLowerCase().contains(text)) {
						booklists.add(SearchedTableTopPanel.getBooklist().get(i));
					}
				}
				
				booklist = booklists;
				break;
			case 4: // 장르
				for(int i = 0; i < SearchedTableTopPanel.getBooklist().size(); ++i) {
					if(SearchedTableTopPanel.getBooklist().get(i).getCategory_name().contains(text)) {
						booklists.add(SearchedTableTopPanel.getBooklist().get(i));
					}
				}	
				booklist = booklists;
				break;
			default: // 전체
				for(int i = 0; i < SearchedTableTopPanel.getBooklist().size(); ++i) {
					if(SearchedTableTopPanel.getBooklist().get(i).getPublisher().toLowerCase().contains(text) || SearchedTableTopPanel.getBooklist().get(i).getAuthor().toLowerCase().contains(text) ||
							SearchedTableTopPanel.getBooklist().get(i).getBook_name().toLowerCase().contains(text) || SearchedTableTopPanel.getBooklist().get(i).getCategory_name().toLowerCase().contains(text)) {
						booklists.add(SearchedTableTopPanel.getBooklist().get(i));
					}
				}				
				booklist = booklists;
				break;
			} 

			topTable.setBooklist(booklist);
			topTable.getFirstPageButton().doClick();
		}		
	}
}
