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
						rs.getInt("ISBN"),
						rs.getString("loan_state"),
						rs.getString("KDC"),
						rs.getString("category_name"),
						rs.getString("author"),
						rs.getString("publisher"),
						rs.getDate("publication_date"),
						rs.getString("book_name"),
						rs.getString("imagepath"),
						rs.getString("sumary")
						
						);
				allBookInfoList.add(bookInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allBookInfoList;
	}

}
