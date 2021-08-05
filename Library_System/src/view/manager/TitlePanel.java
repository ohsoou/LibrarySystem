package view.manager;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import view.component.DefaultBtn;

public class TitlePanel extends JPanel{	
	private JPanel contentPane;
	private JButton DefaultBtn;
	
	public TitlePanel() {		
		setBackground(new Color(225, 238, 255));
		
		setLayout(new FlowLayout(FlowLayout.LEFT, 50, 10));

		
		JLabel title = new TitleLabel("<html>manager<br>system</html>");
		
		
		JButton addBtn = new DefaultBtn("추가");
		
		JButton updateBtn = new DefaultBtn("수정");
		
		
		JButton deleteBtn = new DefaultBtn("삭제"); 
		
		JButton listBtn = new DefaultBtn("전체보기");
		
		add(title);
		add(addBtn);
		add(updateBtn);
		add(deleteBtn);
		add(listBtn);
		 

	}
}
