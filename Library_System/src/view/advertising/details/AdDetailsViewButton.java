package view.advertising.details;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

import view.advertising.AdImageButton;

public class AdDetailsViewButton extends JButton implements ActionListener{
		
	String text;
	public AdDetailsViewButton(String text) {
		this.text = text;
		this.setText(text);
		
		setForeground(new Color(255, 95, 46));
		setBorder(new LineBorder(new Color(225, 238, 246)));
		setBackground(new Color(244, 240, 240));
		setFont(new Font("맑은 고딕", Font.BOLD, 25));
		setBounds(430, 300, 435, 170);
		setVisible(true);
		addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.text.equals("닫기")) {
			AdImageButton.details.dispose();
		}else if(this.text.equals("대여")){
			System.out.println("미정");
		}
		
		
	}
}
