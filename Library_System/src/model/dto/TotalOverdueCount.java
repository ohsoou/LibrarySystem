package model.dto;

 

public class TotalOverdueCount {
	
	private int student_num;
	private int total_overdue_period;
	
	public TotalOverdueCount(int student_num, int total_overdue_period) {
		super();
		this.student_num=student_num;
		this.total_overdue_period = total_overdue_period;
	}

	public int getStudent_num() {
		return student_num;
	}
	public void setStudent_num(int student_num) {
		this.student_num = student_num;
	}
	 
	public int getTotal_overdue() {
		return total_overdue_period;
	}
	public void setTotal_overdue(int total_overdue_period) {
		this.total_overdue_period = total_overdue_period;
	}

	@Override
	public String toString() {
		return "OverdueCount [student_num=" + student_num + ", total_overdue_period=" + total_overdue_period + "]";
	}
	
}
