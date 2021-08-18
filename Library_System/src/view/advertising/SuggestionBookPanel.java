package view.advertising;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;

import model.dao.AllBookInfoDao;
import model.dao.BookinfoDao;
import model.dto.AllBookInfo;
import model.dto.Bookinfo;
import view.defaultcomponent.DefaultPanel;

	/*
		데이터베이스에서 추천도서 정보를 뽑아와
		이미지와 텍스트를 함께 출력해줄 클래스
	 */
public class SuggestionBookPanel extends DefaultPanel{
	
	public SuggestionBookPanel() {
		String image;
		String bookNames;
		
		setLayout(new GridLayout(2,4));
		for(int i = 0; i < 8; ++i) {
			image = randomBookList().get(i).getImagepath();
			bookNames = randomBookList().get(i).getBook_name();		
			AdImageButton btn = new AdImageButton(image,100,140,bookNames);
			add(btn);
		}	
		setBounds(180,140,600,380);
	}
	
	private static ArrayList<AllBookInfo> randomBookList() {
		AllBookInfoDao dao = AllBookInfoDao.getInstance();
		ArrayList<AllBookInfo> dto = dao.listAll_AllBookinfo();
		ArrayList<AllBookInfo> dtos = new ArrayList<>();
		for(int i = 0; i < dto.size(); ++i) {
			if((!dto.get(i).getLoan_state().equals("N")) && (!dto.get(i).getImagepath().equals("./image/NoBookImage.PNG"))) {
				dtos.add(dto.get(i));
			}
		}
		return dtos;
	}
	
	
}
