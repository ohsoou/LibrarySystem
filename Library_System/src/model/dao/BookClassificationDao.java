package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnector;
import model.dto.BookClassification;

public class BookClassificationDao {
	private static BookClassificationDao instance;
	ArrayList<BookClassification> categoryList;
	
	private BookClassificationDao() {}
	
	public static BookClassificationDao getInstance() {
		if(instance == null) {
			instance = new BookClassificationDao();
		}
		return instance;
	}
	
	public ArrayList<BookClassification> listAllBookClassification(){
		categoryList = new ArrayList<>();
		String sql = "SELECT * FROM BookClassification";
		try(
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet resultset = pstmt.executeQuery();
		   ){
			while(resultset.next()) {				
				BookClassification category = new BookClassification(
						resultset.getString("KDC"),
						resultset.getString("category_name")
						);
				categoryList.add(category);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList;
	}
	
	public ArrayList<BookClassification> listByKDC(String KDC){
		categoryList = new ArrayList<>();
		String sql = "SELECT * FROM BookClassification WHERE KDC = ?";
		
		try(
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		   ){
			
			pstmt.setString(1, KDC);
			ResultSet resultset = pstmt.executeQuery();
			
			while(resultset.next()) {
				BookClassification category = new BookClassification(
						resultset.getString("KDC"),
						resultset.getString("category_name")
						);
				categoryList.add(category);
			}
			resultset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList;
	}
	
	public ArrayList<BookClassification> listByCategoryName(String category_name){
		String sql = "SELECT * FROM BookClassification WHERE category_name = ?";
		categoryList = new ArrayList<>();
		
		try(
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
		   ) {
			
			pstmt.setString(1, category_name);
			ResultSet resultset = pstmt.executeQuery();
			
			while(resultset.next()) {
				BookClassification category = new BookClassification(
						resultset.getString("KDC"),
						resultset.getString("category_name")
						);
				categoryList.add(category);
			}
			resultset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList;
	}
}