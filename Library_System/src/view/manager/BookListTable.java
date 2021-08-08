package view.manager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class BookListTable extends JTable{
	static String[] columnNames = {"ISBN", "KDC", "도서명", "저자", "출판사", "출판일", "장르", "대여상태"};
//    static String[][] contents = {
//            {"11960503", "300,500", "아낌없이 주는 나무", "권씨", "출판이", "2007-03-05", "무협", "N"},
//            {"", "", "", "","","","",""},
//            {"", "", "", "","","","",""},
//            {"", "", "", "","","","",""},
//            {"", "", "", "","","","",""},
//            {"", "", "", "","","","",""},
//            {"", "", "", "","","","",""},
//    };
	public BookListTable(String[][] contents) {
		super(contents, columnNames);

		JTableHeader header = getTableHeader();
		setBackground(new Color(234, 234, 234));
		setForeground(new Color(0, 78, 102));

		getTableHeader().setFont(new Font("Small Fonts", Font.BOLD, 15));
		setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		setShowVerticalLines(false);// 가로 줄삭제

		getTableHeader().setPreferredSize(new Dimension(900, 35));
		setRowHeight(20);

		// 셀 간격 자동 조정
		TableColumnModel columnModel = getColumnModel();
		for (int column = 0, maxCol = getColumnCount(); column < maxCol; column++) {
			int width = 15; // Min width

			for (int row = 0, maxRow = getRowCount(); row < maxRow; row++) {
				TableCellRenderer renderer = getCellRenderer(row, column);
				Component comp = prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 1, width);
			}
			if (width > 200) {
				width = 200;
				columnModel.getColumn(column).setPreferredWidth(width);
			}
		}
	}
}
