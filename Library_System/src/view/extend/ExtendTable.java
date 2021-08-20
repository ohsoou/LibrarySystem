package view.extend;

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
import view.login.LoginHost;
import view.returns.SelectTable;

public class ExtendTable extends JPanel {
	private JButton extendBtn;
	String student_num;
	static String student_name;
	public ExtendTable() {
		setLayout(new GridLayout(2, 1));
		
		ArrayList<Loan> dtos;
		LoanDao dao = LoanDao.getInstance();
		
		dtos = dao.listByStudentNum(LoginHost.getStudent_num());
		
		String[] columnNames = {"������","�뿩��","�ݳ�����","��ü����","����Ƚ��"};
		Object[][] contents = new Object[dtos.size()][columnNames.length];
		Loan[] lo = new Loan[dtos.size()];
		
		for(int i =0,len = dtos.size(); i < len; ++i) {
			lo[i] = dtos.get(i);
			int overduePeriod = lo[i].getOverdue_period();
			
					contents[i][0] = lo[i].getBook_name();	
					contents[i][1] = lo[i].getLoan_date();
					contents[i][2] = lo[i].getDeadline();
					contents[i][3] = overduePeriod < 0 ? "Y" : "N";
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
		
				table.setSize(700,240);
				tablePane.setPreferredSize(new Dimension(700,240));
				
				Container con = new Container();
				con.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));
				
		table.getTableHeader().setPreferredSize(new Dimension(
				tablePane.getWidth(),40
				));
		table.setRowHeight(40);
		table.getTableHeader().setFont(new Font("���� ����", Font.BOLD|Font.PLAIN, 20));
		table.getTableHeader().setForeground(new Color(0, 78, 102));
		table.setFont(new Font("���� ����",Font.PLAIN|Font.BOLD,18));
		table.setForeground(new Color(0, 78, 102));
		
		// contents align center
		DefaultTableCellRenderer alignCenter = new DefaultTableCellRenderer();
		alignCenter.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel col = table.getColumnModel();
		
		col.getColumn(0).setCellRenderer(alignCenter);
		col.getColumn(1).setCellRenderer(alignCenter);
		col.getColumn(2).setCellRenderer(alignCenter);
		col.getColumn(3).setCellRenderer(alignCenter);
		col.getColumn(4).setCellRenderer(alignCenter);	
		
		extendBtn = new ExtendBtn("����");
		con.add(extendBtn);
		
		add(tablePane);
		add(con);
		
		extendBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int loan_num = lo[row].getLoan_num();
				dao.updateExtend(loan_num);
				dao.updateDeadline(loan_num);
				JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�");
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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