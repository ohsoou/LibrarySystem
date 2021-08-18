package view.rental;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class rentalTableSize extends JTable{
	
	JTable table;
	public rentalTableSize(JTable table) {
		this.table = table;
		
		 JTableHeader header = table.getTableHeader();

	        header.setBackground(new Color(234, 234, 234));
	        header.setForeground(new Color(0, 78, 102));

	    
	        table.getTableHeader().setFont(new Font("Small Fonts", Font.BOLD, 15));
	        table.setFont(new Font("µ¸¿ò", Font.PLAIN, 15));

	        table.setShowVerticalLines(false);
	 
	  
	        
	        table.setFillsViewportHeight(true);

	        table.getTableHeader().setPreferredSize(new Dimension(table.getWidth(), 37));
	        table.setRowHeight(32);
	        
	     
	        TableColumnModel columnModel = table.getColumnModel();
	        for (int column = 0; column < table.getColumnCount(); column++) {
	            int width = 15; // Min width 15

	            for (int row = 0; row < table.getRowCount(); row++) {
	                TableCellRenderer renderer = table.getCellRenderer(row, column);
	                Component comp = table.prepareRenderer(renderer, row, column);
	                width = Math.max(comp.getPreferredSize().width + 1, width);
	            }
	            if (width > 200)
	                width = 200;
	            columnModel.getColumn(column).setPreferredWidth(width);
	        }
		
	}
}
