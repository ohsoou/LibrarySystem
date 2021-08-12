package view.advertising;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;

import model.dao.AllBookInfoDao;
import model.dao.BookinfoDao;
import model.dto.AllBookInfo;
import model.dto.Bookinfo;
import view.component.DefaultPanel;

	/*
		�����ͺ��̽����� ��õ���� ������ �̾ƿ�
		�̹����� �ؽ�Ʈ�� �Բ� ������� Ŭ����
	 */
public class SuggestionBookPanel extends DefaultPanel{
	
	public SuggestionBookPanel() {
		String image;
		String bookNames;
		
		setLayout(new GridLayout(2,4));
		for(int i = 0; i < 8; ++i) {
			image = randomBookList().get(i).getImagepath();
			bookNames = randomBookList().get(i).getBook_name();		
			AdImageButton btn = new AdImageButton(image,120,153,bookNames);
			add(btn);
		}	
		setBounds(190,180,600,380);
		setVisible(true);
	}
	
	private static ArrayList<AllBookInfo> randomBookList() {
		AllBookInfoDao dao = AllBookInfoDao.getInstance();
		ArrayList<AllBookInfo> dto = dao.listAll_AllBookinfo();
		return dto;
	}
	
	
}
