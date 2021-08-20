package view.rental;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

import model.dao.AllBookInfoDao;
import model.dto.AllBookInfo;
import view.defaultcomponent.BookListPagingButton;
import view.defaultcomponent.BookListTable;
import view.defaultcomponent.DefaultPanel;
import view.defaultcomponent.NextPrevTablePagingButton;



public class SearchedTableTopPanel extends DefaultPanel{
	private int startPage = 1;
	private JButton prevPageButton;
	private JButton nextPageButton;

	private ButtonGroup buttonGroup;
	private JToggleButton firstPageButton;
	private JToggleButton secondPageButton;
	private JToggleButton thirdPageButton;
	private JToggleButton fourthPageButton;

	private static int startIndex = 0;
	private static AllBookInfoDao bookinfodao;
	
	public static ArrayList<AllBookInfo> booklist;
	private static  DefaultTableModel model;
	public static JTable table;
	public static JToggleButton currentPage;
	
	@SuppressWarnings("serial")
	public SearchedTableTopPanel() {
		setBackground(new Color(225, 238, 246));
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.insets = new Insets(7, 7, 7, 7);
		
		


		// create table
		String[] columnNames = { "ISBN", "KDC", "도서명", "저자", "출판사", "출판일", "장르", "대여상태"  };
		String[][] contents = new String[5][8];
		contents = initTableBookList(contents);

		model = new DefaultTableModel(contents, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table = new JTable(model);
		JScrollPane tablePane = new BookListTable(table);
		
		// create paging button
		Container con = new Container();
		con.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		initPagingButtons();

		con.add(prevPageButton);
		con.add(firstPageButton);
		con.add(secondPageButton);
		con.add(thirdPageButton);
		con.add(fourthPageButton);
		con.add(nextPageButton);
		
		currentPage = firstPageButton;
		
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					int count = UserSelection.getSelectionSize();
					if((boolean) model.getValueAt(table.getSelectedRow(), 7).equals("N") || count == 3) {
						if(count == 3) {

							JOptionPane.showMessageDialog(table,"더 이상 선택할 수 없습니다.", "선택 불가", JOptionPane.WARNING_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(table, "대여 불가능 상태 입니다.", "선택 불가", JOptionPane.WARNING_MESSAGE);
						}

					}else {				

						
						AllBookInfo selection = booklist.remove(startIndex + table.getSelectedRow());
						UserSelection.addSelectedBook(selection);
						StoregeBook.storegeBooks.remove(selection);
						
						currentPage.doClick();

						String[] row = new String[8];

						row[0] = String.valueOf(selection.getIsbn());
						row[1] = selection.getKdc();
						row[2] = selection.getBook_name();
						row[3] = selection.getAuthor();
						row[4] = selection.getPublisher();
						row[5] = String.valueOf(selection.getPublication_date() == null? "" : selection.getPublication_date());
						row[6] = selection.getCategory_name();
						row[7] = selection.getLoan_state();
						
						
						SearchedTableUnderPanel.modelUnderMain.addRow(row);
						new RentalTableSize(SearchedTableUnderPanel.tableUnder);
						
					}	
				}		
			}
		});

		constraints.gridy = 1; 
		add(tablePane, constraints);
		constraints.gridy = 2; 
		add(con, constraints);
	}

	public int getStartIndex() {
		return startIndex;
	}

	public static ArrayList<AllBookInfo> getBooklist() {
		return booklist;
	}
	public static void setBooklist(ArrayList<AllBookInfo> booklist) {
		SearchedTableTopPanel.booklist = booklist;
	}
	public static void addBookInBooklist(AllBookInfo book) {
		booklist.add(book);
	}
	public JTable getTable() {
		return table;
	}
	public JToggleButton getFirstPageButton() {
		return firstPageButton;
	}

	public static JToggleButton getCurrentPageButton() {
		return currentPage;
	}
	public String[][] initTableBookList(String[][] contents) {
		bookinfodao = AllBookInfoDao.getInstance();
		booklist = bookinfodao.listAll_AllBookinfo();
		for(int i = 0, end = 5; i < end; i++) {
			AllBookInfo book = booklist.get(i);
			contents[i][0] = String.valueOf(book.getIsbn());
			contents[i][1] = book.getKdc();
			contents[i][2] = book.getBook_name();
			contents[i][3] = book.getAuthor();
			contents[i][4] = book.getPublisher();
			contents[i][5] = String.valueOf(book.getPublication_date() == null? "" : book.getPublication_date());
			contents[i][6] = book.getCategory_name();
			contents[i][7] = book.getLoan_state();
		}
		return contents;
	}


	private void initPagingButtons() {
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
	}

	private class selectPagingNumberButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JToggleButton btn = (JToggleButton)e.getSource();
			currentPage = btn;
			startIndex = (Integer.parseInt(btn.getText()) -1) * 5;

			removeAllRows();
			insertNewAllRows();

		}

		private void removeAllRows() {
			for( int i = model.getRowCount() - 1; i >= 0; i-- )
			{
				model.removeRow(i);
			}
		}

		private void insertNewAllRows() {
			int end = (booklist.size() - startIndex) < 5? booklist.size() : startIndex + 5;

			for(int i = startIndex; i < end; i++) {
				AllBookInfo book = booklist.get(i);
				String[] row = new String[8];

				row[0] = String.valueOf(book.getIsbn());
				row[1] = book.getKdc();
				row[2] = book.getBook_name();
				row[3] = book.getAuthor();
				row[4] = book.getPublisher();
				row[5] = String.valueOf(book.getPublication_date() == null? "" : book.getPublication_date());
				row[6] = book.getCategory_name();
				row[7] = book.getLoan_state();

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
}
