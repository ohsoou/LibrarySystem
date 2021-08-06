package view.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;

public class idTextField extends JTextField{
	public idTextField() {
		
		setText("���̵�");
		
		Font origin = new Font("���� ����",Font.BOLD, 15);
		Font lost = new Font("���� ����",Font.ITALIC | Font.BOLD, 15);
		
		setFont(lost);
		setForeground(Color.gray);
		
		this.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(getText().equals("���̵�")) {
					setText("");
					setFont(origin);
				}else {
					setText(getText());
					setFont(origin);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				 if (getText().equals("���̵�")|| getText().length()==0) {  
			          setText("���̵�");  
			          setFont(lost);  
			          setForeground(Color.GRAY);  
			        } else {  
			          setText(getText());  
			          setFont(origin);  
			          setForeground(Color.BLACK);  

			        }  

			      }  
		});
		
		setPreferredSize(new Dimension(200,30));
	}
}
