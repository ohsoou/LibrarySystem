package view.advertising;

import java.awt.Color;
import java.awt.Font;


import javax.swing.JLabel;



public class AdTitleLabel extends JLabel{
	
	final private static String suggestBook = "추천";
	final private static String newBook = "신작";
	

	public AdTitleLabel(boolean status) {
		if(status) {
			setText("이달의 "+newBook+" 도서");
		} else {
			setText("이달의 "+suggestBook+" 도서");
		}
		setFont(new Font("맑은 고딕", Font.BOLD, 30));
		setForeground(new Color(252, 190, 50));
		setHorizontalAlignment(CENTER);
		
		JLabel subTitle = new JLabel("선택하시면 로그인 후 바로 대여하실 수 있습니다.");
		subTitle.setForeground(new Color(0, 78, 102));
		subTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		subTitle.setBounds(110, 35, 400, 160);
		
		add(subTitle);
		setBounds(200, -45, 550, 160);
		


	}
	
}
