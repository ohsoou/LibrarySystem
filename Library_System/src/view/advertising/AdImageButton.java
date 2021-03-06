package view.advertising;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import view.advertising.details.AdDetailsView;
	/*
	 	[AdImageButton]
	 	버튼에 들어갈 이미지와 텍스트 사이즈를 조정해주는 클래스.
	 */
public class AdImageButton extends JButton implements ActionListener{

	private String path;

	public AdImageButton(String path, int width, int height,String txt) {
		this.path = path;
		this.setText(txt);
		this.setIcon(AdGetImage.makeImageIcon(path,width,height));

		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setBackground(new Color(225, 238, 246));
		setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		setBorder(new LineBorder(new Color(225, 238, 246)));
		setVerticalTextPosition(SwingConstants.BOTTOM);
		setHorizontalTextPosition(SwingConstants.CENTER);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame df = (JFrame)((JButton)e.getSource()).getRootPane().getParent();
		new AdDetailsView(path, df);
	}

}
