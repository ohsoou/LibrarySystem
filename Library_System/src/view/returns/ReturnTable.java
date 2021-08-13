package view.returns;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import model.dao.LoanDao;
import model.dto.Loan;




public class ReturnTable extends JPanel {
	
	JOptionPane option = new JOptionPane();
	private JButton returnBtn;
	int student_num;
	
	public ReturnTable() {
		setBackground(new Color(225, 238, 246));
		setLayout(new GridLayout(2, 1));
			
		
		// table 
		ArrayList<Loan> dtos;
		LoanDao dao = LoanDao.getInstance();
		
		dtos = dao.listByStudentNum("201613245");
		
		String[] columnNames = {"´ëÃâ¹øÈ£", "ÇÐ¹ø","µµ¼­¸í","´ë¿©ÀÏ","¹Ý³³ÀÏ","¿¬ÀåÈ½¼ö"};
		Object[][] contents = new Object[dtos.size()][columnNames.length];
		Loan[] lo = new Loan[dtos.size()];
		System.out.println(dtos.size());
		System.out.println(contents.length);

		for(int i =0,len = dtos.size(); i < len; ++i) {
			lo[i] = dtos.get(i);
					contents[i][0] = lo[i].getLoan_num();	
					contents[i][1] = lo[i].getStudent_num();
					contents[i][2] = lo[i].getBook_name();
					contents[i][3] = lo[i].getLoan_date();
					contents[i][4] = lo[i].getReturn_date();
					contents[i][5] = lo[i].getExtend();
		}
		
		DefaultTableModel model = new DefaultTableModel(contents,columnNames);
		
		JTable table = new JTable(model) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
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
		table.getTableHeader().setFont(new Font("¸¼Àº °íµñ", Font.BOLD|Font.PLAIN, 20));
		table.getTableHeader().setForeground(new Color(0, 78, 102));
		table.setFont(new Font("¸¼Àº °íµñ",Font.PLAIN|Font.BOLD,18));
		table.setForeground(new Color(0, 78, 102));
		
		// contents align center
		DefaultTableCellRenderer alignCenter = new DefaultTableCellRenderer();
		alignCenter.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel col = table.getColumnModel();
		
		col.getColumn(0).setCellRenderer(alignCenter);
		col.getColumn(3).setCellRenderer(alignCenter);
		col.getColumn(4).setCellRenderer(alignCenter);
		
		// contents align right
		DefaultTableCellRenderer alignRight = new DefaultTableCellRenderer();
		alignRight.setHorizontalAlignment(SwingConstants.RIGHT);
		
		col.getColumn(1).setCellRenderer(alignRight);
		col.getColumn(2).setCellRenderer(alignRight);
		col.getColumn(5).setCellRenderer(alignRight);
		
		// return button
		JButton returnBtn = new ReturnBtn("¹Ý³³");
		con.add(returnBtn);
		
		add(tablePane);
		add(con);
		
		// return button action
		returnBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int row = table.getSelectedRow();
				int loan_num = (int) table.getValueAt(row, 0);
				dao.updateReturnDate(loan_num);
				JOptionPane.showMessageDialog(null, "¹Ý³³ÀÌ ¿Ï·áµÇ¾ú½À´Ï´Ù");
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int selectCol = 5;
				int selectrow = table.getSelectedRow();
				  
				for(int j = 0; j <= selectCol; j++ ) {
					System.out.println(table.getValueAt(selectrow, j));
				}
				SelectTable selectTable = new SelectTable();
				table.setDefaultRenderer(Object.class, selectTable);
			}
		});
	}
}