package view.main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import view.defaultcomponent.DefaultPanel;
import view.login.LoginFrame;
import view.login.LoginHost;

public class TopPanel extends DefaultPanel{
	
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
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.setBorder(new LineBorder(new Color(0xe1eef6)));
		JLabel title = new MainTitleLabel("");
		
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
			LoginHost.setStudent_name(null);
			LoginHost.setStudent_num(null);
			LoginHost.setStudent_password(null);
			new LoginFrame();
		}
	}
}
