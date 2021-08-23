package view.rental.rentalEndPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

import view.login.LoginHost;

public class EndpageLabel extends JLabel{
	
	
	public EndpageLabel() {
		super(LoginHost.getStudent_name()+"님,도서 대여가 완료되었습니다.");//
		setFont(new Font("맑은 고딕", Font.BOLD, 35));
		setForeground(new Color(0, 78, 102));
		setHorizontalAlignment(CENTER);
		setPreferredSize(new Dimension(800, 120));
	}
}
