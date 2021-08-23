package view.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JPasswordField;

public class PwTextField extends JPasswordField{
	public PwTextField() {
		
		setText("��й�ȣ");
		Font lost = new Font("���� ����",Font.ITALIC | Font.BOLD, 15);
		setFont(lost);
		setForeground(Color.gray);
		setEchoChar((char)0);
		addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				if(String.valueOf(getPassword()).equals("��й�ȣ")) {
					setText("");
					setEchoChar('*');
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				
				if(String.valueOf(getPassword()).equals("��й�ȣ")||String.valueOf(getPassword()).length()==0) {
					setText("��й�ȣ");
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
