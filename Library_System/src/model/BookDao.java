package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnector;

public class BookDao {
	private Connection conn;
	PreparedStatement pstmt;
	int deleteRows;
	int updateRows;
	int Rows;
	String sql;

	public ArrayList<BookDto> list() {		
	ArrayList<BookDto> BookDao = new ArrayList<BookDto>();		
	String sql = "SELECT * FROM book";

	try (
			Connection conn 
				= DBConnector.getConnection();		
			PreparedStatement pstmt
				= conn.prepareStatement(sql);
			ResultSet rs 
			= pstmt.executeQuery();
			){	
		 while(rs.next()) {
				int book_id = rs.getInt("book_id");
				int ISBN = rs.getInt("ISBN");
				String loan_state = rs.getString("loan_state");		

				BookDto BookDto = new BookDto(book_id, ISBN, loan_state);
				BookDao.add(BookDto);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return BookDao;	

	}

	public int insertBook(int book_id, int ISBN, String loan_state) {
		sql = "INSERT INTO book VALUES(?,?,?)";
		Rows = 0;
		
		try (
			Connection conn 
				= DBConnector.getConnection();		
			PreparedStatement pstmt
				= conn.prepareStatement(sql);			
		){
			pstmt.setInt(1, book_id);
			pstmt.setInt(2, ISBN);
			pstmt.setString(3, loan_state);

			Rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return Rows;
	}

	public int updateBook(int book_id, int ISBN) {
		sql = "UPDATE book SET" + book_id + "= ? WHERE ISBN = ?";
		updateRows = 0;
		
		try {
			pstmt.setInt(1, book_id);
			pstmt.setInt(2, ISBN);		

			updateRows = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateRows;
	}

	public int deleteBook(int book_id) {
		sql = "DELETE FROM book WHERE book_id = ?";
		deleteRows = 0;
		 
		try(
			Connection conn 
				= DBConnector.getConnection();		
			PreparedStatement pstmt
				= conn.prepareStatement(sql);	
		){
			pstmt.setInt(1, book_id);
			
			deleteRows = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleteRows;
	}

} 