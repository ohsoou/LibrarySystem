package view.advertising;

import javax.swing.JButton;

import view.component.DefaultButton;
import view.component.DefaultPanel;

	/*
	 	[AdTopPanel]
	 	로그인 버튼이있는 상단 페널.
	 */
public class AdTopPanel extends DefaultPanel{

	int x = 50;
	int y = 25;
	int width = 100;
	int height = 35;
	
	public AdTopPanel() {
		JButton btn = new DefaultButton("Login",100,50);
		setLayout(null);
		btn.setBounds(x,y,width,height);
		
		add(btn);
		setBounds(0,0,980,100);
	}
}
