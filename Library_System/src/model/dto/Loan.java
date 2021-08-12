package model.dto;

import java.sql.Date;

public class Loan {
	//loan DTO
	private Date loan_date;
	private Date return_date;
	private int loan_num;
	private String student_num;
	private int book_id;
	private int extend;
	private String book_name;
	
	public Loan(int loan_num, String student_num, int book_id, Date loan_date, Date return_date, int extend ) {
		this.loan_num = loan_num;
		this.student_num = student_num;
		this.book_id = book_id;
		this.loan_date = loan_date;
		this.return_date = return_date;
		this.extend = extend;
		
	}
	
	public Loan(int loan_num, String student_num, String book_name, Date loan_date, Date return_date, int extend) {
		this.loan_num = loan_num;
		this.student_num = student_num;
		this.book_name = book_name;
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

	public String getStudent_num() {
		return student_num;
	}
	
	public void setStudent_num(String student_num) {
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
	
	public String getBook_name() {
		return book_name;
	}
	
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	@Override
	public String toString() {
		return "Loan [loan_date=" + loan_date + ", return_date=" + return_date + ", loan_num=" + loan_num
				+ ", student_num=" + student_num + ", book_id=" + book_id + ", extend=" + extend + "]";
	}

}
