package view.rental;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.dto.AllBookInfo;
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
		
		String[] columnNames = { "ISBN", "KDC", "도서명", "저자", "출판사", "출판일", "장르", "대여상태" };
        
		modelUnderMain = new DefaultTableModel(contentsUnder, columnNames) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tableUnder = new JTable(modelUnderMain);
        tablePane = new rentalUnderPane(tableUnder);

		tableUnder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {

					if (UserSelection.getSelectionSize() >= 1) {

						// 선택 해제한 책 되돌리기
						SearchedTableTopPanel.addBookInBooklist(
								UserSelection.removeSelectedBook(tableUnder.getSelectedRow()));
						
						// top table 업데이트
						SearchedTableTopPanel.getCurrentPageButton().doClick();
						
						// under UI에서 삭제
						modelUnderMain.removeRow(tableUnder.getSelectedRow());

					} else {
						
					}

				}
			}

		});
        
        add(tablePane);
	}

}
