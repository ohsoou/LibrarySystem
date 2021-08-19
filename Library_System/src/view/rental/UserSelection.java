package view.rental;

import java.util.ArrayList;

import model.dto.AllBookInfo;

public class UserSelection {
	private static ArrayList<AllBookInfo> selectedBooks = new ArrayList<>();
	
	public static int getSelectionSize() {
		return selectedBooks.size();
	}
	
	public static ArrayList<AllBookInfo> getSelectedBooks() {
		return selectedBooks;
	}
	
	public static void setSelectedBooks(ArrayList<AllBookInfo> selectedBooks) {
		UserSelection.selectedBooks = selectedBooks;
	}
	
	public static void addSelectedBook(AllBookInfo selectedBook) {
		UserSelection.selectedBooks.add(selectedBook);
	}
	
	public static AllBookInfo removeSelectedBook(int index) {
		return UserSelection.selectedBooks.remove(index);
	}
	
	
	public static void clearSelectedBook() {
		UserSelection.selectedBooks.clear();
	}

}
