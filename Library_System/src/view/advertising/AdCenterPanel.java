package view.advertising;
import java.awt.Color;

import javax.swing.JButton;

import view.defaultcomponent.DefaultPanel;

	/*
	 	[AdCenterPanel]
	 	추천,신작 버튼이 달려있는 페널.
	 */
public class AdCenterPanel extends DefaultPanel{
	
	static JButton[] btn = new AdActionButton[2];
	String[] btns = {"추천","신작"};
	static SuggestionBookPanel suggestPanel = new SuggestionBookPanel();
	static NewBookPanel newBook = new NewBookPanel();
	
	public AdCenterPanel() {
		boolean[] visible = {false,true};
		int x = 580;
		int y = 90;
		int width = 100;
		int height = 35;
		setLayout(null);
		
		for(int i = 0; i < 2; ++i) {
			btn[i] = new AdActionButton(visible[i],btns[i],100,50);
			btn[i].setBounds(x,y,width,height);
			add(btn[i]);
			x += 110;
		}
		btn[0].setForeground(new Color(0, 78, 102));
		btn[1].setForeground(new Color(252, 190, 50));
		
		add(newBook);
		add(suggestPanel);
		setBounds(0,0,980,600);
	}



}
