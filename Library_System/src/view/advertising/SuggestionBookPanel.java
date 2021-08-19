package view.advertising;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import model.dao.AllBookInfoDao;
import model.dto.AllBookInfo;
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
		int count = 0;
		int count2 = 0;
		while(dtos.size() != 8) {
			if((!dto.get(count).getLoan_state().equals("N")) && (!dto.get(count).getImagepath().equals("./image/NoBookImage.PNG"))) {
				dtos.add(dto.get(count));

				count2++;			
				if(count2 > 1 && dtos.get(count2-2).getBook_name().equals(dtos.get(count2-1).getBook_name())) {
					count2--;
					dtos.remove(dtos.get(count2));
				}				
			}
			count++;
		}
		return dtos;
	}
	
	
}
