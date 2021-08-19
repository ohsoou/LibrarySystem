package view.advertising;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import view.defaultcomponent.DefaultButton;
import view.defaultcomponent.DefaultPanel;
import view.login.LoginFrame;

	/*
	 	[AdTopPanel]
	 	로그인 버튼이있는 상단 페널.
	 */
public class AdTopPanel extends DefaultPanel{

	JButton btn;
	public AdTopPanel() {
		int x = 50;
		int y = 25;
		int width = 100;
		int height = 35;
		
		setLayout(null);
		
		btn = new DefaultButton("Login",100,50);
		btn.setBounds(x,y,width,height);
		btn.addActionListener(new nextLoginPageListener());
		
		add(btn);
		setBounds(0,0,980,90);
	}
	
	private class nextLoginPageListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame df = (JFrame)((JButton)e.getSource()).getRootPane().getParent();
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				}
			});
			
			df.dispose();
			
		}
	}

}
