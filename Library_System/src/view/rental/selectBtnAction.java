package view.rental;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.dao.LoanDao;
import model.dto.Loan;
import view.login.LoginHost;
import view.rental.rentalEndPage.rentalEndFrame;

public class selectBtnAction implements ActionListener{

	JButton btn;
	private static final int loanSize = 3;
	private int studentloanSize;
	private int userSelectionSize;
	private int notReturn;
	java.util.Date utilDate = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

	public selectBtnAction(JButton btn) {
		this.btn = btn;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		studentloanSize = studentLoanSize(LoginHost.getStudent_num());
		userSelectionSize = UserSelection.getSelectionSize();
		notReturn = loanSize - studentloanSize;
		if((studentloanSize+userSelectionSize) > 3) {		
			JOptionPane.showMessageDialog(SearchedTableTopPanel.table,"미반납책 "+studentloanSize+"권 "+Math.abs(notReturn)+"권 대여가능", "알림 메세지", JOptionPane.WARNING_MESSAGE);

		}else {

			for(int i = 0; i < UserSelection.getSelectionSize(); ++i) {
				int bookId = UserSelection.getSelectedBooks().get(i).getBook_id();
				insertLoan(Integer.parseInt(LoginHost.getStudent_num()),bookId,sqlDate,null,0);
				JButton btn = (JButton)e.getSource();
				JFrame df = (JFrame)btn.getRootPane().getParent();
				df.dispose();
				
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						rentalEndFrame.frameRental = new rentalEndFrame();
						rentalEndFrame.frameRental.setVisible(true);
					}
				});
			}
		}


	}

	private static int studentLoanSize(String loginHost) {
		int Size = 0;
		for(int i = 0; i < listLoan().size(); ++i) {
			if(loginHost.equals(listLoan().get(i).getStudent_num()) && listLoan().get(i).getReturn_date().equals(null)) {
				Size++;
			}
		}
		return Size;
	}

	private static void insertLoan(int student_num, int book_id, Date loan_date, Date return_date, int extend) {
		LoanDao dao = LoanDao.getInstance();
		dao.insertLoan(student_num, book_id, loan_date, return_date, extend);
	}
	
	private static ArrayList<Loan> listLoan() {
		LoanDao dao = LoanDao.getInstance();
		ArrayList<Loan> dto = dao.listAllLoan();
		return dto;
	}

}
