package view.advertising;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import view.component.DefaultPanel;

	/*
		데이터베이스에서 추천도서 정보를 뽑아와
		이미지와 텍스트를 함께 출력해줄 클래스
	 */
public class SuggestionBookPanel extends DefaultPanel{

	String[] images = {"./image/COSMOS.jpg","./image/강아지 심리 백과.jpg","./image/까눌레.jpg","./image/깨어난 포스.jpg",
			"./image/꽃을 사는 여자들.jpg","./image/무림오적.1.jpg","./image/달러구트 꿈 백화점.jpg","./image/나의 라임 오렌지나무.jpg"};
	String[] bookName = {"COSMOS","강아지 심리 백과","까눌레","깨어난 포스","꽃을 사는 여자들","무림오적.1","달러구트 꿈 백화점","나의 라임 오렌지나무"};
	/*
	 	데이터베이스에서 Book에서
	 	책 이름,이미지주소 가져와서 1차적으로 띄우고 눌렀을시에는
	 	모달창을 하나 띄워서
	 	책 이미지주소,이름,지은이,장르,줄거리(미정) 를 보여준다
	*/
	public SuggestionBookPanel() {
		int x = 0;
		int y = 0;
		setLayout(null);
		for(int i = 0; i < 8; ++i) {
			AdImageButton btn = new AdImageButton(images[i],150,153,bookName[i],x,y);
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
