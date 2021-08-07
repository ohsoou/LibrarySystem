package view.advertising;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import db.DBConnector;
import model.dao.BookinfoDao;
import model.dto.Book;
import model.dto.Bookinfo;
import view.component.DefaultPanel;

	/*
	 	데이터베이스에서 신간도서 정보를 뽑아와
	 	이미지와 텍스트를 함께 출력해줄 클래스
	 */
public class NewBookPanel extends DefaultPanel{
	
	String[] images = {"./image/COSMOS.jpg","./image/강아지 심리 백과.jpg","./image/까눌레.jpg","./image/깨어난 포스.jpg",
			"./image/꽃을 사는 여자들.jpg","./image/무림오적.1.jpg","./image/달러구트 꿈 백화점.jpg","./image/나의 라임 오렌지나무.jpg"};
	String[] bookName = {"COSMOS","강아지 심리 백과","까눌레","깨어난 포스","꽃을 사는 여자들","무림오적.1","달러구트 꿈 백화점","나의 라임 오렌지나무"};
	
	public NewBookPanel() {
		int x = 0;
		int y = 0;
		setLayout(null);
		for(int i = 0; i < 8; ++i) {
			AdImageButton btn = new AdImageButton(images[i],100,153,bookName[i],x,y);
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
	public static void main(String[] args) {
		
	}
	
}
