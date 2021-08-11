package view.manager;

import java.util.ArrayList;

import model.dto.AllBookInfo;

public class BookListWithSelectedBook {
	private static AllBookInfo selectedBook;
	private static ArrayList<AllBookInfo> booklist;
	
	public ArrayList<AllBookInfo> getBooklist() {
		return booklist;
	}
	public void setBooklist(ArrayList<AllBookInfo> booklist) {
		this.booklist = booklist;
	}
	public AllBookInfo getSelectedBook() {
		return selectedBook;
	}
	public void setSelectedBook(AllBookInfo selectedBook) {
		this.selectedBook = selectedBook;
	}

}
