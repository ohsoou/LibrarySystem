package view.login;

public class LoginHost { 
	private static String student_num;
	private static String student_password;
	
	public static String getStudent_password() {
		return student_password;
	}
 
	public static void setStudent_password(String student_password) {
		LoginHost.student_password = student_password;
	}

	public static String getStudent_num() {
		return student_num;
	}

	public static void setStudent_num(String student_num) {
		LoginHost.student_num = student_num;
	}
}
