package view.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.defaultcomponent.DefaultPanel;
import view.login.LoginFrame;

public class TopPanel extends DefaultPanel{
	
	/*
	 	[TopPanel]
	 	메인 페널에 상단부분이며 컴포넌트로는 뒤로가기 버튼 하나를 가지고 있습니다.
	*/
	int x = 50;
	int y = 50;
	int width = 50;
	int height = 50;
	String image = "./image/componentImg/prev_arrow_btn.png";
	
	public TopPanel() {
		
		MainButton btn = new MainButton(image,50,50);
		setLayout(null);
		btn.setBounds(x,y,width,height);
		btn.addActionListener(new backButtonListener());
		
		JLabel title = new MainTitleLabel();
		
		title.setBounds(x + 145, y - 25, 600, 90);
		add(btn);
		add(title);
		
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
