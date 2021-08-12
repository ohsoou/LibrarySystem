package view.manager;

import java.util.ArrayList;

import model.dto.AllBookInfo;

public class BookListWithSelectedBook {
    private static AllBookInfo selectedBook;
    private static ArrayList<AllBookInfo> booklist;
    private static int filter;
    private static String searchedText;

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