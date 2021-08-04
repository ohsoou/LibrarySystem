package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnector;


public class StudentDao {
	// 왜안돼나요 ㅠㅠ뉴뉸유뉴ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ
	ArrayList<StudentDto> studentList;
	String sql;
	int rows;
	int updateRows;
	int deleteRows;
	
	/*
 		[allList]
 		모든 학생의 정보를 불러온다.
	*/
	public ArrayList<StudentDto> allList(){
		sql = "SELECT * FROM student";
		studentList = new ArrayList<>();

		try( 
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			){

			while (rs.next()) {
				studentList.add(new StudentDto(
						rs.getInt("student_num"),
						rs.getString("student_ssn"),
						rs.getString("student_name"),
						rs.getString("student_password"),
						rs.getString("student_address"),
						rs.getString("student_email"),
						rs.getString("student_phone")
						));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentList;
	}

	/*
	 	[list]
	 	입력된 학번의 학생 정보를 불러온다.
	 	값이 없을때에 리턴값으로 NULL을 줘서 이 메소드로도 모든 학생의 정보를 불러올 수 있다.
	 */
	public ArrayList<StudentDto> list(int student_num) {
		sql = "SELECT * FROM student WHERE student_num = ?";
		studentList = new ArrayList<>();

		try( 
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){

			pstmt.setInt(1, student_num);
			ResultSet rs = pstmt.executeQuery();					

			if(rs.next()) {
				studentList.add(new StudentDto(
						rs.getInt("student_num"),
						rs.getString("student_ssn"),
						rs.getString("student_name"),
						rs.getString("student_password"),
						rs.getString("student_address"),
						rs.getString("student_email"),
						rs.getString("student_phone")));
			}else {
				studentList.add(null);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentList;
	}
	
	/*
	 	[insert]
	 	학생을 추가할 수 있는 메서드이다.
	 	추가가 잘 됬다면 1리턴 안됬을시 0리턴
	*/
	public int insert(int student_num, String student_ssn, String student_name,
			String student_address, String student_email, String student_phone) {
		sql = "INSERT INTO student VALUES(?, ?, ?, '', ?, ?, ?)";
		rows = 0;
		
		try( 
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			pstmt.setInt(1, student_num);
			pstmt.setString(2, student_ssn);
			pstmt.setString(3, student_name);
			pstmt.setString(4, student_address);
			pstmt.setString(5, student_email);
			pstmt.setString(6, student_phone);
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	/*
	  	[update]
	  	학번을 입력받은 학생의 정보를 수정할수있다.
	  	학번을 입력받은 학생의 수정할 컬럼명과 값을 매개변수로 받는다.
	  	추가가 잘 됬다면 1리턴 안됬을시 0리턴
	*/
	public int update(int student_num, String column, String value) {
		sql = "UPDATE student SET "+column+" = ? WHERE student_num = ?";
		updateRows = 0;
		
		try( 
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			
			if(column.equals("student_num")) {
				pstmt.setInt(1, Integer.parseInt(value));
				pstmt.setInt(2, student_num);	
			}else {
				pstmt.setString(1, value);
				pstmt.setInt(2, student_num);
			}
			
			updateRows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return updateRows;
	}
	
	/*
	 	[delete]
	 	학번을 입력받은 학생의 정보를 제거한다.
	 	삭제가 잘됬을시에 1리턴 안됬을때에 0리턴
	*/
	public int delete(int student_num) {
		sql = "DELETE FROM student WHERE student_num = ?";
		deleteRows = 0;
		
		try( 
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			pstmt.setInt(1, student_num);
			
			deleteRows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleteRows;
	}
}



