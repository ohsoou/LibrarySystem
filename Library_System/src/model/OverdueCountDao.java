package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnector;

public class OverdueCountDao {
	public ArrayList<OverdueCountDto> list() {

		ArrayList<OverdueCountDto> overdueCountList = new ArrayList<OverdueCountDto>();
		String sql = "SELECT * FROM overdue_count";

		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			) 
		{
			while (rs.next()) {
				int student_num = rs.getInt("student_num");
				int total_overdue = rs.getInt("total_overdue");

				OverdueCountDto overdueCountDto = new OverdueCountDto(student_num, total_overdue);

				overdueCountList.add(overdueCountDto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return overdueCountList;
	}

}
