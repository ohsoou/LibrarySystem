package view.advertising;

import java.awt.GridLayout;
import java.util.ArrayList;



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
	// ����Ʈ�� ��°Ŵϱ� ��...
	private static ArrayList<AllBookInfo> newBookList() {
		AllBookInfoDao dao = AllBookInfoDao.getInstance();
		ArrayList<AllBookInfo> dto = dao.listNewBook();
		ArrayList<AllBookInfo> dtos = new ArrayList<>();
		for(int i = 0; i < dto.size(); ++i) {
			if((!dto.get(i).getLoan_state().equals("N")) && (!dto.get(i).getImagepath().equals("./image/NoBookImage.PNG"))) {
				dtos.add(dto.get(i));
			}
		}
		return dtos;	
	}
	
}
