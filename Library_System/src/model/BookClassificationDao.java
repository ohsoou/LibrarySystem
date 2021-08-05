package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnector;

public class BookClassificationDao {
	ArrayList<BookClassificationDto> categoryList;
	static String sql;
	
	public ArrayList<BookClassificationDto> listAll(){
		
		categoryList = new ArrayList();
		String sql = "SELECT * FROM BookClassification";
		try(
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		   ){
			ResultSet resultset = pstmt.executeQuery();
			
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
	
	public ArrayList<BookClassificationDto> listByKDC(String KDC){
		String sql = "SELECT * FROM BookClassification WHERE KDC = ?";
		categoryList = new ArrayList();
		
		try(
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		   ){
			
			pstmt.setString(1, KDC);
			ResultSet resultset = pstmt.executeQuery();
			
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
	
	public ArrayList<BookClassificationDto> listByCategoryName(String category_name){
		String sql = "SELECT * FROM BookClassification WHERE category_name = ?";
		categoryList = new ArrayList();
		
		try(
				Connection	conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
		   ) {
			
			pstmt.setString(1, category_name);
			ResultSet resultset = pstmt.executeQuery();
			
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