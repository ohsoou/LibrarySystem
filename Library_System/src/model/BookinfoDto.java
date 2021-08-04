package model;

import java.sql.Date;

public class BookinfoDto {
	private int ISBN;
	private String KDC;
	private String author;
	private String publisher;
	private Date publication_date;
	private String book_name;
	
	 public BookinfoDto(int ISBN, String KDC, String author, String publisher, Date publication_date, String book_name) {
		 this.ISBN = ISBN;
		 this.KDC = KDC;
		 this.author = author;
		 this.publisher = publisher;
		 this.publication_date = publication_date;
		 this.book_name = book_name;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getKDC() {
		return KDC;
	}

	public void setKDC(String kDC) {
		KDC = kDC;
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
}
