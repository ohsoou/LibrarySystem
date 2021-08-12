package view.returns;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class SelectTable extends DefaultTableCellRenderer {
	public Component getTableCellRendererComponent
	(JTable table, Object value, boolean isSelecte, boolean hasFocus, 
			int row, int column) {
		Component com = super.getTableCellRendererComponent
				(table, value, isSelecte, hasFocus, row, column);
		// select cell color change
			if(!isSelecte) {
				com.setBackground(null);
			}else{
				com.setBackground(new Color(252, 190, 50));			
			}
		
		return com;
	}
}
 
 