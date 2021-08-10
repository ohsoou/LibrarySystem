package view.rental;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import view.manager.BookListTable;

public class rentalTable extends JPanel{
	
	public rentalTable() {
		 setBackground(new Color(225, 238, 246));
	     setLayout(new GridLayout(2, 1));
		
		String[] columnNames = { "ISBN", "KDC", "도서명", "저자", "출판사", "출판일", "장르", "대여상태" };
        String[][] contents = { { "11960503", "300,500", "아낌없이 주는 나무", "권씨", "출판이", "2007-03-05", "무협", "N" },
                { "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "" }};
        
        
        DefaultTableModel model = new DefaultTableModel(contents, columnNames);
        JTable table = new JTable(model);
        JScrollPane tablePane = new rentalListTable(table);
        
        add(tablePane);
	}
		
	

}
