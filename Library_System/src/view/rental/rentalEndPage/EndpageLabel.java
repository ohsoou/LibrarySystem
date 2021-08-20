package view.rental.rentalEndPage;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;

import model.dao.StudentDao;
import model.dto.Student;
import view.login.LoginHost;

public class EndpageLabel extends JLabel{
	
	
	public EndpageLabel() {
		super(studentName()+"��,���� �뿩�� �Ϸ�Ǿ����ϴ�.");//
		setFont(new Font("�ü�ü", Font.BOLD, 35));
		setForeground(new Color(0, 78, 102));
		setBounds(160, 80, 800, 120);
	}
	
		private static String studentName() {
			String name;
			StudentDao studentName = StudentDao.getInstance();
			ArrayList<Student> names = studentName.listByStudentNum(LoginHost.getStudent_num());
			name = names.get(0).getStudent_name();
			return name;
		}
}
