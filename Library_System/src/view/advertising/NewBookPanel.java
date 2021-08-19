package view.advertising;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashSet;

import model.dao.AllBookInfoDao;
import model.dto.AllBookInfo;
import view.defaultcomponent.DefaultPanel;

	/*
	 	�����ͺ��̽����� �Ű����� ������ �̾ƿ�
	 	�̹����� �ؽ�Ʈ�� �Բ� ������� Ŭ����
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
		ArrayList<AllBookInfo> dtos = dao.listNewBook();
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
