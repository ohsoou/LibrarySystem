package view.advertising;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.defaultcomponent.DefaultButton;
import view.defaultcomponent.DefaultPanel;
import view.login.LoginFrame;

	/*
	 	[AdTopPanel]
	 	�α��� ��ư���ִ� ��� ���.
	 */
public class AdTopPanel extends DefaultPanel{

	public static JLabel newTitle;
	public static JLabel suggestTitle;
	public AdTopPanel() {
		
		setLayout(new FlowLayout(FlowLayout.LEFT, 100, 20));
		setPreferredSize(new Dimension(980,90));
		
		JButton btn = new DefaultButton("Login",100,40);
		btn.addActionListener(new nextLoginPageListener());
		JPanel con = new DefaultPanel();

		con.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		con.setPreferredSize(new Dimension(400,60));
		
		newTitle = new AdTitleLabel(true);
		suggestTitle = new AdTitleLabel(false);
		suggestTitle.setVisible(false);
		
		JLabel subTitle = new JLabel("�����Ͻø� �α��� �� �ٷ� �뿩�Ͻ� �� �ֽ��ϴ�.");
		subTitle.setForeground(new Color(0, 78, 102));
		subTitle.setFont(new Font("���� ���", Font.PLAIN, 15));
		subTitle.setHorizontalAlignment(JLabel.CENTER);
		subTitle.setPreferredSize(new Dimension(700,20));
		
		con.add(newTitle);
		con.add(suggestTitle);
		con.add(subTitle);

		add(btn);	
		add(con);
		
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
