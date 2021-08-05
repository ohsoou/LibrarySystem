package model;

 

public class OverdueCountDto {
	
	private int student_num;
	private int total_overdue;
	
	public OverdueCountDto(int student_num, int total_overdue) {
		super();
		this.student_num=student_num;
		this.total_overdue = total_overdue;
	}

	public int getStudent_num() {
		return student_num;
	}
	public void setStudent_num(int student_num) {
		this.student_num = student_num;
	}
	
	public int getTotal_overdue() {
		return total_overdue;
	}
	public void setTotal_overdue(int total_overdue) {
		this.total_overdue = total_overdue;
	}
	
	
}
