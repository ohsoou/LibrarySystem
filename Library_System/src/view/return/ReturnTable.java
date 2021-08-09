package view.returns;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 

public class ReturnTable extends JPanel {
	
	private JButton returnBtn;
	
	public ReturnTable() {
		setBackground(new Color(225, 238, 246));
		setLayout(new GridLayout(2, 1));
			
		
		// table 
		String[] cloumnNames = {"No", "µµ¼­¸í","¿¬Ã¼¿©ºÎ","´ë¿©ÀÏ","¹Ý³³ÀÏ","¿¬ÀåÈ½¼ö"};
		String[][] contents = {
				{"1","¾Æ³¦¾øÀÌ ÁÖ´Â ³ª¹«", "x","21/00/00","21/00/00","1"},
				{"2","Smith", "x","21/00/00","21/00/00","1"},
				{ "", "", "", "", "", "" },	{ "", "", "", "", "", "" },
				{ "", "", "", "", "", "" }
				
		};
		
		DefaultTableModel model = new DefaultTableModel(contents, cloumnNames);
		JTable table = new JTable(model);
		JScrollPane tablePane = new JScrollPane(table);
		
		//table size
		table.setSize(700,240);
		tablePane.setPreferredSize(new Dimension(700,240));
		
		Container con = new Container();
		con.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));
		
		// table layout
		table.getTableHeader().setPreferredSize(new Dimension(
				tablePane.getWidth(),40
				));
		table.setRowHeight(40);
		table.getTableHeader().setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 20));
		table.setFont(new Font("¸¼Àº°íµñ",Font.PLAIN,18));
		  
		// return button
		JButton returnBtn = new ReturnBtn("¹Ý³³");
		con.add(returnBtn);
		
		add(tablePane);
		add(con);
	}	
	
	private class returnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO: ¹Ý³³ ¼±ÅÃ ÀÌº¥Æ® Ã³¸®
			
		}
	}
}
