package view.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import view.returns.ReturnFrame;

import view.rental.RentalMainFrame;

	
public class MainNextAction implements ActionListener{

	String next;
	public MainNextAction(String next) {
		this.next = next;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		JFrame df = (JFrame)((JButton)e.getSource()).getRootPane().getParent();
		
		if(next.equals("rental")) {	
			df.dispose();
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					RentalMainFrame frame = new RentalMainFrame();
					frame.setVisible(true);
				}
			});
//			ManagerFrame rental = new ManagerFrame();

			
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
