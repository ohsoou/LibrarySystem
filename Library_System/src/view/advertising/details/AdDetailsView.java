package view.advertising.details;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.dao.AllBookInfoDao;
import model.dto.AllBookInfo;
import view.advertising.AdGetImage;

public class AdDetailsView extends JFrame{
	
	static String path;	
	public AdDetailsView(String path) {
		super("상세 보기");
		this.path = path;
		int x = 300;
		int y = 100;
		int width = 100;
		int height = 50;
		setLayout(null);
		
		String[] btnStr = {"닫기", "대여"};
		String[] labelNames = {"지은이", "출판사", "장르","줄거리"};
		String[] detailsInfo = new String[4];
		detailsInfo[0] = BookList().get(0).getAuthor();
		detailsInfo[1] = BookList().get(0).getPublisher();
		detailsInfo[2] = BookList().get(0).getCategory_name();
		detailsInfo[3] = BookList().get(0).getSummary();
		
		AdDetailsLabel[] label = new AdDetailsLabel[8];
		JLabel imageLabel = new JLabel();
		JLabel bookNameLabel = new AdDetailsLabel(BookList().get(0).getBook_name(),300,50,500,50);
		
		imageLabel.setIcon(AdGetImage.makeImageIcon(path,200,250));
		imageLabel.setBounds(50, 50, 200, 250);
		add(imageLabel);
		add(bookNameLabel);
		
		for(int i = 0; i < 8; ++i) {
			if(i < 4) {
			label[i] = new AdDetailsLabel(labelNames[i], x, y, width, height);
			label[i].setFont(new Font("맑은 고딕", Font.BOLD, 15));
			y += 40;
			add(label[i]);
			if(i == 3) {
				x = 400;
				y = 100;
			}
			}else {
				label[i] = new AdDetailsLabel(detailsInfo[i-4], x, y, width, height);
				label[i].setFont(new Font("맑은 고딕", Font.PLAIN, 13));
				y += 40;
				add(label[i]);
			}
		}
		label[7].setText("<html><body style='text-align:west;'>"+detailsInfo[3]+"<br/></body></html>");
		label[7].setBounds(x,215,450,100);
		
		ArrayList<AdDetailsViewButton> button = new ArrayList<>();
		for(int i = 0; i < 2; ++i) {
			button.add(new AdDetailsViewButton(btnStr[i]));
			add(button.get(i));
			button.get(0).setLocation(0,300);
		}
		
		getContentPane().setBackground(new Color(244, 240, 240));
		setLocation(new Point(170, 150));
		setSize(new Dimension(880, 500));
		setVisible(true);
	}
		
	public static ArrayList<AllBookInfo> BookList() {
		AllBookInfoDao dao = AllBookInfoDao.getInstance();
		ArrayList<AllBookInfo> dtos = dao.listAll_AllBookinfo();
		ArrayList<AllBookInfo> dto = new ArrayList<>();	
		for(int i = 0; i < dtos.size(); ++i) {
			if(dtos.get(i).getImagepath().equals(path)) {
				dto.add(dtos.get(i));
			}
		}
		return dto;	
	}
}
