package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Overdue_dao {
	private Connection conn;
	PreparedStatement pstmt = null;
	ResultSet resultset = null;
	
	    public Overdue_dao() throws ClassNotFoundException, SQLException {    
	        conn = new DBConnector().getConnection();
	    }
	    
	    public ArrayList<Overdue_dto> getAllInfo() throws SQLException{
	    	
	    	ArrayList<Overdue_dto> read = new ArrayList<Overdue_dto>();
	    	String sql = "CREATE OR REPLACE VIEW overdue "
	    			+ "AS SELECT loan_num, student_num, book_id "
	    			+ "FROM loan "
	    			+ "WHERE TRUNC(SYSDATE) - TRUNC(loan_date + 10  + "
	    			+ "(10 * extend))  < 0 WITH READ ONLY";
	    	pstmt = conn.prepareStatement(sql);
	    	
	    	resultset = pstmt.executeQuery();
	    	
	    	while(resultset.next()) {
	    		int loan_num = resultset.getInt("loan_num");
	    		int book_id = resultset.getInt("book_id");
	    		int student_num = resultset.getInt("student_num");
	    		
	    		Overdue_dto loan = new Overdue_dto(loan_num,book_id,student_num);
	    		
	    		read.add(loan);

	    		}
			return read;
	    }
	    
}
