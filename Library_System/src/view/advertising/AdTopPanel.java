package view.advertising;

import javax.swing.JButton;

import view.component.DefaultButton;
import view.component.DefaultPanel;

	/*
	 	[AdTopPanel]
	 	�α��� ��ư���ִ� ��� ���.
	 */
public class AdTopPanel extends DefaultPanel{

	JButton btn;
	public AdTopPanel() {
		int x = 50;
		int y = 25;
		int width = 100;
		int height = 35;
		btn = new DefaultButton("Login",100,50);
		setLayout(null);
		btn.setBounds(x,y,width,height);
		
		add(btn);
		setBounds(0,0,980,90);
	}

}
