package view.advertising;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;

import model.dto.Student;

public class AdTitleLabel extends JLabel{
	
	
	public AdTitleLabel(String string) {
		
		super("<html><span style=color:\"Yellow\">이달의&nbsp;추천&nbsp;도서</span><br>"
				+ "<font size=\"5\">선택하시면&nbsp;로그인&nbsp;후&nbsp;바로&nbsp;대여하실&nbsp;수&nbsp;있습니다.</span></html>");
		setFont(new Font("궁서체", Font.BOLD, 52));
		setForeground(new Color(0, 78, 102));
		setBounds(20, 0, 200, 120);
	}
	
}
