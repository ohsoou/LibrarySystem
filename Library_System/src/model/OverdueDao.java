package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnector;

public class OverdueDao {
	    
	public ArrayList<OverdueDto> list() throws SQLException {

		ArrayList<OverdueDto> overdueList = new ArrayList<OverdueDto>();
		String sql = "SELECT * FROM overdue";

		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			) 
		{
			while (rs.next()) {
				int loan_num = rs.getInt("loan_num");
				int student_num = rs.getInt("student_num");
				int book_id = rs.getInt("book_id");
				int overdue_period = rs.getInt("overdue_period");

				OverdueDto loan = new OverdueDto(loan_num, book_id, student_num, overdue_period);

				overdueList.add(loan);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return overdueList;

	}
	   
}
