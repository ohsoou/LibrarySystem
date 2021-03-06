package view.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JPasswordField;

public class PwTextField extends JPasswordField{
	public PwTextField() {
		
		setText("비밀번호");
		Font lost = new Font("맑은 돋움",Font.ITALIC | Font.BOLD, 15);
		setFont(lost);
		setForeground(Color.gray);
		setEchoChar((char)0);
		addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				if(String.valueOf(getPassword()).equals("비밀번호")) {
					setText("");
					setEchoChar('*');
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				
				if(String.valueOf(getPassword()).equals("비밀번호")||String.valueOf(getPassword()).length()==0) {
					setText("비밀번호");
					setEchoChar((char)0);
					setForeground(Color.gray);
				}else {
					setEchoChar('*');
					setForeground(Color.BLACK);  
				}
			}
			
		}); 
		
		setPreferredSize(new Dimension(200,30));
	}
}
