package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnector;

public class OverdueCountDao {
	private Connection conn;
	PreparedStatement pstmt = null;
	ResultSet resultset = null;
	String sql;
	
	    public OverdueCountDao() throws ClassNotFoundException, SQLException {    
	    	conn = DBConnector.getConnection();
	    }
	    
	    public ArrayList<OverdueCountDto> list() throws SQLException{
	    	
	    	ArrayList<OverdueCountDto> overdueCountList = new ArrayList<OverdueCountDto>();
	    	String sql = "SELECT * FROM overdue_count";
	    	
	    	pstmt = conn.prepareStatement(sql);
	    	resultset = pstmt.executeQuery();
	    	
	    	while(resultset.next()) {
	    		int student_num = resultset.getInt("student_num");
	    		int total_overdue = resultset.getInt("total_overdue");
	    		
	    		OverdueCountDto overdueCountDto = new OverdueCountDto(student_num,total_overdue);
	    		
	    		overdueCountList.add(overdueCountDto);
	    		
	    		pstmt.close();
	    		conn.close();
	    		resultset.close();
	    		}
			return overdueCountList;
	    }
	    
	
}
