package view.manager;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TablePanel extends JPanel {

	public TablePanel() {
		setBackground(new Color(225, 238, 246));

		// create table
		String[] columnNames = { "LSBN", "KDC", "������", "����", "���ǻ�", "������", "�帣", "�뿩����" };
		String[][] contents = { { "11960503", "300,500", "�Ƴ����� �ִ� ����", "�Ǿ�", "������", "2007-03-05", "����", "N" },
				{ "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "" }, };
		DefaultTableModel model = new DefaultTableModel(contents, columnNames);
		JTable table = new JTable(model);
		JScrollPane tablePane = new BookListTable(table);

		add(tablePane);

	}

}
