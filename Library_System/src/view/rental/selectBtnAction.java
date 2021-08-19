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
	private static final int MAXloanSize = 3;
	private int studentloanSize;
	private int userSelectionSize;
	private int availableLoan;

	public selectBtnAction(JButton btn) {
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
			JOptionPane.showMessageDialog(df,"�̹ݳ�å "+studentloanSize+" ��  "+Math.abs(availableLoan)+" �� �뿩����", "�˸� �޼���", JOptionPane.WARNING_MESSAGE);

		}else {
			for(int i = 0; i < userSelectionSize; ++i) {
				int bookId = UserSelection.getSelectedBooks().get(i).getBook_id();
				insertLoan(Integer.parseInt(LoginHost.getStudent_num()),bookId);
				
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


	// DB �뿩 ������ �߰�
	private static void insertLoan(int student_num, int book_id) {
		LoanDao dao = LoanDao.getInstance();
		dao.insertLoan(student_num, book_id);
	}
	
	// �ش� �л��� �뿩 ���� �뿩 ���� ��������
	private static ArrayList<Loan> listLoan() {
		LoanDao dao = LoanDao.getInstance();
		ArrayList<Loan> dto = dao.listByStudentNum(LoginHost.getStudent_num());
		return dto;
	}

}
