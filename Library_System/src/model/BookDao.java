package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnector;

public class BookDao {
	
	ArrayList<BookDto> overdueCountList = new ArrayList<BookDto>();
	public static void main(String[] args) {
		
		String sql = "SELECT * FROM BOOK";
		
		try {
			Connection conn 
				= DBConnector.getConnection();		
			PreparedStatement pstmt
				= conn.prepareStatement(sql);
			ResultSet rs 
			= pstmt.executeQuery();
			
			while(rs.next()) {
				int BOOK_ID = rs.getInt("BOOK_ID");
				String ISBN = rs.getString("ISBN");
				String LOAN_STATE = rs.getString("LOAN_STATE");		
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("main ³¡");
}
}