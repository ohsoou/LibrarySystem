package view.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import view.component.DefaultPanel;
import view.login.LoginFrame;

public class TopPanel extends DefaultPanel{
	
	/*
	 	[TopPanel]
	 	���� ��ο� ��ܺκ��̸� ������Ʈ�δ� �ڷΰ��� ��ư �ϳ��� ������ �ֽ��ϴ�.
	*/
	int x = 50;
	int y = 50;
	int width = 50;
	int height = 50;
	String image = "./image/componentImg/main_btn_04.png";
	
	public TopPanel() {
		
		MainButton btn = new MainButton(image,50,50);
		setLayout(null);
		btn.setBounds(x,y,width,height);
		btn.addActionListener(new backButtonListener());
		
		add(btn);
		
		setBackground(new Color(0xe1eef6));
		setBounds(0,0,980,100);
		setVisible(true);		
	}
	
	private class backButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame df = (JFrame)((JButton)e.getSource()).getRootPane().getParent();
			df.dispose();
			
			new LoginFrame();
			
			//TODO- logout
			
		}
	}
}
