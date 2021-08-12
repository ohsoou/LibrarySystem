package view.rental;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import model.dao.AllBookInfoDao;
import model.dto.AllBookInfo;
import view.component.DefaultBookCategoryDropDown;
import view.component.DefaultBookSearchBar;
import view.component.DefaultButton;
import view.component.DefaultPanel;
import view.manager.BookListPagingButton;
import view.manager.BookListTable;



public class SearchedTableTopPanel extends DefaultPanel{
	private int startPage = 1;
	private JButton prevPageButton;
	private JButton nextPageButton;

	public static int count;
	private ButtonGroup buttonGroup;
	private JToggleButton firstPageButton;
	private JToggleButton secondPageButton;
	private JToggleButton thirdPageButton;
	private JToggleButton fourthPageButton;

	private static int startIndex = 0;
	public static ArrayList<AllBookInfo> booklist;
	public static ArrayList<AllBookInfo> bookUnderlist = new ArrayList<>();
	private static AllBookInfoDao bookinfodao;
	public static AllBookInfo selectedBook;
	public static  DefaultTableModel model;
	public static JTable table;
	private JTextField searchBar;
	private JComboBox bookCategory;
	public static String[][] checks = new String[3][8]; 
	private String[] columnNames = { "ISBN", "KDC", "도서명", "저자", "출판사", "출판일", "장르", "대여상태" };
	public static String[][] contents;

	public SearchedTableTopPanel() {
		setBackground(new Color(225, 238, 246));
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.insets = new Insets(7, 7, 7, 7);


		// create table
		contents = new String[5][8];
		contents = initTableBookList(contents);

		model = new DefaultTableModel(contents, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table = new JTable(model);
		JScrollPane tablePane = new rentalTopPane(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					if((boolean) model.getValueAt(table.getSelectedRow(), 7).equals("N") || count == 3) {
						if(count == 3) {
							JOptionPane.showMessageDialog(table, "더 이상 선택할 수 없습니다.", "선택 불가", JOptionPane.WARNING_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(table, "대여 불가능 상태 입니다.", "선택 불가", JOptionPane.WARNING_MESSAGE);
						}

					}else {				
						System.out.println("탑 패널 : "+model.getDataVector());
						for(int i = 0; i < 8; ++i) {			
							checks[count][i] = (String) model.getValueAt(table.getSelectedRow(), i);					
						}

						for(int i = 0; i < booklist.size(); ++i) {
							if((booklist.get(i).getIsbn()+"").equals(checks[count][0])) {
								bookUnderlist.add(booklist.get(i));
								booklist.remove(i);
							}
						}			
						model.removeRow(table.getSelectedRow());
						SearchedTableUnderPanel.modelUnderMain = new DefaultTableModel(checks, columnNames) {
							public boolean isCellEditable(int row, int column) {
								return false;
							}
						};
						//selectPagingNumberButtonListener.insertNewAllRows();
						SearchedTableUnderPanel.modelUnder = new DefaultTableModel(checks, columnNames);
						SearchedTableUnderPanel.tableUnder.setModel(SearchedTableUnderPanel.modelUnderMain);
						count++;
					}	
				}		
			}
		});



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


		constraints.gridy = 1; 
		add(tablePane, constraints);
		constraints.gridy = 2; 
		add(con, constraints);
	}

	// ManagerPanel Action줄 때 씀
	public int getStartIndex() {
		return startIndex;
	}

	public ArrayList<AllBookInfo> getBooklist() {
		return booklist;
	}
	public void setBooklist(ArrayList<AllBookInfo> booklist) {
		this.booklist = booklist;
	}

	public JTable getTable() {
		return table;
	}
	public JToggleButton getFirstPageButton() {
		return firstPageButton;
	}

	public static String[][] initTableBookList(String[][] contents) {
		bookinfodao = AllBookInfoDao.getInstance();
		booklist = bookinfodao.listAll_AllBookinfo();
		// 북리스트에 겟 ?의 isbn과 같을때에 리스트를 하나더 만드러 거기에 모든 정보를 넣어둔다?
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
		prevPageButton = new nextPrevPagingButton("<");
		firstPageButton = new BookListPagingButton("1");
		secondPageButton = new BookListPagingButton("2");
		thirdPageButton = new BookListPagingButton("3");
		fourthPageButton = new BookListPagingButton("4");
		nextPageButton = new nextPrevPagingButton(">");

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

		private static void insertNewAllRows() {
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

	// <> button
	private class nextPrevPagingButton extends JButton {
		public nextPrevPagingButton(String text) {
			super(text);

			setPreferredSize(new Dimension(45, 30));
			setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			setBorderPainted(false); 

			setUI(new MetalToggleButtonUI() {
				@Override
				protected Color getSelectColor() {
					return new Color(255, 95, 46);
				}

			});
		}

		public void paintComponent(Graphics g) {
			Color bg, txt;
			if(getModel().isPressed()) {
				bg = new Color(255, 95, 46);
				txt = new Color(255, 255, 255);
			} else {
				bg = new Color(255, 240, 240);
				txt = new Color(96, 96, 96);
			}
			setBackground(bg);
			setForeground(txt);
			super.paintComponent(g);
		}
	}
}
