package view.advertising;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.defaultcomponent.DefaultButton;
import view.defaultcomponent.DefaultPanel;
import view.login.LoginFrame;

	/*
	 	[AdTopPanel]
	 	로그인 버튼이있는 상단 페널.
	 */
public class AdTopPanel extends DefaultPanel{

	public static JLabel newTitle;
	public static JLabel suggestTitle;
	public AdTopPanel() {
		int x = 50;
		int y = 25;
		int width = 100;
		int height = 35;
		
		setLayout(null);
		
		JButton btn = new DefaultButton("Login",100,50);
		btn.setBounds(x,y,width,height);
		btn.addActionListener(new nextLoginPageListener());

		newTitle = new AdTitleLabel(true);
		suggestTitle = new AdTitleLabel(false);
		
		suggestTitle.setVisible(false);
		add(newTitle);
		add(suggestTitle);
		add(btn);		
		setBounds(0,0,980,90);
	}
	
	private class nextLoginPageListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame df = (JFrame) ((JButton) e.getSource()).getRootPane().getParent();
			new LoginFrame();

			df.dispose();

		}
	}

}
