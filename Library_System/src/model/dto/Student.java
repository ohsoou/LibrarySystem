package model.dto;

public class Student {
	// 왜 안돼 ㅠㅠㅠㅠㅠㅠ
	private int student_num;
	private String student_ssn;
	private String student_name;
	private String student_password;
	private String student_address;
	private String student_email;
	private String student_phone;
	
	public Student(int student_num, String student_ssn, String student_name, String student_password,
			String student_address, String student_email, String student_phone) {
		super();
		this.student_num = student_num;
		this.student_ssn = student_ssn;
		this.student_name = student_name;
		this.student_password = student_password;
		this.student_address = student_address;
		this.student_email = student_email;
		this.student_phone = student_phone;
	}
	public int getStudent_num() {
		return student_num;
	}
	public void setStudent_num(int student_num) {
		this.student_num = student_num;
	}
	public String getStudent__ssn() {
		return student_ssn;
	}
	public void setStudent__ssn(String student__ssn) {
		this.student_ssn = student__ssn;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_password() {
		return student_password;
	}
	public void setStudent_password(String student_password) {
		this.student_password = student_password;
	}
	public String getStudent_adrress() {
		return student_address;
	}
	public void setStudent_adrress(String student_adrress) {
		this.student_address = student_adrress;
	}
	public String getStudent_email() {
		return student_email;
	}
	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}
	public String getStudent_phone() {
		return student_phone;
	}
	public void setStudent_phone(String student_phone) {
		this.student_phone = student_phone;
	}
	@Override
	public String toString() {
		return "Student [student_num=" + student_num + ", student_ssn=" + student_ssn + ", student_name=" + student_name
				+ ", student_password=" + student_password + ", student_address=" + student_address + ", student_email="
				+ student_email + ", student_phone=" + student_phone + "]";
	}
}
