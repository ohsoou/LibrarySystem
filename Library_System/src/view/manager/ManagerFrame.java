package view.manager;


import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.dao.AllBookInfoDao;
import model.dto.AllBookInfo;
import view.defaultcomponent.BookListPagingButton;
import view.defaultcomponent.BookListTable;
import view.defaultcomponent.DefaultBookCategoryDropDown;
import view.defaultcomponent.DefaultBookSearchBar;
import view.defaultcomponent.DefaultButton;
import view.defaultcomponent.DefaultFrame;
import view.defaultcomponent.NextPrevTablePagingButton;


public class ManagerFrame extends DefaultFrame{
	
	private JPanel titlePane;
	private Container searchPane;
	private Container tablePane;
	
	// table pane components
	private int startPage = 1;
	private JButton prevPageButton;
	private JButton nextPageButton;
	
	private ButtonGroup buttonGroup;
	private JToggleButton firstPageButton;
	private JToggleButton secondPageButton;
	private JToggleButton thirdPageButton;
	private JToggleButton fourthPageButton;
	public JToggleButton currentPageButton;
	
	private int startIndexOnPage = 0;
	private ArrayList<AllBookInfo> booklist;
	private AllBookInfoDao bookinfodao;
	private AllBookInfo selectedBook;

	
	private DefaultTableModel model;
	private JTable table;
	
	// search pane components
	private JTextField searchBar;
	private JComboBox bookCategory;
	private JButton searchButton;
	
	public ManagerFrame() {
		super();

		setComp();
		setDesign();
		setFrame();
	
	}
	
	@Override
	public void setComp() {
		titlePane = new TitlePanel();
		tablePane = setTablePane();
		searchPane = setSearchPane();
		
	}
	@Override
	public void setDesign() {
		setLayout(new FlowLayout());
		
		add(titlePane);
		add(searchPane);
		add(tablePane);
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
	
	private Container setTablePane() {
		Container con = new Container();
		con.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);

        // create table
        JScrollPane tablePane = addTable();
  
        
		// create paging button
		Container buttons = addPagingButtons();
		
		
		constraints.gridy = 1; 
		con.add(tablePane, constraints);
		constraints.gridy = 2; 
		con.add(buttons, constraints);
		
		return con;
	}
	
