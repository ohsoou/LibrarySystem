package model.dto;

import java.sql.Date;

public class Bookinfo {
	private long ISBN;
	private String KDC;
	private String author;
	private String publisher;
	private Date publication_date;
	private String book_name;
	private String imagepath;
	private String summary;
	
	 public Bookinfo(long ISBN, String KDC, String author, String publisher, Date publication_date, String book_name, String imagepath, String summary) {
		 this.ISBN = ISBN;
		 this.KDC = KDC;
		 this.author = author;
		 this.publisher = publisher;
		 this.publication_date = publication_date;
		 this.book_name = book_name;
		 this.imagepath =  imagepath;
		 this.summary = summary;
	}

	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
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

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		return "Bookinfo [ISBN=" + ISBN + ", KDC=" + KDC + ", author=" + author + ", publisher=" + publisher
				+ ", publication_date=" + publication_date + ", book_name=" + book_name +", imagepath="+imagepath+", summary="+summary+"]";
	}
	
	
}
