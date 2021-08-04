package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OverdueCountDao {
	private Connection conn;
	PreparedStatement pstmt = null;
	ResultSet resultset = null;
	
	    public OverdueCountDao() throws ClassNotFoundException, SQLException {    
	    	conn = DBConnector.getConnection();
	    }
	    
	    public ArrayList<OverdueCountDto> getAllInfo() throws SQLException{
	    	
	    	ArrayList<OverdueCountDto> read_count = new ArrayList<OverdueCountDto>();
	    	String sql = "CREATE OR REPLACE VIEW overdue_count "
	    			+ "AS SELECT student_num, COUNT(*) AS total_overdue "
	    			+ "FROM overdue "
	    			+ "GROUP BY student_num";
	    	pstmt = conn.prepareStatement(sql);
	    	
	    	resultset = pstmt.executeQuery();
	    	
	    	while(resultset.next()) {
	    		int loan_num = resultset.getInt("loan_num");
	    		int student_num = resultset.getInt("student_num");
	    		int book_id = resultset.getInt("book_id");
	    		
	    		OverdueCountDto loan_counter = new OverdueCountDto(loan_num, student_num,book_id);
	    		
	    		read_count.add(loan_counter);

	    		}
			return read_count;
	    }
	    
	
}
