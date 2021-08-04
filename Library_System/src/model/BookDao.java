package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnector;

public class BookDao {
	static 	ArrayList<BookDto> BookList = new ArrayList<BookDto>();
	public static void main(String[] args) {

		String url ="jdbc:oracle:thin:@library_high?TNS_ADMIN=D:/Wallet_Library";
		String user = "admin";
		String password = "Spring3-----";
		
		String sql = "SELECT * FROM book";
		
		try {
			Connection conn 
				= DriverManager.getConnection(url,user,password);	
			
			PreparedStatement pstmt
				= conn.prepareStatement(sql);
			
			ResultSet rs 
			= pstmt.executeQuery();
			
			while(rs.next()) {
//				System.out.printf("%-10d %-15s %-8s \n",
//						rs.getInt("BOOK_ID"),
//						rs.getString("ISBN"),
//						rs.getString("LOAN_STATE"));
				
				int BOOK_ID = rs.getInt("BOOK_ID");
				String ISBN = rs.getString("ISBN");
				String LOAN_STATE = rs.getString("LOAN_STATE");
				
				BookDto BookDto = new BookDto(BOOK_ID, ISBN, LOAN_STATE);
				BookList.add(BookDto);
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