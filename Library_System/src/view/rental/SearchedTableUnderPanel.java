package view.rental;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.dao.AllBookInfoDao;
import model.dto.AllBookInfo;
import view.component.DefaultPanel;
import view.manager.BookListTable;

public class SearchedTableUnderPanel extends DefaultPanel{

	public static int count;
	private AllBookInfo selectedBook;
	public ArrayList<AllBookInfo> rentalbooklist;
	private AllBookInfoDao bookinfodao;
	private DefaultTableModel model;
	private JTable table;
	private int startIndex = 0;
	
	public SearchedTableUnderPanel() {
		 setBackground(new Color(225, 238, 246));
	     setLayout(new GridLayout(2, 1));
		
		String[] columnNames = { "ISBN", "KDC", "도서명", "저자", "출판사", "출판일", "장르", "대여상태" };
		String[][] contents = new String[3][8];
		contents = rentalTableBookList(contents);
        
		model = new DefaultTableModel(contents, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table = new JTable(model);
        JScrollPane tablePane = new rentalUnderPane(table);
        add(tablePane);
	}
	
	// ManagerPanel Action줄 때 씀
		public int getStartIndex() {
			return startIndex;
		}

		public ArrayList<AllBookInfo> getBooklist() {
			return rentalbooklist;
		}
		public void setBooklist(ArrayList<AllBookInfo> rentalbooklist) {
			this.rentalbooklist = rentalbooklist;
		}

		public JTable getTable() {
			return table;
		}
		
	// 1개씩 넘어와야한다
	
	// 마우스로 클릭한 정보들이 넘어와야함 더블클릭이든 뭐든.
	private String[][] rentalTableBookList(String[][] contents) {
		bookinfodao = AllBookInfoDao.getInstance();
		rentalbooklist = new ArrayList<>();
		rentalbooklist.add(selectedBook);
		rentalbooklist.removeAll(rentalbooklist);
		
		if(rentalMain.start) {
			for(int i = 0, end = 3; i < end; i++) {
				AllBookInfo book = rentalbooklist.get(i);
				contents[i][0] = String.valueOf(book.getIsbn());
				contents[i][1] = book.getKdc();
				contents[i][2] = book.getBook_name();
				contents[i][3] = book.getAuthor();
				contents[i][4] = book.getPublisher();
				contents[i][5] = String.valueOf(book.getPublication_date() == null? "" : book.getPublication_date());
				contents[i][6] = book.getCategory_name();
				contents[i][7] = book.getLoan_state();
			}
		}
		
		return contents;
	}
		
	

}
