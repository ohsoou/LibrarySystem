package view.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;

	/*
	 	�����ڿ� �Ѿ �������� ������ �̸��� �޾�
	 	�Ѱ��ش�
	*/
public class MainNextAction implements ActionListener{

	String next;
	public MainNextAction(String next) {
		this.next = next;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		if(next.equals("rental")) {	
		
		} else if (next.equals("return")) {
			
		} else if (next.equals("extention")) {
			
		}
		
	}

}
