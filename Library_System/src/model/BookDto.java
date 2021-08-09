package model;

public class BookDto {
	
	private int book_id;
	private int ISBN;
	private String loan_state;
	
	public BookDto(int book_id, int ISBN, String loan_state) {
		this.book_id = book_id;
		this.ISBN = ISBN;
		this.loan_state = loan_state;
	}
	
	public int getbook_id() {
		return book_id;
	}
	public int getISBN() {
		return ISBN;
	}
	public String getloan_state() {
		return loan_state;
	}
	@Override
	public String toString() {
		return String.format("%d/%s/%d", book_id, ISBN, loan_state);
	}
}
