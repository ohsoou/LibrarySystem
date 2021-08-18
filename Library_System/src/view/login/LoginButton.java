package view.login;

import java.awt.Color;
import java.awt.Font;

import view.defaultcomponent.DefaultButton;

public class LoginButton extends DefaultButton{
	public LoginButton() {
		super("Login");
		setFont(new Font("¸¼Àº °íµñ",Font.BOLD | Font.PLAIN, 15));
		setForeground(Color.WHITE);
		setBackground(new Color(255, 95, 46));
		
	} 
}
