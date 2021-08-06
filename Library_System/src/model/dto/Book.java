package model.dto;

public class Book {
	
	private int book_id;
	private int ISBN;
	private String LOAN_STATE;
	
	public Book(int book_id, int iSBN2, String LOAN_STATE) {
		this.book_id = book_id;
		this.ISBN = iSBN2;
		this.LOAN_STATE = LOAN_STATE;
	}
	
	public int getbook_id() {
		return book_id;
	}
	public int getISBN() {
		return ISBN;
	}
	public String getloan_state() {
		return LOAN_STATE;
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", ISBN=" + ISBN + ", LOAN_STATE=" + LOAN_STATE + "]";
	}
	
	
}
