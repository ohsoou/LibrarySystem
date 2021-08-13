package view.advertising;

import java.awt.GridLayout;
import java.util.ArrayList;



import model.dao.AllBookInfoDao;
import model.dto.AllBookInfo;
import view.defaultcomponent.DefaultPanel;

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
			AdImageButton btn = new AdImageButton(image,100,140,bookNames);
			add(btn);
		}	
		setBounds(180,140,600,380);
	}
	
	private static ArrayList<AllBookInfo> newBookList() {
		AllBookInfoDao dao = AllBookInfoDao.getInstance();
		ArrayList<AllBookInfo> dto = dao.listNewBook();
		return dto;	
	}
	
}
