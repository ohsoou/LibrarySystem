package view.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;

	/*
	 	생성자에 넘어갈 페이지에 정해진 이름을 받아
	 	넘겨준다
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
