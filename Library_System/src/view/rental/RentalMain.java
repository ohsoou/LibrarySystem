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
		selectBtn = new RentalTopBtnPanel(); // Ȩ �뿩 ��ư�ִ� �г�
		topTable = new SearchedTableTopPanel(); 
		searchPane = setSearchPane();
		underTable = new SearchedTableUnderPanel();
		
		add(selectBtn);// ���� , �뿩�Ϸ� ��ư �ǳ�
	  	add(searchPane); // �˻� �ǳ�
		add(topTable); // ��� å ���� �ǳ�
	  	add(underTable); // �ϴ� �뿩��� ���̺�
	  	  	
	}
	private Container setSearchPane() {
		Container con = new Container();
		con.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 10));
		
		bookCategory = new DefaultBookCategoryDropDown();
		searchBar = new DefaultBookSearchBar();
		searchButton = new DefaultButton("�˻�");
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
			case 1: // å�̸� ã���ܾ� text�� ���� ������ ������
				for(int i = 0; i < SearchedTableTopPanel.getBooklist().size(); ++i) {

					if(SearchedTableTopPanel.getBooklist().get(i).getBook_name().toLowerCase().contains(text)) {
						booklists.add(SearchedTableTopPanel.getBooklist().get(i));
					}
				}
				booklist = booklists;
				break;
			case 2: // ����
				for(int i = 0; i < SearchedTableTopPanel.getBooklist().size(); ++i) {
					if(SearchedTableTopPanel.getBooklist().get(i).getAuthor().toLowerCase().contains(text)) {
						booklists.add(SearchedTableTopPanel.getBooklist().get(i));
					}
				}
				booklist = booklists;
				break;
			case 3: // ���ǻ�
				for(int i = 0; i < SearchedTableTopPanel.getBooklist().size(); ++i) {
					if(SearchedTableTopPanel.getBooklist().get(i).getPublisher().toLowerCase().contains(text)) {
						booklists.add(SearchedTableTopPanel.getBooklist().get(i));
					}
				}
				
				booklist = booklists;
				break;
			case 4: // �帣
				for(int i = 0; i < SearchedTableTopPanel.getBooklist().size(); ++i) {
					if(SearchedTableTopPanel.getBooklist().get(i).getCategory_name().contains(text)) {
						booklists.add(SearchedTableTopPanel.getBooklist().get(i));
					}
				}	
				booklist = booklists;
				break;
			default: // ��ü
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
