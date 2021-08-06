package model.dto;


public class Overdue {
	private int loan_num;
	private int book_id;
	private int student_num;
	private int overdue_period;
	
	public Overdue(int loan_num, int book_id, int student_num, int overdue_period) {
		this.loan_num = loan_num;
		this.book_id = book_id;
		this.student_num = student_num;
		this.overdue_period = overdue_period;
	}
	public int getLoan_num() {
		return loan_num;
	}
	public void setLoan_num(int loan_num) {
		this.loan_num = loan_num;
	}
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	
	public int getStudent_num() {
		return student_num;
	}
	public void setStudent_num(int student_num) {
		this.student_num = student_num;
	}
	public int getOverdue_period() {
		return overdue_period;
	}
	public void setOverdue_period(int overdue_period) {
		this.overdue_period = overdue_period;
	}
	@Override
	public String toString() {
		return "Overdue [loan_num=" + loan_num + ", book_id=" + book_id + ", student_num=" + student_num
				+ ", overdue_period=" + overdue_period + "]";
	}
	
}
