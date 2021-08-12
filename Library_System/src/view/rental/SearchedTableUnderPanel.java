package view.rental;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.Arrays;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.dto.AllBookInfo;
import view.component.DefaultPanel;


public class SearchedTableUnderPanel extends DefaultPanel{

	public static DefaultTableModel modelUnderMain;
	public static JTable tableUnder;
	public static int counts;
	public static JScrollPane tablePane;
	public static DefaultTableModel modelUnder;
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
        			System.out.println("언더 패널 값 : "+modelUnderMain.getDataVector());
        			
        			// 확인용 sysout
        			System.out.println(SearchedTableTopPanel.bookUnderlist.get(0).getKdc()+"" == modelUnderMain.getValueAt(tableUnder.getSelectedRow(), 1)+"");
        			System.out.println(SearchedTableTopPanel.bookUnderlist.get(1).getKdc()+"" == modelUnderMain.getValueAt(tableUnder.getSelectedRow(), 1)+"");
        			System.out.println(SearchedTableTopPanel.bookUnderlist.get(2).getKdc()+"" == modelUnderMain.getValueAt(tableUnder.getSelectedRow(), 1)+"");
        			for(int i = 0; i < SearchedTableTopPanel.bookUnderlist.size(); ++i) {
        			if(SearchedTableTopPanel.bookUnderlist.get(i).getKdc() == modelUnderMain.getValueAt(tableUnder.getSelectedRow(), 1)+"") {
        				
        				SearchedTableTopPanel.booklist.add(SearchedTableTopPanel.bookUnderlist.get(i));
        				System.out.println("이프문 발생체크");
        			}
        		}
        			modelUnderMain.removeRow(tableUnder.getSelectedRow());

        			SearchedTableTopPanel.model = new DefaultTableModel(contents, columnNames) {	
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					};
					//  체크스를 받으면 안됨!
					SearchedTableTopPanel.model = new DefaultTableModel(contents, columnNames);
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
