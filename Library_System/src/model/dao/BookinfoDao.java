package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnector;
import model.dto.Bookinfo;

public class BookinfoDao {
	private static BookinfoDao instance;
	ArrayList<Bookinfo> bookInfoList;
	
	private BookinfoDao() {}
	
	public static BookinfoDao getInstance() {
		if(instance == null) {
			instance = new BookinfoDao();
		}
		return instance;
	}
	
	public ArrayList<Bookinfo> listAllBookinfo(){
		bookInfoList = new ArrayList<>();
		String sql = "SELECT * FROM bookinfo";
		try (
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet resultset = pstmt.executeQuery();
		   ) {
			while(resultset.next()) {
				Bookinfo bookInfo = new Bookinfo(
						resultset.getInt("ISBN"),
						resultset.getString("KDC"),
						resultset.getString("author"),
						resultset.getString("publisher"),
						resultset.getDate("publication_date"),
						resultset.getString("book_name")
						);
				bookInfoList.add(bookInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookInfoList;
	}
	
	public ArrayList<Bookinfo> listByCategory(String category_name){
		bookInfoList = new ArrayList<>();
		String sql = "SELECT * FROM bookinfo JOIN bookclassification"
				+ "ON bookinfo.kdc = bookclassification.kdc"
				+ "Where bookclassification.category_name = ?";
		try (
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		   ) {
			pstmt.setString(1, category_name);
			ResultSet resultset = pstmt.executeQuery();
			
			while(resultset.next()) {
				Bookinfo bookInfo = new Bookinfo(
						resultset.getInt("ISBN"),
						resultset.getString("KDC"),
						resultset.getString("author"),
						resultset.getString("publisher"),
						resultset.getDate("publication_date"),
						resultset.getString("book_name")
						);
				bookInfoList.add(bookInfo);
				resultset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookInfoList;
	}
	
	public ArrayList<Bookinfo> listByBookName(String book_name){
		bookInfoList = new ArrayList<>();
		String sql = "SELECT * FROM bookinfo WHERE book_name LIKE %?%";
		
		try (
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		   ) {
			
			pstmt.setString(1, book_name);
			ResultSet resultset = pstmt.executeQuery();
			
			while(resultset.next()) {
				Bookinfo bookInfo = new Bookinfo(
						resultset.getInt("ISBN"),
						resultset.getString("KDC"),
						resultset.getString("author"),
						resultset.getString("publisher"),
						resultset.getDate("publication_date"),
						resultset.getString("book_name")
					);
				bookInfoList.add(bookInfo);
				resultset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookInfoList;
	}
	
	public ArrayList<Bookinfo> listByAuthor(String author){
		bookInfoList = new ArrayList<>();
		String sql = "SELECT * FROM bookinfo WHERE author LIKE %?%";

		try (
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		   ) {
			pstmt.setString(1, author);
			ResultSet resultset = pstmt.executeQuery();
			
			while(resultset.next()) {
				Bookinfo bookInfo = new Bookinfo(
						resultset.getInt("ISBN"),
						resultset.getString("KDC"),
						resultset.getString("author"),
						resultset.getString("publisher"),
						resultset.getDate("publication_date"),
						resultset.getString("book_name")
					);
				bookInfoList.add(bookInfo);
				resultset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookInfoList;
	}
	
	public int insertBookInfo(int ISBN, String KDC, String author, 
			String publisher, Date publication_date, String book_name) {
		String sql = "INSERT INTO bookinfo VALUES(?,?,?,?,?,?)";
		int row = 0;
		try (
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		   ) {
			pstmt.setInt(1, ISBN);
			pstmt.setString(2, KDC);
			pstmt.setString(3, author);
			pstmt.setString(4, publisher);
			pstmt.setDate(5, publication_date);
			pstmt.setString(6, book_name);
			
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return row;
	}
	
	public int updateAuthor(int ISBN, String author) {
		String sql = "UPDATE bookinfo SET author= ? WHERE ISBN = ?";
		int rows = 0;
		try (
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		   ) {
				pstmt.setString(1, author);
				pstmt.setInt(2, ISBN);

				rows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public int updatePublisher(int ISBN, String publisher) {
		String sql = "UPDATE bookinfo SET publisher= ? WHERE ISBN = ?";
		int rows = 0;
		try (
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		   ){
				pstmt.setString(1, publisher);
				pstmt.setInt(2, ISBN);

				rows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public int updatePublicationDate(int ISBN, Date publication_date) {
		String sql = "UPDATE bookinfo SET author= ? WHERE ISBN = ?";
		int rows = 0;
		try (
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		   ){
			
				pstmt.setDate(1, publication_date);
				pstmt.setInt(2, ISBN);

				rows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public int updateBookName(int ISBN, String bookname) {
		String sql = "UPDATE bookinfo SET bookname= ? WHERE ISBN = ?";
		int rows = 0;
		try (
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		   ) {
			
				pstmt.setString(1, bookname);
				pstmt.setInt(2, ISBN);
			
				rows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public int deleteBookinfo(int ISBN) {
		String sql = "DELETE FROM bookinfo WHERE ISBN = ?";
		int rows = 0;
		try (
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		   ) {
			pstmt.setInt(1, ISBN);
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	
}
