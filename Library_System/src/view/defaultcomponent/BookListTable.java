package view.defaultcomponent;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class BookListTable extends JScrollPane {
	public BookListTable(JTable table) {
		super(table);

		setCursor(new Cursor(Cursor.HAND_CURSOR));
		JTableHeader header = table.getTableHeader();

		header.setBackground(new Color(234, 234, 234));
		header.setForeground(new Color(0, 78, 102));

		// 폰트
		table.getTableHeader().setFont(new Font("Small Fonts", Font.BOLD, 15));
		table.setFont(new Font("돋움", Font.PLAIN, 15));

		table.setShowVerticalLines(false);// 가로 줄삭제
 
		// table 크기
		table.setFillsViewportHeight(true);

		table.getTableHeader().setPreferredSize(new Dimension(table.getWidth(), 37));
		table.setRowHeight(32);
		
		table.setDefaultRenderer(Object.class, new setSelectedRowColor());
		
		setPreferredSize(new Dimension(900, 200));

		// 셀 간격 자동 조정
		TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 15; // Min width

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
	
	class setSelectedRowColor extends DefaultTableCellRenderer {
		@Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (isSelected) {
            	c.setBackground(new Color(252, 190, 50));
            } else {
            	c.setBackground(new Color(255,255,255));
            }

            return c;
        }
	}
}
