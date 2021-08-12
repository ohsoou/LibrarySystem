package view.advertising;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JLabel;

import db.DBConnector;
import model.dao.AllBookInfoDao;
import model.dao.BookinfoDao;
import model.dto.AllBookInfo;
import model.dto.Book;
import model.dto.Bookinfo;
import view.component.DefaultPanel;

	/*
	 	데이터베이스에서 신간도서 정보를 뽑아와
	 	이미지와 텍스트를 함께 출력해줄 클래스
	 */
public class NewBookPanel extends DefaultPanel{
	
	public NewBookPanel() {
		String image;
		String bookNames;
		setLayout(new GridLayout(2,4));
		for(int i = 0; i < 8; ++i) {
			image = newBookList().get(i).getImagepath();
			bookNames = newBookList().get(i).getBook_name();
			AdImageButton btn = new AdImageButton(image,120,153,bookNames);
			add(btn);
		}	
		setBounds(190,180,600,380);
		setVisible(true);
	}
	
	private static ArrayList<AllBookInfo> newBookList() {
		AllBookInfoDao dao = AllBookInfoDao.getInstance();
		ArrayList<AllBookInfo> dto = dao.listNewBook();
		return dto;	
	}
	
}
