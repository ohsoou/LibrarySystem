package view.advertising;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;

import view.defaultcomponent.DefaultPanel;

	/*
	 	[AdCenterPanel]
	 	추천,신작 버튼이 달려있는 페널.
	 */
public class AdCenterPanel extends DefaultPanel{
	
	public static JButton suggestBtn;
	public static JButton newBtn;
	public static SuggestionBookPanel suggestPanel;
	public static NewBookPanel newBook;
	
	public AdCenterPanel() {

		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		Container button = new Container();
		button.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		button.setPreferredSize(new Dimension(600, 65));
		
		Container center = new Container();
		center.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		suggestPanel = new SuggestionBookPanel();
		newBook = new NewBookPanel();
		
		suggestPanel.setVisible(false);
		center.add(newBook);
		center.add(suggestPanel);
		
		suggestBtn = new AdActionButton(false,"추천",100,50);
		newBtn = new AdActionButton(true,"신작",100,50);
		newBtn.setForeground(new Color(252, 190, 50));
		
		button.add(suggestBtn);
		button.add(newBtn);
		
		add(button);
		add(center);
		
		setPreferredSize(new Dimension(980, 600));
	}



}
