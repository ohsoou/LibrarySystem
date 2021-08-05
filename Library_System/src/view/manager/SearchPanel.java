package view.manager;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.component.DefaultBookCategoryDropDown;
import view.component.DefaultBookSearchBar;
import view.component.DefaultBtn;

@SuppressWarnings("serial")
public class SearchPanel extends JPanel{

	@SuppressWarnings("rawtypes")
	public SearchPanel() {
		super();
		setLayout(new FlowLayout(FlowLayout.LEFT, 50, 10));
		setBackground(new Color(225, 238, 246));
		
		JComboBox bookCategory = new DefaultBookCategoryDropDown();
		JTextField searchBar = new DefaultBookSearchBar();
		JButton searchBtn = new DefaultBtn("검색");
		
		add(bookCategory);
		add(searchBar);
		add(searchBtn);
	}
	
	private class searchListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			
			// TODO: 검색 결과 나오도록 이벤트 처리
			
		}
	}
}
