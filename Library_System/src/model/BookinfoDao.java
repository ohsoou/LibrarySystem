package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnector;

public class BookinfoDao {
	
	ArrayList<BookinfoDto> bookInfoList;
	String sql;
	
	public ArrayList<BookinfoDto> listAll(){
		bookInfoList = new ArrayList();
		sql = "SELECT * FROM bookinfo";
		try (
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			
			){
			ResultSet resultset = pstmt.executeQuery();
			
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
	
	public ArrayList<BookinfoDto> listByCategory(String category_name){
		bookInfoList = new ArrayList();
		sql = "SELECT * FROM bookinfo JOIN bookclassification"
				+ "ON bookinfo.kdc = bookclassification.kdc"
				+ "Where bookclassification.category_name = ?";
		try (
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			
			){
			pstmt.setString(1, category_name);
			ResultSet resultset = pstmt.executeQuery();
			
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
	
	public ArrayList<BookinfoDto> listByBookName(String book_name){
		bookInfoList = new ArrayList();
		sql = "SELECT * FROM bookinfo WHERE book_name LIKE ?";
		book_name += "%";
		try (
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			
			){
			pstmt.setString(1, book_name);
			ResultSet resultset = pstmt.executeQuery();
			
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
	
	public ArrayList<BookinfoDto> listByAuthor(String author){
		bookInfoList = new ArrayList();
		sql = "SELECT * FROM bookinfo WHERE author LIKE ?";
		author += "%";
		try (
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			
			){
			pstmt.setString(1, author);
			ResultSet resultset = pstmt.executeQuery();
			
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
		try(
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			
			) {
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
	
	public void updateBookInfo(int ISBN, String column, String value) {
		sql = "UPDATE bookinfo SET"+column+"= ? WHERE ISBN = ?";
		
		try(
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			
			) {
			
			if(column.equals("ISBN")) {
				pstmt.setInt(1, Integer.parseInt(value));
				pstmt.setInt(2, ISBN);
			}else {
				pstmt.setString(1, value);
				pstmt.setInt(2, ISBN);
			}
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int ISBN) {
		sql = "DELETE FROM bookinfo WHERE ISBN = ?";
		try (
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			
			){
			pstmt.setInt(1, ISBN);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
