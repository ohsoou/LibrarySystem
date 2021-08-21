package view.extend;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import view.defaultcomponent.BookListTable;
import view.defaultcomponent.DefaultPanel;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import model.dao.LoanDao;
import model.dto.Loan;
import view.login.LoginHost;
import view.main.MainFrame;
import view.returns.SelectTable;

public class ExtendTable extends DefaultPanel {
	private JButton extendBtn;
	String student_num;
	static String student_name;

	public ExtendTable() {
		setLayout(new GridLayout(2, 1));

		ArrayList<Loan> dtos;
		LoanDao dao = LoanDao.getInstance();

		dtos = dao.listByStudentNum(LoginHost.getStudent_num());

		String[] columnNames = { "도서명", "대여일", "반납예정", "연체여부", "연장횟수" };
		Object[][] contents = new Object[dtos.size()][columnNames.length];
		Loan[] lo = new Loan[dtos.size()];

		for (int i = 0, len = dtos.size(); i < len; ++i) {
			lo[i] = dtos.get(i);
			long remain = getRemainDay(lo[i].getDeadline());

			contents[i][0] = lo[i].getBook_name();
			contents[i][1] = lo[i].getLoan_date();
			contents[i][2] = lo[i].getDeadline();
			contents[i][3] = remain < 0 ? "Y" : "N";
			contents[i][4] = lo[i].getExtend();
		}

		// table 수정 못하게
		@SuppressWarnings("serial")
		DefaultTableModel model = new DefaultTableModel(contents, columnNames) {

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		JTable table = new JTable(model);

		JScrollPane tablePane = new BookListTable(table);

		table.setSize(700, 240);
		tablePane.setPreferredSize(new Dimension(700, 240));

		table.setDefaultRenderer(Object.class, new SelectTable());

		Container con = new Container();
		con.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));
		table.getTableHeader().setPreferredSize(new Dimension(tablePane.getWidth(), 40));
		table.setRowHeight(40);
		table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD | Font.PLAIN, 20));
		table.getTableHeader().setForeground(new Color(0, 78, 102));
		table.setFont(new Font("맑은 고딕", Font.PLAIN | Font.BOLD, 18));
		table.setForeground(new Color(0, 78, 102));

		// contents align center
		TableColumnModel col = table.getColumnModel();

		// for문으로 수정
		for (int i = 0; i <= 4; ++i) {
			col.getColumn(i).setCellRenderer(new SelectTable());
		}

		extendBtn = new ExtendBtn("연장");
		con.add(extendBtn);

		add(tablePane);
		add(con);

		extendBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int loan_num = lo[row].getLoan_num();
				if (lo[row].getExtend() < 3) {
					JOptionPane.showMessageDialog(null, "연장이 완료되었습니다");
					dao.updateExtend(loan_num);
					dao.updateDeadline(loan_num);
					JButton btn = (JButton) e.getSource();
					JFrame df = (JFrame) btn.getRootPane().getParent();
					df.dispose();
					new MainFrame();
				} else {
					JOptionPane.showMessageDialog(null, "3회 이상 연장은 불가능 합니다");
				}
			}
		});

	}

	private long getRemainDay(Date deadline) {

		java.util.Date utilDate = new java.util.Date();
		java.util.Date dead = new java.util.Date(deadline.getTime());

		long calDate = dead.getTime() - utilDate.getTime();

		return calDate / (24 * 60 * 60 * 1000);

	}
}