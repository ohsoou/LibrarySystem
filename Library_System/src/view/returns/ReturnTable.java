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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import model.dao.LoanDao;
import model.dto.Loan;
import view.defaultcomponent.DefaultPanel;
import view.login.LoginHost;




public class ReturnTable extends DefaultPanel {
	
	JOptionPane option = new JOptionPane();
	private JButton returnBtn;
	int student_num;
	static String student_name;
	public ReturnTable() {
		setLayout(new GridLayout(3, 1));
			
		
		// table 
		ArrayList<Loan> dtos;
		LoanDao dao = LoanDao.getInstance();
		
		dtos = dao.listByStudentNum(LoginHost.getStudent_num());
		
		String[] columnNames = {"도서명","대여일","반납예정","남은기간","연장횟수"};
		Object[][] contents = new Object[dtos.size()][columnNames.length];
		Loan[] lo = new Loan[dtos.size()];
	  
		for(int i =0,len = dtos.size(); i < len; ++i) {
			lo[i] = dtos.get(i);
					contents[i][0] = lo[i].getBook_name();	
					contents[i][1] = lo[i].getLoan_date();
					contents[i][2] = lo[i].getDeadline();
					contents[i][3] = lo[i].getOverdue_period();
					contents[i][4] = lo[i].getExtend();
		}
		student_name = lo[0].getStudent_name();
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
		table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD|Font.PLAIN, 20));
		table.getTableHeader().setForeground(new Color(0, 78, 102));
		table.setFont(new Font("맑은 고딕",Font.PLAIN|Font.BOLD,18));
		table.setForeground(new Color(0, 78, 102));
		
		DefaultTableCellRenderer alignCenter = new DefaultTableCellRenderer();
		alignCenter.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel col = table.getColumnModel();
		
		// for문으로 수정
		for(int i=0;i<=4;++i) {
			col.getColumn(i).setCellRenderer(alignCenter);			
		}
		
		// return button
		JButton returnBtn = new ReturnBtn("반납");
		con.add(returnBtn);
		
		add(tablePane);
		add(con);
		
		// return button action
		returnBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int row = table.getSelectedRow();
				int loan_num = lo[row].getLoan_num();
				dao.updateReturnDate(loan_num);
				JOptionPane.showMessageDialog(null, "반납이 완료되었습니다");
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int selectCol = 4;
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