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
	static String[] columnNames = {"ISBN", "KDC", "������", "����", "���ǻ�", "������", "�帣", "�뿩����"};
//    static String[][] contents = {
//            {"11960503", "300,500", "�Ƴ����� �ִ� ����", "�Ǿ�", "������", "2007-03-05", "����", "N"},
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
		setFont(new Font("���� ���", Font.PLAIN, 15));

		setShowVerticalLines(false);// ���� �ٻ���

		getTableHeader().setPreferredSize(new Dimension(900, 35));
		setRowHeight(20);

		// �� ���� �ڵ� ����
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
