package view.rental;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.dao.LoanDao;
import model.dao.OverdueCountDao;
import model.dto.Loan;
import model.dto.OverdueCount;
import view.login.LoginHost;
import view.rental.rentalEndPage.RentalEndFrame;

public class SelectBtnAction implements ActionListener{

	JButton btn;
	private static final int MAXloanSize = 3;
	private int studentloanSize;
	private int userSelectionSize;
	private int availableLoan;

	public SelectBtnAction(JButton btn) {
		this.btn = btn;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<Loan> studentloanBooks = listLoan();
		studentloanSize = studentloanBooks.size();
		userSelectionSize = UserSelection.getSelectionSize();
		availableLoan = MAXloanSize - studentloanSize;
		
		JButton btn = (JButton)e.getSource();
		JFrame df = (JFrame)btn.getRootPane().getParent();
		if(userSelectionSize > availableLoan) {		

			JOptionPane.showMessageDialog(df,"미반납책 "+studentloanSize+" 권  "+Math.abs(availableLoan)+" 권 대여가능", "알림 메세지", JOptionPane.WARNING_MESSAGE);

			JOptionPane.showMessageDialog(df,"미반납책 "+studentloanSize+" 권  "+Math.abs(availableLoan)+"권 대여 가능합니다.","알림 메세지", JOptionPane.WARNING_MESSAGE);
		}else if(overCount(LoginHost.getStudent_num()) > 0) {
			
			JOptionPane.showMessageDialog(df,"연체기록이있습니다 "+overCount(LoginHost.getStudent_num())+"일간 대여 불가능합니다.","알림 메세지", JOptionPane.WARNING_MESSAGE);
			
		}else if(returnData()){
			
			JOptionPane.showMessageDialog(df,"연체 상태입니다. 대여가 불가능합니다.","알림 메세지", JOptionPane.WARNING_MESSAGE);
		}else {
			for(int i = 0; i < userSelectionSize; ++i) {
				int bookId = UserSelection.getSelectedBooks().get(i).getBook_id();
				insertLoan(Integer.parseInt(LoginHost.getStudent_num()),bookId);
			}
			df.dispose();
			
			new RentalEndFrame();
		}

	}
	
	private static int overCount(String Host) {
		OverdueCountDao dao = OverdueCountDao.getInstance();
		ArrayList<OverdueCount> dto = dao.listAllOverdueCount();
		int overDay = 0;
		for(int i = 0; i < dto.size(); ++i) {
			if(dto.get(i).getStudent_num() == Integer.parseInt(Host)) {
				overDay = dto.get(i).getTotal_overdue();
			}
		}		
		return overDay;
	}
	
	public static boolean returnData() {
		Date utilDate = new Date();		
		boolean data = false;
		LoanDao dao = LoanDao.getInstance();
		ArrayList<Loan> dto = dao.listByStudentNum(LoginHost.getStudent_num());
		for(int i = 0; i < dto.size(); ++i) {
			if(dto.get(i).getReturn_date() == null && dto.get(i).getDeadline().before(utilDate)) {
				data = true;
			}
		}
		return data;
	}
	
	private static void insertLoan(int student_num, int book_id) {
		LoanDao dao = LoanDao.getInstance();
		dao.insertLoan(student_num, book_id);
	}
	
	private static ArrayList<Loan> listLoan() {
		LoanDao dao = LoanDao.getInstance();
		ArrayList<Loan> dto = dao.listByStudentNum(LoginHost.getStudent_num());
		return dto;
	}
	
	public static void main(String[] args) {
		Date utilDate = new Date();
		System.out.println(utilDate);
	}
}
