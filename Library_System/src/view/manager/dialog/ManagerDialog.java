package view.manager.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ManagerDialog extends JDialog{
	public ManagerDialog(JFrame frame, String title) {
		super(frame, title);
		this.setLocation(100, 100);
		getContentPane().setBackground(new Color(244,240,240));
		
		setLayout(new BorderLayout());
		JLabel pageTitle = new JLabel(title);
		pageTitle.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		
		add(pageTitle, "North");
		
		JPanel center = new JPanel();
		center.setBackground(new Color(244,240,240));
		center.setLayout(new FlowLayout());
		center.add(new FormPanel());
		center.add(new FilePanel());
		add(center, "Center");
		
		JPanel bottom = new ButtonPanel();
		add(bottom, "South");

		setSize(730, 530);
	
	}
	
	

}
