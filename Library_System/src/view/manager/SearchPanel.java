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

@SuppressWarnings("serial")
public class SearchPanel extends DefaultPanel{

	private JTextField searchBar;
	private JComboBox bookCategory;
	private ArrayList<AllBookInfo> booklist;
	private AllBookInfoDao bookinfodao;
	
	public SearchPanel() {
		super();
		setLayout(new FlowLayout(FlowLayout.LEFT, 50, 10));
		bookCategory = new DefaultBookCategoryDropDown();
		searchBar = new DefaultBookSearchBar();
		JButton searchBtn = new DefaultButton("검색");
		searchBtn.addActionListener(new searchListener());
		
		add(bookCategory);
		add(searchBar);
		add(searchBtn);
	}
	
	public ArrayList<AllBookInfo> getSearchedBookList() {
		return booklist;
	}
	
	private class searchListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			bookinfodao = AllBookInfoDao.getInstance();
			booklist = new ArrayList<>();
			int category = bookCategory.getSelectedIndex();
			
			String text = searchBar.getText();
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
		}
	}
}
