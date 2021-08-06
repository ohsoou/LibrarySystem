package view.manager;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import view.component.DefaultBookCategoryDropDown;
import view.component.DefaultBookSearchBar;
import view.component.DefaultButton;
import view.component.DefaultPanel;

@SuppressWarnings("serial")
public class SearchPanel extends DefaultPanel{

	@SuppressWarnings("rawtypes")
	public SearchPanel() {
		super();
		setLayout(new FlowLayout(FlowLayout.LEFT, 50, 10));
		
		JComboBox bookCategory = new DefaultBookCategoryDropDown();
		JTextField searchBar = new DefaultBookSearchBar();
		JButton searchBtn = new DefaultButton("검색");
		
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
