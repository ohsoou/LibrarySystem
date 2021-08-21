package view.advertising;

import java.awt.Color;
import java.awt.Font;


import javax.swing.JLabel;

public class AdTitleLabel extends JLabel{
	
	final private static String suggestBook = "��õ";
	final private static String newBook = "����";
	

	public AdTitleLabel(boolean status) {
		if(status) {
			setText("�̴��� "+newBook+" ����");
		} else {
			setText("�̴��� "+suggestBook+" ����");
		}
		setFont(new Font("���� ���", Font.BOLD, 30));
		setForeground(new Color(252, 190, 50));
		setHorizontalAlignment(JLabel.CENTER);
	}
	
}
