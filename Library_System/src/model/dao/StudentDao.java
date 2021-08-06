package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnector;
import model.dto.Student;


public class StudentDao {

	private static StudentDao instance;
	ArrayList<Student> studentList;
	
	private StudentDao() {}
	
	public static StudentDao getInstance() {
		if(instance == null) {
			instance = new StudentDao();
		}
		return instance;
	}

	public ArrayList<Student> listAllStudent(){
		String sql = "SELECT * FROM student";
		studentList = new ArrayList<>();

		try( 
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			){

			while (rs.next()) {
				studentList.add(new Student(
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


	public ArrayList<Student> listByStudentNum(int student_num) {
		String sql = "SELECT * FROM student WHERE student_num = ?";
		studentList = new ArrayList<>();

		try( 
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){

			pstmt.setInt(1, student_num);
			ResultSet rs = pstmt.executeQuery();					

			if(rs.next()) {
				studentList.add(new Student(
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
	
	public ArrayList<Student> listPasswordByStudentNum(int student_num) {
		String sql = "SELECT student_password FROM student WHERE student_num = ?";
		studentList = new ArrayList<>();

		try( 
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){

			pstmt.setInt(1, student_num);
			ResultSet rs = pstmt.executeQuery();					

			if(rs.next()) {
				studentList.add(new Student(
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
	

	public int insertStudent(int student_num, String student_ssn, String student_name,
			String student_address, String student_email, String student_phone) {
		String sql = "INSERT INTO student VALUES(?, ?, ?, '', ?, ?, ?)";
		int row = 0;
		
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
			
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	

	public int updateAddress(int student_num, String address) {
		String sql = "UPDATE student SET student_address = ? WHERE student_num = ?";
		int rows = 0;
		
		try( 
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			pstmt.setString(1, address);
			pstmt.setInt(2, student_num);
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return rows;
	}
	
	public int updateEmail(int student_num, String email) {
		String sql = "UPDATE student SET student_email = ? WHERE student_num = ?";
		int rows = 0;
		
		try( 
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			pstmt.setString(1, email);
			pstmt.setInt(2, student_num);
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return rows;
	}
	
	public int updateName(int student_num, String name) {
		String sql = "UPDATE student SET student_name = ? WHERE student_num = ?";
		int rows = 0;
		
		try( 
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			pstmt.setString(1, name);
			pstmt.setInt(2, student_num);
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return rows;
	}
	
	public int updatePhone(int student_num, String phone) {
		String sql = "UPDATE student SET student_phone = ? WHERE student_num = ?";
		int rows = 0;
		
		try( 
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			pstmt.setString(1, phone);
			pstmt.setInt(2, student_num);
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return rows;
	}
	public int updatePassword(int student_num, String password) {
		String sql = "UPDATE student SET student_password = ? WHERE student_num = ?";
		int rows = 0;
		
		try( 
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			pstmt.setString(1, password);
			pstmt.setInt(2, student_num);
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return rows;
	}

	public int deleteStudent(int student_num) {
		String sql = "DELETE FROM student WHERE student_num = ?";
		int rows = 0;
		
		try( 
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			pstmt.setInt(1, student_num);
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
}



