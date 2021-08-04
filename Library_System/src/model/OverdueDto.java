package model;


public class OverdueDto {
	private int loan_num;
	private int book_id;
	private int student_num;
	
	public OverdueDto(int loan_num, int book_id, int student_num) {
		super();
		this.loan_num = loan_num;
		this.book_id = book_id;
		this.student_num = student_num;
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

	
}
