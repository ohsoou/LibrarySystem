package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import db.DBConnector;
/*
 auto close로 바꾸고 다른 사람 코드보면서 코드 통일성 맞추기
update문 -> 반납해서 returndate 입력/ 연장해서 extend 입력
insert할때 loan num 시퀀스 값으로 들어가야함
 */
public class LoanDao {

	
	String sql;
	int rs = 0;
	
	//모두 조회
	public ArrayList<LoanDto> listAll() {
		sql = "SELECT * FROM loan";
		ArrayList<LoanDto> loanList = new ArrayList<>();
		

		try( 
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			){

			while (rs.next()) {
				loanList.add(new LoanDto(
						rs.getInt("loan_num"),
						rs.getInt("student_num"),
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
	
	//조회
	public ArrayList<LoanDto> list()  {
		ArrayList<LoanDto> loanList = new ArrayList<>();
		sql = "SELECT FROM loan WHERE lona_num = ?";
		
		try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				)
		{
			
			while (rs.next()) {
				loanList.add(new LoanDto(
						rs.getInt("loan_num"),
						rs.getInt("student_num"),
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
	
	// 추가 ---- 시퀀스 추가 넣어봤는데 이렇게 하는게 맞는지 잘 모르겠네요ㅠㅠ 확인부탁드립니다.
	public int insert(int loan_num, int student_num, int book_id, Date loan_date, Date return_date, int extend) {
		sql = "INSERT INTO loan VALUES(?, ?, ?, ?, ?, ?)";
		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			 ){
			StringBuilder seq = new StringBuilder();
			seq.append("INSERT INTO LOAN_NUM_SEQ(loan_num)");
			pstmt.setInt(2, student_num);
			pstmt.setInt(3, book_id);
			pstmt.setDate(4, (java.sql.Date) loan_date);
			pstmt.setDate(5, (java.sql.Date) return_date);
			pstmt.setInt(6, extend);
			
			
			rs = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	
	//수정
	public int update(int loan_num, String column, String value) {
		sql = "UPDATE loan SET " + column + "= ? WHERE loan_num = ?";
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd");
		Date date = new Date();
		try(
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			
			if(column.equals("loan_num")) {
				pstmt.setString(5, format.format(date));
			}
			
			rs = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	
	//삭제
	public int delete(int loan_num) {
		sql = "DELETE FROM loan WHERE loan_num = ?";
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			pstmt.setInt(1, loan_num);
			
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	
	}
	
	
	}
