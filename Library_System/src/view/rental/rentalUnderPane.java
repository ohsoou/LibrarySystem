package view.rental;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class rentalUnderPane extends JScrollPane{
   
	public rentalUnderPane(JTable table) {
        super(table);
        
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

        // table cell 수정 불가
        table.setEnabled(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setPreferredSize(new Dimension(100,20));
        setPreferredSize(new Dimension(900, 135)); // 900 135
        
        // 셀 간격 자동 조정
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







