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
		setHorizontalAlignment(CENTER);
		
		JLabel subTitle = new JLabel("�����Ͻø� �α��� �� �ٷ� �뿩�Ͻ� �� �ֽ��ϴ�.");
		subTitle.setForeground(new Color(0, 78, 102));
		subTitle.setFont(new Font("���� ���", Font.PLAIN, 15));
		subTitle.setBounds(110, 35, 400, 160);
		
		add(subTitle);
		setBounds(200, -45, 550, 160);
		


	}
	
}
