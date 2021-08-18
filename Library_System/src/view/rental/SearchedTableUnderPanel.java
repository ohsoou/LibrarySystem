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
		
		String[] columnNames = { "ISBN", "KDC", "������", "����", "���ǻ�", "������", "�帣", "�뿩����" };
        
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

						// ���� ������ å �ǵ�����
						SearchedTableTopPanel.addBookInBooklist(
								UserSelection.removeSelectedBook(tableUnder.getSelectedRow()));
						
						// top table ������Ʈ
						SearchedTableTopPanel.getCurrentPageButton().doClick();
						
						// under UI���� ����
						modelUnderMain.removeRow(tableUnder.getSelectedRow());

					} else {
						
					}

				}
			}

		});
        
        add(tablePane);
	}

}
