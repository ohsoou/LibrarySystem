package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnector;

public class BookinfoDao {
	
	private Connection conn;
	PreparedStatement pstmt;
	ResultSet resultset;
	ArrayList<BookinfoDto> bookInfoList;
	String sql;
	
	public BookinfoDao() {
		try {
			conn = DBConnector.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BookinfoDto> allBookInfo(){
		bookInfoList = new ArrayList();
		sql = "SELECT * FROM bookinfo";
		try {
			pstmt = conn.prepareStatement(sql);
			resultset = pstmt.executeQuery();
			
			while(resultset.next()) {
				BookinfoDto bookInfo = new BookinfoDto(
						resultset.getInt("ISBN"),
						resultset.getString("KDC"),
						resultset.getString("author"),
						resultset.getString("publisher"),
						resultset.getDate("publication_date"),
						resultset.getString("book_name"));
				bookInfoList.add(bookInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookInfoList;
	}
	
	public ArrayList<BookinfoDto> searchByCategory(String category_name){
		bookInfoList = new ArrayList();
		sql = "SELECT * FROM bookinfo JOIN bookclassification"
				+ "ON bookinfo.kdc = bookclassification.kdc"
				+ "Where bookclassification.category_name = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category_name);
			resultset = pstmt.executeQuery();
			
			while(resultset.next()) {
				BookinfoDto bookInfo = new BookinfoDto(
						resultset.getInt("ISBN"),
						resultset.getString("KDC"),
						resultset.getString("author"),
						resultset.getString("publisher"),
						resultset.getDate("publication_date"),
						resultset.getString("book_name"));
				bookInfoList.add(bookInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookInfoList;
	}
	
	public ArrayList<BookinfoDto> searchByBookName(String book_name){
		bookInfoList = new ArrayList();
		sql = "SELECT * FROM bookinfo WHERE book_name LIKE ?";
		book_name += "%";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book_name);
			resultset = pstmt.executeQuery();
			
			while(resultset.next()) {
				BookinfoDto bookInfo = new BookinfoDto(
						resultset.getInt("ISBN"),
						resultset.getString("KDC"),
						resultset.getString("author"),
						resultset.getString("publisher"),
						resultset.getDate("publication_date"),
						resultset.getString("book_name"));
				bookInfoList.add(bookInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookInfoList;
	}
	
	public ArrayList<BookinfoDto> searchByAuthor(String author){
		bookInfoList = new ArrayList();
		sql = "SELECT * FROM bookinfo WHERE author LIKE ?";
		author += "%";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, author);
			resultset = pstmt.executeQuery();
			
			while(resultset.next()) {
				BookinfoDto bookInfo = new BookinfoDto(
						resultset.getInt("ISBN"),
						resultset.getString("KDC"),
						resultset.getString("author"),
						resultset.getString("publisher"),
						resultset.getDate("publication_date"),
						resultset.getString("book_name"));
				bookInfoList.add(bookInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookInfoList;
	}
	
	public void insertBookInfo(int ISBN, String KDC, String author, 
			String publisher, Date publication_date, String book_name) {
		sql = "INSERT INTO bookinfo VALUES(?,?,?,?,?,?)";
		try {
			pstmt.setInt(1, ISBN);
			pstmt.setString(2, KDC);
			pstmt.setString(3, author);
			pstmt.setString(4, publisher);
			pstmt.setDate(5, publication_date);
			pstmt.setString(6, book_name);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void updateAuthor(int ISBN, String author) {
		sql = "UPDATE bookinfo SET author= ? WHERE ISBN = ?";
		
		try {
				pstmt.setString(1, author);
				pstmt.setInt(2, ISBN);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updatePublisher(int ISBN, String publisher) {
		sql = "UPDATE bookinfo SET publisher= ? WHERE ISBN = ?";
		
		try {
				pstmt.setString(1, publisher);
				pstmt.setInt(2, ISBN);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updatePublicationDate(int ISBN, Date publication_date) {
		sql = "UPDATE bookinfo SET author= ? WHERE ISBN = ?";
		
		try {
			
				pstmt.setDate(1, publication_date);
				pstmt.setInt(2, ISBN);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateBookName(int ISBN, String bookname) {
		sql = "UPDATE bookinfo SET bookname= ? WHERE ISBN = ?";
		
		try {
			
				pstmt.setString(1, bookname);
				pstmt.setInt(2, ISBN);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int ISBN) {
		sql = "DELETE FROM bookinfo WHERE ISBN = ?";
		try {
			pstmt.setInt(1, ISBN);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
