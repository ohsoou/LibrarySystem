package view.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.dao.LoanDao;
import model.dao.TotalOverdueCountDao;
import model.dto.Loan;
import model.dto.TotalOverdueCount;
import view.returns.ReturnFrame;
import view.extend.ExtendFrame;
import view.login.LoginHost;
import view.rental.RentalMainFrame;

	
public class MainNextAction implements ActionListener{

	String next;
	public MainNextAction(String next) {
		this.next = next;
		
	}
	
	public static int overCount(String Host) {
		TotalOverdueCountDao dao = TotalOverdueCountDao.getInstance();
		ArrayList<TotalOverdueCount> dto = dao.listAllOverdueCount();
		int overDay = 0;
		for(int i = 0; i < dto.size(); ++i) {
			if(dto.get(i).getStudent_num() == Integer.parseInt(Host)) {
				overDay = dto.get(i).getTotal_overdue();
			}
		}		
		return overDay;
	}
	
	public static boolean isOverdue() {
		Date utilDate = new Date();
		LoanDao dao = LoanDao.getInstance();
		ArrayList<Loan> dto = dao.listByStudentNum(LoginHost.getStudent_num());
		for(int i = 0; i < dto.size(); ++i) {			
			if(dto.get(i).getReturn_date() == null && dto.get(i).getDeadline().before(utilDate)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		JFrame df = (JFrame)((JButton)e.getSource()).getRootPane().getParent();
		
		if(next.equals("rental")) {	
			if(overCount(LoginHost.getStudent_num()) > 0) {
				if(isOverdue()) {
					JOptionPane.showMessageDialog(df,"연체 상태입니다. 연장 불가능합니다.","알림 메세지", JOptionPane.WARNING_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(df,"연체기록이있습니다 "+overCount(LoginHost.getStudent_num())+"일간 대여 불가능합니다.","알림 메세지", JOptionPane.WARNING_MESSAGE);
				}
			}else {
				df.dispose();
				new RentalMainFrame();
			}

		} else if (next.equals("return")) {
			df.dispose();
			new ReturnFrame();
			
		} else if (next.equals("extention")) {
			if(isOverdue()) {
				JOptionPane.showMessageDialog(df,"연체 상태입니다. 연장 불가능합니다.","알림 메세지", JOptionPane.WARNING_MESSAGE);
			}else {
				df.dispose();
				new ExtendFrame();
			}
		}
		
	}

}
