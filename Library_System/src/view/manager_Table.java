package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class manager_Table extends DefaultFrame {
	private JPanel contentPane;
  
	public manager_Table() {			
		// 크기			
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(225, 238, 246));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		// 표                     
        String[] columnNames = {"LSBN", "KDC", "도서명", "저자", "출판사", "출판일", "장르", "대여상태"};
        String[][] contents = {
                {"11960503", "300,500", "아낌없이 주는 나무", "권씨", "출판이", "2007-03-05", "무협", "N"},
                {"", "", "", "","","","",""},
                {"", "", "", "","","","",""},
                {"", "", "", "","","","",""},
                {"", "", "", "","","","",""},
                {"", "", "", "","","","",""},
                {"", "", "", "","","","",""},
        };

        JTable table = new JTable(contents, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        JTableHeader header = table.getTableHeader();
        
        // 컬러
        header.setBackground(new Color(234, 234, 234));
        header.setForeground(new Color(0, 78, 102));
     
        // 폰트
        table.getTableHeader().setFont(new Font("Small Fonts", Font.BOLD, 15));
        table.setFont(new Font("돋움", Font.PLAIN, 15));
        
        // table 크기
		table.getTableHeader().setPreferredSize(new Dimension(
				scrollPane.getWidth(), 35
		));
        table.setRowHeight(20);   
        scrollPane.setLocation(30,215);
        scrollPane.setSize(900,178);
        
        //table.setShowHorizontalLines(false); 세로 줄삭제
        table.setShowVerticalLines(false);// 가로 줄삭제
        
        contentPane.add(scrollPane);
        contentPane.setVisible(true);

        // 정렬
        DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
        tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel tcmSchedule = table.getColumnModel();
        for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
        tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
        
        //셀 간격 자동 조정
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 200)
                width=200;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
        
   }

}


}
