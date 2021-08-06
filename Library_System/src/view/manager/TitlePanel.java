package view.manager;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.component.DefaultBtn;
import view.component.DefaultPanel;

public class TitlePanel extends DefaultPanel{	
	private JPanel contentPane;
	private JButton DefaultBtn;
	
	public TitlePanel() {		
		
		setLayout(new FlowLayout(FlowLayout.LEFT, 50, 10));

		
		JLabel title = new TitleLabel("<html>manager<br>system</html>");
		
		
		JButton addBtn = new DefaultBtn("�߰�");
		
		JButton updateBtn = new DefaultBtn("����");
		
		
		JButton deleteBtn = new DefaultBtn("����"); 
		
		JButton listBtn = new DefaultBtn("��ü����");
		
		add(title);
		add(addBtn);
		add(updateBtn);
		add(deleteBtn);
		add(listBtn);
		 

	}
}
