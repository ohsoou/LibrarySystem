package view.login;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class LoginTitleLable extends JLabel{
	public LoginTitleLable() {
		super("로그인 해주세요",CENTER);
		setFont(new Font("맑은 고딕",Font.BOLD | Font.PLAIN,25));
		setForeground(new Color(0, 78, 102));
	}
}
