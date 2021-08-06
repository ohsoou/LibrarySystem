package view.advertising;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import view.component.DefaultButton;

	/*
	 	[AdCenterPanel]
	 	추천,신작 버튼이 달려있는 페널.
	 */
public class AdCenterPanel extends AdTopPanel{
	
	static JButton[] btn = new DefaultButton[2];
	String[] btns = {"추천","신작"};
	static SuggestionBookPanel suggestPanel = new SuggestionBookPanel();
	static NewBookPanel newBook = new NewBookPanel();
	
	public AdCenterPanel() {
		x = 555;
		y = 120;
		width = 100;
		height = 35;
		setLayout(null);
		suggestPanel.setVisible(false);
		
		for(int i = 0; i < 2; ++i) {
			btn[i] = new DefaultButton(btns[i],100,50);
			btn[i].setBounds(x,y,width,height);
			btn[i].addActionListener(new AdActionButton(i));
			btn[i].setBackground(new Color(225, 238, 246));
			btn[i].setFont(new Font("맑은 고딕", Font.BOLD, 25));
			add(btn[i]);
			x += 110;
		}
		btn[0].setForeground(new Color(0, 78, 102));
		btn[1].setForeground(new Color(252, 190, 50));
		
		add(suggestPanel);
		add(newBook);
		setBounds(0,0,980,600);
	}



}
