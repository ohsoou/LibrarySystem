package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import db.DBConnector;
import model.dto.Loan;

public class LoanDao {
	private static LoanDao instance;

	ArrayList<Loan> loanList;
	
	private LoanDao() {}
	
	public static LoanDao getInstance() {
		if(instance == null) {
			instance = new LoanDao();
		}
		return instance;
	}

	
	public ArrayList<Loan> listAllLoan() {
		String sql = "SELECT * FROM loan";
		loanList = new ArrayList<>();
		

		try( 
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			){

			while (rs.next()) {
				loanList.add(new Loan(
						rs.getInt("loan_num"),
						rs.getString("student_num"),
						rs.getInt("book_id"),
						rs.getDate("loan_date"),
						rs.getDate("return_date"),
						rs.getInt("extend")
						));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loanList;
	}
	
	// listByLoanNum�� �Ű������� �޵��� �����߽��ϴ�
		public ArrayList<Loan> listByLoanNum(int loan_num)  {
			loanList = new ArrayList<>();
			String sql = "SELECT * FROM loan "
					+ "WHERE loan_num = ?";
			
			try (
					Connection conn = DBConnector.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);
					
					){
				
				pstmt.setInt(1, loan_num);
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					loanList.add(new Loan(
							rs.getInt("loan_num"),
							rs.getString("student_num"),
							rs.getInt("book_id"),
							rs.getDate("loan_date"),
							rs.getDate("return_date"),
							rs.getInt("extend")
							));
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return loanList;	
		}
	
	// add list	
	public ArrayList<Loan> listByStudentNum(String studentNum)  {
		loanList = new ArrayList<>();
		String sql = "SELECT * FROM loan JOIN allbookinfo "
				+ "USING(book_id) WHERE student_num = ?";
		
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			
			pstmt.setString(1,studentNum);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				loanList.add(new Loan(
						rs.getInt("loan_num"),
						rs.getString("student_num"),
						rs.getString("book_name"),
						rs.getDate("loan_date"),
						rs.getDate("return_date"),
						rs.getInt("extend")
						));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loanList;
		
	}
	
	public int insertLoan(int loan_num, int student_num, int book_id, Date loan_date, Date return_date, int extend) {
		String sql = "INSERT INTO loan(loan_num, student_num, book_id, loan_date, return_date, extend)"
				+ " VALUES(LOAN_NUM_SEQ.nextval, ?, ?, ?, ?, ?)";
		int row = 0;
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			 ){
			
			pstmt.setInt(1, student_num);
			pstmt.setInt(2, book_id);
			pstmt.setDate(3, (java.sql.Date) loan_date);
			pstmt.setDate(4, (java.sql.Date) return_date);
			pstmt.setInt(5, extend);
			
			
			row = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
		
	}
	
	public int updateReturnDate(int loan_num) {
		String sql = "UPDATE loan SET return_date = ? WHERE loan_num = ?";
		int rows = 0;
		
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		try(
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			pstmt.setString(1, format.format(date));
			pstmt.setInt(2, loan_num);
			
			rows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public int updateExtend(int loan_num) {
		String sql = "UPDATE loan SET extend = extend + 1 WHERE loan_num = ?";
		int rows = 0;
		
		try(
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
			){
			pstmt.setInt(1, loan_num);
			rows = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	public int deleteLoan(int loan_num) {
		String sql = "DELETE FROM loan WHERE loan_num = ?";
		int rows = 0;
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			pstmt.setInt(1, loan_num);
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	
	}
	
	
	}
