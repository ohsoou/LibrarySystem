package view.main;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class UnderPanel extends TopPanel{
		
	/*
 		[UnderPanel]
 		메인 페널에 하단 부분이며 컴포넌트로는 대여,반납,연장 버튼을 가지고 있습니다.
	 */
	String[] images = {"./image/main_btn_01.png","./image/main_btn_02.png","./image/main_btn_03.png"};
	String[] nextStr = {"rental","return","extention"};
	MainButton[] btn = new MainButton[3];
public UnderPanel() {
		x = 100;
		y = 220;
		width = 200;
		height = 300;
		setLayout(null);
		
		for(int i = 0; i < btn.length; ++i) {
			btn[i] = new MainButton(images[i],200,300);
			btn[i].addActionListener(new MainNextAction(nextStr[i]));
			btn[i].setBounds(x,y,width,height);
			x += 300;
			add(btn[i]);
		}
		
		setBackground(new Color(0xe1eef6));
		setBounds(0,0,980,600);
		setVisible(true);
		
	}
}