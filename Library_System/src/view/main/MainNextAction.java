package view.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import view.returns.ReturnFrame;

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
		JFrame df = (JFrame)((JButton)e.getSource()).getRootPane().getParent();
		
		// 해당 프레임들로 바꿔야함
		if(next.equals("rental")) {	
			df.dispose();
			
//			RentalFrame rental = new ManagerFrame();
//			rental.setVisible(true);
			
			
		} else if (next.equals("return")) {
			df.dispose();
			new ReturnFrame();
			
		} else if (next.equals("extention")) {
			df.dispose();
			
//			AdvertisingFrame extention = new AdvertisingFrame();
//			extention.setVisible(true);
		}
		
	}

}
