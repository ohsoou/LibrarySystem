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
		JFrame df = (JFrame)((JButton)e.getSource()).getRootPane().getParent();
		
		// �ش� �����ӵ�� �ٲ����
		if(next.equals("rental")) {	
			df.dispose();
			
//			ManagerFrame rental = new ManagerFrame();
//			rental.setVisible(true);
			
			
		} else if (next.equals("return")) {
			df.dispose();
			
//			LoginFrame returnfr = new LoginFrame();
//			returnfr.setVisible(true);
			
			
		} else if (next.equals("extention")) {
			df.dispose();
			
//			AdvertisingFrame extention = new AdvertisingFrame();
//			extention.setVisible(true);
		}
		
	}

}
