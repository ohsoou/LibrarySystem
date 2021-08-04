package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnector;

public class BookClassificationDao {
	private static Connection conn;
	static PreparedStatement pstmt;
	static ResultSet resultset;
	ArrayList<BookClassificationDto> categoryList;
	static String sql;
	
	public BookClassificationDao() {
		try {
			conn = DBConnector.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BookClassificationDto> allList(){
		categoryList = new ArrayList();
		sql = "SELECT * FROM BookClassification";
		try {
			pstmt = conn.prepareStatement(sql);
			resultset = pstmt.executeQuery();
			
			while(resultset.next()) {				
				BookClassificationDto category = new BookClassificationDto(
						resultset.getString("KDC"),
						resultset.getString("category_name"));
				categoryList.add(category);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList;
	}
	
	public ArrayList<BookClassificationDto> KDCSearch(String KDC){
		sql = "SELECT * FROM BookClassification WHERE KDC = ?";
		categoryList = new ArrayList();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, KDC);
			resultset = pstmt.executeQuery();
			
			while(resultset.next()) {
				BookClassificationDto category = new BookClassificationDto(
						resultset.getString("KDC"),
						resultset.getString("category_name"));
				categoryList.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList;
	}
	
	public ArrayList<BookClassificationDto> cNameSearch(String category_name){
		sql = "SELECT * FROM BookClassification WHERE category_name = ?";
		categoryList = new ArrayList();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category_name);
			resultset = pstmt.executeQuery();
			
			while(resultset.next()) {
				BookClassificationDto category = new BookClassificationDto(
						resultset.getString("KDC"),
						resultset.getString("category_name"));
				categoryList.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList;
	}
}
