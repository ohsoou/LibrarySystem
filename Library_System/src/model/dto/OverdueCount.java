package model.dto;

 

public class OverdueCount {
	
	private int student_num;
	private int overdue_count;
	
	public OverdueCount(int student_num, int overdue_count) {
		super();
		this.student_num=student_num;
		this.overdue_count = overdue_count;
	}

	public int getStudent_num() {
		return student_num;
	}
	public void setStudent_num(int student_num) {
		this.student_num = student_num;
	}
	 
	public int getTotal_overdue() {
		return overdue_count;
	}
	public void setTotal_overdue(int overdue_count) {
		this.overdue_count = overdue_count;
	}

	@Override
	public String toString() {
		return "OverdueCount [student_num=" + student_num + ", total_overdue=" + overdue_count + "]";
	}
	
}
