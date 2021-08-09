package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnector;
import model.dto.AllBookInfo;

public class AllBookInfoDao {
	private static AllBookInfoDao instance;
	ArrayList<AllBookInfo> allBookInfoList;
	
	private AllBookInfoDao() {}
	
	public static AllBookInfoDao getInstance() {
		if(instance == null) {
			instance = new AllBookInfoDao();
		}
		return instance;
	}
	
	public ArrayList<AllBookInfo> listAll_AllBookinfo(){
		allBookInfoList = new ArrayList<>();
		String sql = "SELECT * FROM allBookInfo";
		try (
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		   ) {
			while(rs.next()) {
				AllBookInfo bookInfo = new AllBookInfo(
						rs.getInt("Book_id"),
						rs.getLong("ISBN"),
						rs.getString("loan_state"),
						rs.getString("KDC"),
						rs.getString("category_name"),
						rs.getString("author"),
						rs.getString("publisher"),
						rs.getDate("publication_date"),
						rs.getString("book_name"),
						rs.getString("imagepath"),
						rs.getString("summary")
						
						);
				allBookInfoList.add(bookInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allBookInfoList;
	}
	
	public ArrayList<AllBookInfo> listByPublisher(String publisher){
		allBookInfoList = new ArrayList<>();
		String sql = "SELECT * FROM allBookInfo WHERE publisher LIKE '%?%'";
		try (
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		   ) {
			pstmt.setString(1, publisher);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				AllBookInfo bookInfo = new AllBookInfo(
						rs.getInt("Book_id"),
						rs.getLong("ISBN"),
						rs.getString("loan_state"),
						rs.getString("KDC"),
						rs.getString("category_name"),
						rs.getString("author"),
						rs.getString("publisher"),
						rs.getDate("publication_date"),
						rs.getString("book_name"),
						rs.getString("imagepath"),
						rs.getString("summary")
						
						);
				allBookInfoList.add(bookInfo);
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allBookInfoList;
	}
	
	public ArrayList<AllBookInfo> listByBookName(String name){
		allBookInfoList = new ArrayList<>();
		String sql = "SELECT * FROM allBookInfo WHERE book_name LIKE '%?%'";
		try (
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		   ) {
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				AllBookInfo bookInfo = new AllBookInfo(
						rs.getInt("Book_id"),
						rs.getLong("ISBN"),
						rs.getString("loan_state"),
						rs.getString("KDC"),
						rs.getString("category_name"),
						rs.getString("author"),
						rs.getString("publisher"),
						rs.getDate("publication_date"),
						rs.getString("book_name"),
						rs.getString("imagepath"),
						rs.getString("summary")
						
						);
				allBookInfoList.add(bookInfo);
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allBookInfoList;
	}
	public ArrayList<AllBookInfo> listByAuthor(String author){
		allBookInfoList = new ArrayList<>();
		String sql = "SELECT * FROM allBookInfo WHERE author LIKE '%?%'";
		try (
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		   ) {
			pstmt.setString(1, author);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				AllBookInfo bookInfo = new AllBookInfo(
						rs.getInt("Book_id"),
						rs.getLong("ISBN"),
						rs.getString("loan_state"),
						rs.getString("KDC"),
						rs.getString("category_name"),
						rs.getString("author"),
						rs.getString("publisher"),
						rs.getDate("publication_date"),
						rs.getString("book_name"),
						rs.getString("imagepath"),
						rs.getString("summary")
						
						);
				allBookInfoList.add(bookInfo);
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allBookInfoList;
	}
	
	public ArrayList<AllBookInfo> listNewBook(){
		allBookInfoList = new ArrayList<>();
		String sql = "SELECT * FROM allBookInfo ORDER BY PUBLICATION_DATE DESC";
		try (
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		   ) {
			while(rs.next()) {
				AllBookInfo bookInfo = new AllBookInfo(
						rs.getInt("Book_id"),
						rs.getLong("ISBN"),
						rs.getString("loan_state"),
						rs.getString("KDC"),
						rs.getString("category_name"),
						rs.getString("author"),
						rs.getString("publisher"),
						rs.getDate("publication_date"),
						rs.getString("book_name"),
						rs.getString("imagepath"),
						rs.getString("summary")
						);
				allBookInfoList.add(bookInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allBookInfoList;
	}

}
