package model;

import java.sql.Date;

public class Overdue_dto {
	private int loan_num;
	private int book_id;
	private int student_num;
	private Date loan_date;
	private Date return_date;
	private int extend;
	
	public Overdue_dto(int loan_num2, int book_id2, int student_num2) {
		this.loan_num = loan_num;
		this.book_id= book_id;
		this.student_num = student_num;
		this.loan_date = loan_date;
		this.return_date = return_date;
		this.extend = extend;
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
	
	public Date getLoan_date() {
		return loan_date;
	}
	public void setLoan_date(Date loan_date) {
		this.loan_date = loan_date;
	}
	
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	
	public int getExtend() {
		return extend;
	}
	public void setExtend(int extend) {
		this.extend = extend*10;
	}
	
}
