package view.manager;

import java.util.ArrayList;

import model.dto.AllBookInfo;

public class BookListWithSelectedBook {
	private static AllBookInfo selectedBook;
	private static ArrayList<AllBookInfo> booklist;
	private static int filter;
	private static String searchedText;
	
	public static ArrayList<AllBookInfo> getBooklist() {
		return booklist;
	}
	public static void setBooklist(ArrayList<AllBookInfo> booklist) {
		BookListWithSelectedBook.booklist = booklist;
	}
	public static AllBookInfo getSelectedBook() {
		return selectedBook;
	}
	public static void setSelectedBook(AllBookInfo selectedBook) {
		BookListWithSelectedBook.selectedBook = selectedBook;
	}
	public static int getFilter() {
		return filter;
	}
	public static void setFilter(int filter) {
		BookListWithSelectedBook.filter = filter;
	}
	public static String getSearchedText() {
		return searchedText;
	}
	public static void setSearchedText(String searchedText) {
		BookListWithSelectedBook.searchedText = searchedText;
	}

}
