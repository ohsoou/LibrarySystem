package view.rental;

import java.util.ArrayList;

import model.dto.AllBookInfo;

public class StoregeBook {
	
	public static ArrayList<AllBookInfo> storegeBooks = new ArrayList<>();
	
	public static int getSelectionSize() {
		return storegeBooks.size();
	}
	
	public static ArrayList<AllBookInfo> getSelectedBooks() {
		return storegeBooks;
	}
	
	public static void setSelectedBooks(ArrayList<AllBookInfo> storegeBooks) {
		StoregeBook.storegeBooks = storegeBooks;
	}
	
	public static AllBookInfo removeSelectedBook(int index) {
		return StoregeBook.storegeBooks.remove(index);
	}
	
	public static void addSelectedBook(AllBookInfo storegeBooks) {
		StoregeBook.storegeBooks.add(storegeBooks);
	}

}
