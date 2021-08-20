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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import model.dao.LoanDao;
import model.dto.Loan;
import view.defaultcomponent.BookListTable;
import view.defaultcomponent.DefaultPanel;
import view.login.LoginHost;
import view.main.MainFrame;


public class ReturnTable extends DefaultPanel {
	
	JOptionPane option = new JOptionPane();
	private JButton returnBtn;
	int student_num;
	static String student_name;
	
	public ReturnTable() {
		setLayout(new GridLayout(2, 1));
			
		
		// table 
		ArrayList<Loan> dtos;
		LoanDao dao = LoanDao.getInstance();
		
		dtos = dao.listByStudentNum(LoginHost.getStudent_num());
		
		String[] columnNames = {"������","�뿩��","�ݳ�����","�����Ⱓ","����Ƚ��"};
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

		
		@SuppressWarnings("serial")
		DefaultTableModel model = new DefaultTableModel(contents, columnNames) {

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		JTable table = new JTable(model);

		JScrollPane tablePane = new BookListTable(table);
 
		//table size
		table.setSize(700,240);
		tablePane.setPreferredSize(new Dimension(700,240));
		
		table.setDefaultRenderer(Object.class, new SelectTable());
		
		Container con = new Container();
		con.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));
		table.getTableHeader().setPreferredSize(new Dimension(table.getWidth(), 40));
		table.setRowHeight(40);
		table.getTableHeader().setFont(new Font("���� ���", Font.BOLD|Font.PLAIN, 20));
		table.getTableHeader().setForeground(new Color(0, 78, 102));
		table.setFont(new Font("���� ���",Font.PLAIN|Font.BOLD,18));
		table.setForeground(new Color(0, 78, 102));
		
		TableColumnModel col = table.getColumnModel();
		
		// for������ ����
		for(int i=0;i<=4;++i) {
			col.getColumn(i).setCellRenderer(new SelectTable());			
		}
		 
		// return button
		returnBtn = new ReturnBtn("�ݳ�");
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
				JOptionPane.showMessageDialog(null, "�ݳ��� �Ϸ�Ǿ����ϴ�");
				JButton btn = (JButton) e.getSource();
				JFrame df = (JFrame) btn.getRootPane().getParent();
				df.dispose();
				new MainFrame();
			}
		});

	}
	
}
