package view.advertising;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import view.component.DefaultPanel;

	/*
	 	데이터베이스에서 신간도서 정보를 뽑아와
	 	이미지와 텍스트를 함께 출력해줄 클래스
	 */
public class NewBookPanel extends DefaultPanel{
	
	String[] images = {"./testimage/다시 또 여름.jpg","./testimage/다운로드.jpg","./testimage/매체.jpeg","./testimage/아름답고죽은그녀.jpg",
			"./testimage/이별을떠나.jpg","./testimage/출판탐험.jpg","./testimage/현지야.jpg","./testimage/혼자서본영화.jpg"};
	String[] bookName = {"LionKing","LionCoke","팽귄키우기","호랑이잡는법","산에서호랑이를","권...","현지야","영화추천"};
	int x;
	int y;
	
	public NewBookPanel() {
		setLayout(null);
		for(int i = 0; i < 8; ++i) {
			AdImageButton btn = new AdImageButton(images[i],230,153,bookName[i],x,y);
			x += 157;
			if((i+1) % 4 == 0) {
				x = 0;
				y += 190;
			}
			add(btn);
		}	
		
		setBounds(190,180,600,380);
		setVisible(true);
	}

}
