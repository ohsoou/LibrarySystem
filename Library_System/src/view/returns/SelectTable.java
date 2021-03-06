package view.returns;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class SelectTable extends DefaultTableCellRenderer {
	@Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (isSelected) {
        	c.setBackground(new Color(252, 190, 50));
        } else {
        	c.setBackground(new Color(255,255,255));
        }

        setHorizontalAlignment(SwingConstants.CENTER);
        return c;
    }
}

 
 