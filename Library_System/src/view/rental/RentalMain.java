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


public class RentalMain extends DefaultPanel{
	
	private SearchedTableTopPanel topTable;
	private JPanel selectBtn;
	private RentalSearchPanel searchPanel;
	private SearchedTableUnderPanel underTable;
	private ArrayList<AllBookInfo> booklist;
	private JButton searchButton;
	public static boolean start;
	private boolean trigger = true;
	
	public RentalMain() {
		super();
		selectBtn = new RentalTopBtnPanel(); // Ȩ �뿩 ��ư�ִ� �г�
		topTable = new SearchedTableTopPanel(); 
		searchPanel = new RentalSearchPanel();
		underTable = new SearchedTableUnderPanel();
		searchButton = searchPanel.getSearchButton();
        searchButton.addActionListener(new searchListener());
		
		add(selectBtn);// ���� , �뿩�Ϸ� ��ư �ǳ�
	  	add(searchPanel); // �˻� �ǳ�
		add(topTable); // ��� å ���� �ǳ�
	  	add(underTable); // �ϴ� �뿩��� ���̺�
	  	  	
	}
	
	private class searchListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int category = searchPanel.getBookCategory().getSelectedIndex();
			String text = searchPanel.getSearchBar().getText();

			ArrayList<AllBookInfo> booklists = new ArrayList<>();
			if(trigger) {
			StoregeBook.setSelectedBooks(SearchedTableTopPanel.getBooklist());
			trigger = false;
			}
			SearchedTableTopPanel.setBooklist(StoregeBook.getSelectedBooks());
			
			switch (category) {
			case 1: // å�̸� ã���ܾ� text�� ���� ������ ������
				for(int i = 0; i < SearchedTableTopPanel.getBooklist().size(); ++i) {

					if(SearchedTableTopPanel.getBooklist().get(i).getBook_name().contains(text)) {
						booklists.add(SearchedTableTopPanel.getBooklist().get(i));
					}
				}
				booklist = booklists;
				break;
			case 2: // ����
				for(int i = 0; i < SearchedTableTopPanel.getBooklist().size(); ++i) {
					if(SearchedTableTopPanel.getBooklist().get(i).getAuthor().contains(text)) {
						booklists.add(SearchedTableTopPanel.getBooklist().get(i));
					}
				}
				booklist = booklists;
				break;
			case 3: // ���ǻ�
				for(int i = 0; i < SearchedTableTopPanel.getBooklist().size(); ++i) {
					if(SearchedTableTopPanel.getBooklist().get(i).getPublisher().contains(text)) {
						booklists.add(SearchedTableTopPanel.getBooklist().get(i));
					}
				}
				
				booklist = booklists;
				break;
			default: // ��ü
				for(int i = 0; i < SearchedTableTopPanel.getBooklist().size(); ++i) {
					if(SearchedTableTopPanel.getBooklist().get(i).getPublisher().contains(text) || SearchedTableTopPanel.getBooklist().get(i).getAuthor().contains(text) ||
							SearchedTableTopPanel.getBooklist().get(i).getBook_name().contains(text)) {
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
