package view.manager;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.component.DefaultButton;
import view.component.DefaultPanel;

public class TitlePanel extends DefaultPanel{	
	private JPanel contentPane;
	private JButton DefaultBtn;
	
	public TitlePanel() {		
		
		setLayout(new FlowLayout(FlowLayout.LEFT, 50, 10));

		
		JLabel title = new TitleLabel("<html>manager<br>system</html>");
		
		
		JButton addBtn = new DefaultButton("추가");
		
		JButton updateBtn = new DefaultButton("수정");
		
		
		JButton deleteBtn = new DefaultButton("삭제"); 
		
		JButton listBtn = new DefaultButton("전체보기");
		
		add(title);
		add(addBtn);
		add(updateBtn);
		add(deleteBtn);
		add(listBtn);
		 

	}
}
