package view.login;

public class LoginHost { 
	private static String student_name;
	private static String student_num;
	private static String student_password;
	
	public static String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		LoginHost.student_name = student_name;
	}

	public static String getStudent_password() {
		return student_password;
	}
 
	public void setStudent_password(String student_password) {
		this.student_password = student_password;
	}

	public static String getStudent_num() {
		return student_num;
	}

	public void setStudent_num(String student_num) {
		this.student_num = student_num;
	}
}