	@SuppressWarnings("serial")
	private JScrollPane addTable() {
		String[] columnNames = { "BookID", "ISBN", "KDC", "도서명", "저자", "출판사", "출판일", "장르", "대여가능" };
		String[][] contents = new String[5][9];
		contents = initTableBookList(contents);

		model = new DefaultTableModel(contents, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		this.table = new JTable(model);
		this.table.getSelectionModel().addListSelectionListener(new selectTableRowListener());
		JScrollPane tablePane = new BookListTable(table);
		
		return tablePane;
	}
	
	private Container addPagingButtons() {
		Container con = new Container();
		con.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		buttonGroup = new ButtonGroup();
		prevPageButton = new NextPrevTablePagingButton("<");
		firstPageButton = new BookListPagingButton("1");
		secondPageButton = new BookListPagingButton("2");
		thirdPageButton = new BookListPagingButton("3");
		fourthPageButton = new BookListPagingButton("4");
		nextPageButton = new NextPrevTablePagingButton(">");
		
		firstPageButton.addActionListener(new selectPagingNumberButtonListener());
		secondPageButton.addActionListener(new selectPagingNumberButtonListener());
		thirdPageButton.addActionListener(new selectPagingNumberButtonListener());
		fourthPageButton.addActionListener(new selectPagingNumberButtonListener());
		
		prevPageButton.addActionListener(new selectPrevPageButtonListener());
		nextPageButton.addActionListener(new selectNextPageButtonListener());
		
		buttonGroup.add(firstPageButton);
		buttonGroup.add(secondPageButton);
		buttonGroup.add(thirdPageButton);
		buttonGroup.add(fourthPageButton);
		buttonGroup.setSelected(firstPageButton.getModel(), true);
		currentPageButton = firstPageButton;
		
		con.add(prevPageButton);
		con.add(firstPageButton);
		con.add(secondPageButton);
		con.add(thirdPageButton);
		con.add(fourthPageButton);
		con.add(nextPageButton);
		
		return con;
	}
	
	
	private String[][] initTableBookList(String[][] contents) {
		bookinfodao = AllBookInfoDao.getInstance();
		booklist = bookinfodao.listAll_AllBookinfo();
		initBookListWithSelectedBook();
		
		for(int i = 0, end = 5; i < end; i++) {
			AllBookInfo book = booklist.get(i);
			contents[i][0] = String.valueOf(book.getBook_id());
			contents[i][1] = String.valueOf(book.getIsbn());
			contents[i][2] = book.getKdc();
			contents[i][3] = book.getBook_name();
			contents[i][4] = book.getAuthor();
			contents[i][5] = book.getPublisher();
			contents[i][6] = String.valueOf(book.getPublication_date() == null? "" : book.getPublication_date());
			contents[i][7] = book.getCategory_name();
			contents[i][8] = book.getLoan_state();
		}
		return contents;
	}

	private void initBookListWithSelectedBook() {
		BookListWithSelectedBook.setFilter(0);
		BookListWithSelectedBook.setSearchedText("");
		BookListWithSelectedBook.setBooklist(booklist);
		BookListWithSelectedBook.setSelectedBook(null);
	}

	//Action
	private class searchListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<AllBookInfo> booklist = BookListWithSelectedBook.getBooklist();
			booklist.clear();
			BookListWithSelectedBook.setBooklist(booklist);

			int category = bookCategory.getSelectedIndex();
			String text = ((DefaultBookSearchBar) searchBar).LetterAndTrimText();
			
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
			BookListWithSelectedBook.setFilter(category);
			BookListWithSelectedBook.setSearchedText(text);
			BookListWithSelectedBook.setBooklist(booklist);
			firstPageButton.doClick();
			BookListWithSelectedBook.setSelectedBook(null);
		}
		
	}
	
	// table Action
	private class selectTableRowListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
				selectedBook = booklist.get(startIndexOnPage + table.getSelectedRow());
				BookListWithSelectedBook.setSelectedBook(selectedBook);
			}
		}
	}
	
	private class selectPagingNumberButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JToggleButton btn = (JToggleButton)e.getSource();
			currentPageButton = btn;
			startIndexOnPage = (Integer.parseInt(btn.getText()) -1) * 5;

			RemoveTableOnPage();
			RefreshTableOnPage();

		}
		
		private void RemoveTableOnPage() {
			for( int i = model.getRowCount() - 1; i >= 0; i-- )
			{
			    model.removeRow(i);
			}
		}
		
		private void RefreshTableOnPage() {
			booklist = BookListWithSelectedBook.getBooklist();
			int end = (booklist.size() - startIndexOnPage) < 5? booklist.size() : startIndexOnPage + 5;

			for(int i = startIndexOnPage; i < end; i++) {
				AllBookInfo book = booklist.get(i);
				String[] row = new String[9];
				
				row[0] = String.valueOf(book.getBook_id());
				row[1] = String.valueOf(book.getIsbn());
				row[2] = book.getKdc();
				row[3] = book.getBook_name();
				row[4] = book.getAuthor();
				row[5] = book.getPublisher();
				row[6] = String.valueOf(book.getPublication_date() == null? "" : book.getPublication_date());
				row[7] = book.getCategory_name();
				row[8] = book.getLoan_state();
				
				model.addRow(row);
			}
		}
	}
	
	private class selectPrevPageButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(firstPageButton.isSelected()) {
				if(startPage != 1) {
					startPage -= 4;
					firstPageButton.setText(""+startPage);
					secondPageButton.setText(""+(startPage+1));
					thirdPageButton.setText(""+(startPage+2));
					fourthPageButton.setText(""+(startPage+3));
					fourthPageButton.doClick();
				}
			} else if (secondPageButton.isSelected()) {
				firstPageButton.doClick();
			} else if (thirdPageButton.isSelected()) {
				secondPageButton.doClick();
			} else if (fourthPageButton.isSelected()) {
				thirdPageButton.doClick();
			}
		}
	}
	
	private class selectNextPageButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(firstPageButton.isSelected()) {
				secondPageButton.doClick();
			} else if (secondPageButton.isSelected()) {
				thirdPageButton.doClick();
			} else if (thirdPageButton.isSelected()) {
				fourthPageButton.doClick();
			} else if (fourthPageButton.isSelected()) {
				int listSize = booklist.size() % 5 != 0? (booklist.size()/5) + 1: booklist.size()/5;
				if(startPage + 4 < listSize) {
					startPage += 4;
					firstPageButton.setText(""+startPage);
					secondPageButton.setText(""+(startPage+1));
					thirdPageButton.setText(""+(startPage+2));
					fourthPageButton.setText(""+(startPage+3));
					firstPageButton.doClick();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				ManagerFrame frame = new ManagerFrame();
				frame.setVisible(true);
			}
		});
	}
	

}
