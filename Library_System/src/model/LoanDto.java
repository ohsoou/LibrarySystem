package model;

import java.util.Date;

public class LoanDto {
	
	private Date loan_date;
	private Date return_date;
	private int loan_num;
	private int student_num;
	private int book_id;
	private int extend;
	
	public LoanDto(int loan_num, int student_num, int book_id, java.sql.Date loan_date, java.sql.Date return_date, int extend ) {
		this.loan_num = loan_num;
		this.student_num = student_num;
		this.book_id = book_id;
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

	public int getStudent_num() {
		return student_num;
	}
	
	public void setStudent_num(int student_num) {
		this.student_num = student_num;
	}
	public int getBook_id() {
		return book_id;
	}
	
	public void setBook_id(int book_id) {
		this.book_id = book_id;
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
		this.extend = extend;
	}

	
	@Override
	public String toString() {
		return String.format("%d/%d/%d/%s/%s/%d",
				loan_num, student_num, book_id, loan_date, return_date, extend);
	}
}
