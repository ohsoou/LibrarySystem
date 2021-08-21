package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnector;
import model.dto.TotalOverdueCount;

public class TotalOverdueCountDao {
	private static TotalOverdueCountDao instance;
	ArrayList<TotalOverdueCount> overdueCountList;
	
	private TotalOverdueCountDao() {}
	
	public static TotalOverdueCountDao getInstance() {
		if(instance == null) {
			instance = new TotalOverdueCountDao();
		}
		return instance;
	} 
	public ArrayList<TotalOverdueCount> listAllOverdueCount() {

		overdueCountList = new ArrayList<TotalOverdueCount>();
		String sql = "SELECT * FROM total_overdue_period";

		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			) 
		{
			while (rs.next()) {
				int student_num = rs.getInt("student_num");
				int overdue_count = rs.getInt("total_overdue_period");

				TotalOverdueCount overdueCountDto = new TotalOverdueCount(student_num, overdue_count);

				overdueCountList.add(overdueCountDto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return overdueCountList;
	}

}
