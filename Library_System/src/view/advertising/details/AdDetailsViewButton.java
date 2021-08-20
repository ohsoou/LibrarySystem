package view.advertising.details;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import view.advertising.AdImageButton;
import view.advertising.AdvertisingFrame;
import view.login.LoginFrame;
import view.rental.UserSelection;

public class AdDetailsViewButton extends JButton implements ActionListener{
		
	String text;
	public AdDetailsViewButton(String text) {
		this.text = text;
		this.setText(text);
		
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setForeground(new Color(255, 95, 46));
		setBorder(new LineBorder(new Color(225, 238, 246)));
		setBackground(new Color(244, 240, 240));
		setFont(new Font("���� ���", Font.BOLD, 25));
		setBounds(430, 300, 435, 170);
		setVisible(true);
		addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.text.equals("�ݱ�")) {
			AdImageButton.details.dispose();
		
		}else if(this.text.equals("�뿩")){
			UserSelection.addSelectedBook(AdDetailsView.BookList().get(0));
			
			AdImageButton.details.dispose();
			AdvertisingFrame.frame.dispose();
			new LoginFrame();
		}
		
		
	}
}
