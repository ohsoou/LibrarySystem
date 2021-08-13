package view.rental;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	String[][] contents = SearchedTableTopPanel.contents;
	String[][] contentsUnder;
	AllBookInfo bookpath;
	
	
	public SearchedTableUnderPanel() {
		 setBackground(new Color(225, 238, 246));
	     setLayout(new GridLayout(2, 1));
		
		String[] columnNames = { "ISBN", "KDC", "도서명", "저자", "출판사", "출판일", "장르", "대여상태" };
		contentsUnder = SearchedTableTopPanel.checks;
        
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
        		if(e.getClickCount() == 2) {
        		
        			if(SearchedTableTopPanel.count >= 1) {
        			
        			for(int i = 0; i < SearchedTableTopPanel.bookUnderlist.size(); ++i) {
        				
        			if((SearchedTableTopPanel.bookUnderlist.get(i).getKdc()).equals( modelUnderMain.getValueAt(tableUnder.getSelectedRow(), 1)+"")) {      				
        				SearchedTableTopPanel.booklist.add(SearchedTableTopPanel.bookUnderlist.get(i));
        				SearchedTableTopPanel.bookUnderlist.remove(i);   
        			}
        		}
        			modelUnderMain.removeRow(tableUnder.getSelectedRow());

        			SearchedTableTopPanel.model = new DefaultTableModel(contents, columnNames) {
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					SearchedTableTopPanel.table.setModel(SearchedTableTopPanel.model);					
        			SearchedTableTopPanel.count --;
        			}else {
        				System.out.println("아무일도 일어나지 않았습니다.");
        			}
        		
        		}
        	}
        	
		});
        
        add(tablePane);
	}
}
