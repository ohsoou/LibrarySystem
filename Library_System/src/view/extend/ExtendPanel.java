package view.extend;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.defaultcomponent.DefaultPanel;
import view.login.LoginHost;
import view.main.MainFrame;


public class ExtendPanel extends DefaultPanel{
	int x=50, y=50, width=50, height =50;
	String image = "./image/componentImg/prev_arrow_btn.png";
	ImageIcon icon = new ImageIcon(image);
	JButton prevBtn;
	
	public ExtendPanel() {
		prevBtn = new JButton();
		prevBtn.setIcon(icon);
		setLayout(null);
	
		//prevBtn을 평면처럼 보이게
		prevBtn.setFocusPainted(false);
		prevBtn.setContentAreaFilled(false);
		prevBtn.setBorderPainted(false);
		 
		prevBtn.setBounds(x,y,width,height);
		prevBtn.addActionListener(new backButtonListener());
		prevBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JLabel title = new ExtendTitleLabel(LoginHost.getStudent_name()+"님의 연장 페이지");
		JPanel extendTable = new ExtendTable();
		
		title.setBounds(x + 145, y - 25, 600, 90);
		extendTable.setBounds(x+80, y+100, 700, 500);
		add(prevBtn);
		add(title);
		add(extendTable);
		
		setBackground(new Color(225, 238, 246));
		setBounds(0,0,980,700);
		setVisible(true);	
	
	}
	
	private class backButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame df = (JFrame)((JButton)e.getSource()).getRootPane().getParent();
			df.dispose();
			
			//Main Page
			new MainFrame();
		}
	}
} 
