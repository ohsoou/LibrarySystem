package view.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;

public class idTextField extends JTextField{
	public idTextField() {
		
		setText("¾ÆÀÌµð");
		
		Font origin = new Font("¸¼Àº µ¸¿ò",Font.BOLD, 15);
		Font lost = new Font("¸¼Àº µ¸¿ò",Font.ITALIC | Font.BOLD, 15);
		
		setFont(lost);
		setForeground(Color.gray);
		
		this.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(getText().equals("¾ÆÀÌµð")) {
					setText("");
					setFont(origin);
				}else {
					setText(getText());
					setFont(origin);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				 if (getText().equals("¾ÆÀÌµð")|| getText().length()==0) {  
			          setText("¾ÆÀÌµð");  
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
