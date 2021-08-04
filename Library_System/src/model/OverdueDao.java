package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnector;

public class OverdueDao {
	private Connection conn;
	PreparedStatement pstmt = null;
	ResultSet resultset = null;
	String sql;
	
	    public OverdueDao() throws ClassNotFoundException, SQLException {    
	        conn = DBConnector.getConnection();
	    }
	    
	    public ArrayList<OverdueDto> list() throws SQLException{
	    	
	    	ArrayList<OverdueDto> overdueList = new ArrayList<OverdueDto>();
	    		sql = "SELECT * FROM overdue";
	    	
	    	pstmt = conn.prepareStatement(sql);
	    	resultset = pstmt.executeQuery();
	    	
	    	while(resultset.next()) {
	    		int loan_num = resultset.getInt("loan_num");
	    		int student_num = resultset.getInt("student_num");
	    		int book_id = resultset.getInt("book_id");
	    		
	    		OverdueDto loan = new OverdueDto(loan_num,book_id,student_num);
	    		 
	    		overdueList.add(loan);
	    		
	    		pstmt.close();
	    		conn.close();
	    		resultset.close();
	    		}
			return overdueList;
		
	    }
	   
}
