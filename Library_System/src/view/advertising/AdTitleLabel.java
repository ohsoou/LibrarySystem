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
		setHorizontalAlignment(JLabel.CENTER);
	}
	
}
