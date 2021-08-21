package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnector;
import model.dto.OverdueCount;

public class OverdueCountDao {
	private static OverdueCountDao instance;
	ArrayList<OverdueCount> overdueCountList;
	
	private OverdueCountDao() {}
	
	public static OverdueCountDao getInstance() {
		if(instance == null) {
			instance = new OverdueCountDao();
		}
		return instance;
	} 
	public ArrayList<OverdueCount> listAllOverdueCount() {

		overdueCountList = new ArrayList<OverdueCount>();
		String sql = "SELECT * FROM overdue_count";

		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			) 
		{
			while (rs.next()) {
				int student_num = rs.getInt("student_num");
				int overdue_count = rs.getInt("overdue_count");

				OverdueCount overdueCountDto = new OverdueCount(student_num, overdue_count);

				overdueCountList.add(overdueCountDto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return overdueCountList;
	}

}
