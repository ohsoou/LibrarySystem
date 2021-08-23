package view.advertising.details;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

import view.advertising.AdImageButton;
import view.advertising.AdvertisingFrame;
import view.login.LoginFrame;
import view.rental.UserSelection;

public class AdDetailsViewButton extends JButton implements ActionListener{
		
	JFrame maindf;
	String text;
	public AdDetailsViewButton(String text, JFrame maindf) {
		this.text = text;
		this.setText(text);
		this.maindf = maindf;
		
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setForeground(new Color(255, 95, 46));
		setBorder(new LineBorder(new Color(225, 238, 246)));
		setBackground(new Color(244, 240, 240));
		setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		setBounds(430, 300, 435, 170);
		setVisible(true);
		addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		JFrame df = (JFrame)btn.getRootPane().getParent();
		if(this.text.equals("´Ý±â")) {
			df.dispose();
		
		}else if(this.text.equals("´ë¿©")){
			UserSelection.addSelectedBook(AdDetailsView.BookList().get(0));
			new LoginFrame();
			
			df.dispose();
			maindf.dispose();
			
		}
		
		
	}
}
