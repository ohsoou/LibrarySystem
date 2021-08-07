package model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnector;
import model.dto.Book;

public class BookDao {
	private static BookDao instance;
	ArrayList<Book> Booklist;

	private BookDao() {}
	
	public static BookDao getInstance() {
		if(instance == null) {
			instance = new BookDao();
		}
		return instance;
	}

	public ArrayList<Book> listAllBook() {
		Booklist = new ArrayList<Book>();
		String sql = "SELECT * FROM book";

		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			) {
			while (rs.next()) {
				int book_id = rs.getInt("book_id");
				long ISBN = rs.getLong("ISBN");
				String loan_state = rs.getString("loan_state");

				Booklist.add(new Book(book_id, ISBN, loan_state));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Booklist;

	}

	public int insertBook(int book_id, long ISBN, String loan_state) {
		String sql = "INSERT INTO book VALUES(Book_id_seq.nextval,?,?)";
		int row = 0;
		
		try (
			Connection conn = DBConnector.getConnection();		
			PreparedStatement pstmt = conn.prepareStatement(sql);			
		){

			pstmt.setLong(1, ISBN);
			pstmt.setString(2, loan_state);

			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return row;
	}

	public int updateBook(int book_id, long ISBN) {
		String sql = "UPDATE book SET" + book_id + "= ? WHERE ISBN = ?";
		int rows = 0;
		
		try (
				Connection conn = DBConnector.getConnection();		
				PreparedStatement pstmt = conn.prepareStatement(sql);			
			){
			pstmt.setInt(1, book_id);
			pstmt.setLong(2, ISBN);		

			rows = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

	public int deleteBook(int book_id) {
		String sql = "DELETE FROM book WHERE book_id = ?";
		int rows = 0;
		 
		try(
			Connection conn = DBConnector.getConnection();		
			PreparedStatement pstmt = conn.prepareStatement(sql);	
		){
			pstmt.setInt(1, book_id);
			rows = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

} 