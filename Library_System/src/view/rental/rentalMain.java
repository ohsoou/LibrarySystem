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
		selectBtn = new rentalTopBtnPanel(); // Ȩ �뿩 ��ư�ִ� �г�
		topTable = new SearchedTableTopPanel(); 
		searchPanel = new rentalSearchPanel();
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
			booklist = topTable.getBooklist();
			booklist.clear();
			topTable.setBooklist(booklist);
			
			int category = searchPanel.getBookCategory().getSelectedIndex();
			String text = searchPanel.getSearchBar().getText();
			
			AllBookInfoDao bookinfodao = AllBookInfoDao.getInstance();

			switch (category) {
			case 1: // å�̸�
				booklist = bookinfodao.listByBookName(text);
				break;
			case 2: // ����
				booklist = bookinfodao.listByAuthor(text);
				break;
			case 3: // ���ǻ�
				booklist = bookinfodao.listByPublisher(text);
				break;
			default: // ��ü
				booklist = bookinfodao.listBySomethig(text);
				break;
			} 
			topTable.setBooklist(booklist);
			topTable.getFirstPageButton().doClick();
		}
		
	}

}
