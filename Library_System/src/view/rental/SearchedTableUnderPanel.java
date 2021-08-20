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
		
		String[] columnNames = { "ISBN", "KDC", "µµ¼­¸í", "ÀúÀÚ", "ÃâÆÇ»ç", "ÃâÆÇÀÏ", "Àå¸£", "´ë¿©»óÅÂ"  };
        
		modelUnderMain = new DefaultTableModel(contentsUnder, columnNames) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tableUnder = new JTable(modelUnderMain);
        tablePane = new RentalUnderPane(tableUnder);

		tableUnder.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {

					if (UserSelection.getSelectionSize() >= 1) {

						// ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ Ã¥ ï¿½Çµï¿½ï¿½ï¿½ï¿½ï¿½
						AllBookInfo selection = UserSelection.removeSelectedBook(tableUnder.getSelectedRow());
						StoregeBook.addSelectedBook(selection);
						SearchedTableTopPanel.addBookInBooklist(selection);
						
						// top table ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Æ®
						SearchedTableTopPanel.getCurrentPageButton().doClick();
						
						// under UIï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
						modelUnderMain.removeRow(tableUnder.getSelectedRow());

					} else {
						
					}

				}
			}
			

		});
        
        add(tablePane);
	}

}
