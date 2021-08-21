package view.rental;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.dao.LoanDao;
import model.dto.Loan;
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
			JOptionPane.showMessageDialog(df,"미반납책 "+studentloanSize+" 권  "+Math.abs(availableLoan)+"권 대여 가능합니다.","알림 메세지", JOptionPane.WARNING_MESSAGE);

		}else {
			for(int i = 0; i < userSelectionSize; ++i) {
				int bookId = UserSelection.getSelectedBooks().get(i).getBook_id();
				insertLoan(Integer.parseInt(LoginHost.getStudent_num()),bookId);
			}
			df.dispose();
			
			new RentalEndFrame();
		}


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

}
