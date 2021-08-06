package model.dto;

import java.sql.Date;

public class AllBookInfo {
	private int book_id;
	private int isbn;
	private String loan_state;
	private String kdc;
	private String category_name;
	private String author;
	private String publisher;
	private Date publication_date;
	private String book_name;
	
	
	public AllBookInfo(int book_id, int isbn, String loan_state, String kdc, String category_name, String author,
			String publisher, Date publication_date, String book_name) {
		super();
		this.book_id = book_id;
		this.isbn = isbn;
		this.loan_state = loan_state;
		this.kdc = kdc;
		this.category_name = category_name;
		this.author = author;
		this.publisher = publisher;
		this.publication_date = publication_date;
		this.book_name = book_name;
	}


	public int getBook_id() {
		return book_id;
	}


	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}


	public int getIsbn() {
		return isbn;
	}


	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}


	public String getLoan_state() {
		return loan_state;
	}


	public void setLoan_state(String loan_state) {
		this.loan_state = loan_state;
	}


	public String getKdc() {
		return kdc;
	}


	public void setKdc(String kdc) {
		this.kdc = kdc;
	}


	public String getCategory_name() {
		return category_name;
	}


	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public Date getPublication_date() {
		return publication_date;
	}


	public void setPublication_date(Date publication_date) {
		this.publication_date = publication_date;
	}


	public String getBook_name() {
		return book_name;
	}


	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}


	@Override
	public String toString() {
		return "AllBookInfo [book_id=" + book_id + ", isbn=" + isbn + ", loan_state=" + loan_state + ", kdc=" + kdc
				+ ", category_name=" + category_name + ", author=" + author + ", publisher=" + publisher
				+ ", publication_date=" + publication_date + ", book_name=" + book_name + "]";
	}
	

}
