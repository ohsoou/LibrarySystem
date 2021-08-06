package view.advertising;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import view.component.DefaultPanel;

	/*
		데이터베이스에서 추천도서 정보를 뽑아와
		이미지와 텍스트를 함께 출력해줄 클래스
	 */
public class SuggestionPanel extends DefaultPanel{

	String[] images = {"./testimage/lion1.jpg","./testimage/lion3.jpg","./testimage/panquin.jpg","./testimage/tiger1.jpg",
			"./testimage/tiger2.jpg","./testimage/prog.jpg","./testimage/현지야.jpg","./testimage/혼자서본영화.jpg"};
	String[] bookName = {"LionKing","LionCoke","팽귄키우기","호랑이잡는법","산에서호랑이를","권...","현지야","영화추천"};
	int x;
	int y;
	/*
	 	데이터베이스에서 Book에서
	 	책 이름,이미지주소 가져와서 1차적으로 띄우고 눌렀을시에는
	 	모달창을 하나 띄워서
	 	책 이미지주소,이름,지은이,장르,줄거리(미정) 를 보여준다
	*/
	public SuggestionPanel() {
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
