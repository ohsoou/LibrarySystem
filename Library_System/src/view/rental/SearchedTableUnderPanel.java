package view.rental;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.dto.AllBookInfo;
import view.defaultcomponent.BookListTable;
import view.defaultcomponent.DefaultPanel;


public class SearchedTableUnderPanel extends DefaultPanel{

	public static DefaultTableModel modelUnderMain;
	public static JTable tableUnder;
	public static int counts;
	public static JScrollPane tablePane;

	String[][] contentsUnder;
	
	
	public SearchedTableUnderPanel() {
		 setBackground(new Color(225, 238, 246));
	     setLayout(new GridLayout(2, 1));
		
		String[] columnNames = { "ISBN", "KDC", "도서명", "저자", "출판사", "출판일", "장르", "대여가능"  };
        
		modelUnderMain = new DefaultTableModel(contentsUnder, columnNames) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tableUnder = new JTable(modelUnderMain);
        tablePane = new BookListTable(tableUnder);
        tablePane.setPreferredSize(new Dimension(900, 135));

		tableUnder.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {

					if (UserSelection.getSelectionSize() >= 1) {

						AllBookInfo selection = UserSelection.removeSelectedBook(tableUnder.getSelectedRow());
						StoregeBook.addSelectedBook(selection);
						SearchedTableTopPanel.addBookInBooklist(selection);
						
						SearchedTableTopPanel.getCurrentPageButton().doClick();
						
						modelUnderMain.removeRow(tableUnder.getSelectedRow());

					} else {
						
					}

				}
			}
			

		});
        
        add(tablePane);
	}

}
