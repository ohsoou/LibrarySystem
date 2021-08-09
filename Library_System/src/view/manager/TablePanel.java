package view.manager;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;



public class TablePanel extends JPanel {
	private int startPage = 1;
	private JButton prevPageButton;
	private JButton nextPageButton;
	
	private ButtonGroup buttonGroup;
	private JToggleButton firstPageButton;
	private JToggleButton secondPageButton;
	private JToggleButton thirdPageButton;
	private JToggleButton fourthPageButton;

	public TablePanel() {
		setBackground(new Color(225, 238, 246));
		setLayout(new GridLayout(2, 1));


		// create table
		String[] columnNames = { "ISBN", "KDC", "������", "����", "���ǻ�", "������", "�帣", "�뿩����" };
		String[][] contents = { { "11960503", "300,500", "�Ƴ����� �ִ� ����", "�Ǿ�", "������", "2007-03-05", "����", "N" },
				{ "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "" }, };
		DefaultTableModel model = new DefaultTableModel(contents, columnNames);
		JTable table = new JTable(model);
		JScrollPane tablePane = new BookListTable(table);
		
		// create paging button
		Container con = new Container();
		con.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		buttonGroup = new ButtonGroup();
		prevPageButton = new OnePagingButton("<");
		firstPageButton = new BookListPagingButton("1");
		secondPageButton = new BookListPagingButton("2");
		thirdPageButton = new BookListPagingButton("3");
		fourthPageButton = new BookListPagingButton("4");
		nextPageButton = new OnePagingButton(">");
		
		buttonGroup.add(firstPageButton);
		buttonGroup.add(secondPageButton);
		buttonGroup.add(thirdPageButton);
		buttonGroup.add(fourthPageButton);
		
		con.add(prevPageButton);
		con.add(firstPageButton);
		con.add(secondPageButton);
		con.add(thirdPageButton);
		con.add(fourthPageButton);
		con.add(nextPageButton);
		
		add(tablePane);
		add(con);

	}
	
	class OnePagingButton extends JButton {
		public OnePagingButton(String text) {
			super(text);
			
			setPreferredSize(new Dimension(45, 25));
			setBackground(new Color(255, 95, 46)); 
			setForeground(new Color(255, 255, 255));
			setFont(new Font("���� ���", Font.PLAIN, 14));
			setBorderPainted(false); 
		}
		
	}

}
