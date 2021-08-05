package model;

public class BookDto {
	
	private int book_id;
	private String ISBN;
	private String LOAN_STATE;
	
	public BookDto(int book_id, String ISBN, String LOAN_STATE) {
		this.book_id = book_id;
		this.ISBN = ISBN;
		this.LOAN_STATE = LOAN_STATE;
	}
	
	public int getbook_id() {
		return book_id;
	}
	public String getISBN() {
		return ISBN;
	}
	public String getloan_state() {
		return LOAN_STATE;
	}
	
	@Override
	public String toString() {
		return String.format("%d/%s/%s", book_id, ISBN, LOAN_STATE);
	}
}
