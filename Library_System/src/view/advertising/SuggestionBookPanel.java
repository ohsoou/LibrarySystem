package view.advertising;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashSet;

import model.dao.AllBookInfoDao;
import model.dto.AllBookInfo;
import view.defaultcomponent.DefaultPanel;

	/*
		데이터베이스에서 추천도서 정보를 뽑아와
		이미지와 텍스트를 함께 출력해줄 클래스
	 */
public class SuggestionBookPanel extends DefaultPanel{
	
	public static ArrayList<AllBookInfo> dtos;
	
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

		setPreferredSize(new Dimension(600,380));
	}
	
	private static ArrayList<AllBookInfo> randomBookList() {	
		AllBookInfoDao dao = AllBookInfoDao.getInstance();
		dtos = dao.listAll_AllBookinfo();
		ArrayList<AllBookInfo> showingBooks = new ArrayList<>();
		HashSet<Long> isbnOfShowingBooks = new HashSet<>();

		for(int i = 0, j = 0; j < 8; i++) {
			AllBookInfo book = dtos.get(i);
			
			if(!(book.getLoan_state().equals("N") ||
					book.getImagepath().equals("./image/NoBookImage.PNG"))) {
				if(!isbnOfShowingBooks.contains(book.getIsbn())) {
					isbnOfShowingBooks.add(book.getIsbn());
					showingBooks.add(book);
					j++;
				}
			}
		}
		return showingBooks;
	}
	
	
}
