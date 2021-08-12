package view.advertising;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import view.advertising.details.AdDetailsView;
import view.component.DefaultFrame;
	/*
	 	[AdImageButton]
	 	��ư�� �� �̹����� �ؽ�Ʈ ����� �������ִ� Ŭ����.
	 */
public class AdImageButton extends JButton implements ActionListener{

	String path;
	public static AdDetailsView details;
	public AdImageButton(String path, int width, int height,String txt) {
		this.path = path;
		this.setText(txt);
		this.setIcon(AdGetImage.makeImageIcon(path,width,height));

		
		setBackground(new Color(225, 238, 246));
		setFont(new Font("���� ���", Font.PLAIN, 14));
		setBorder(new LineBorder(new Color(225, 238, 246)));
		setVerticalTextPosition(SwingConstants.BOTTOM);
		setHorizontalTextPosition(SwingConstants.CENTER);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		details = new AdDetailsView(path);
	}

}
