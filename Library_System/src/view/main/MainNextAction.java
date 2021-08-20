package view.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import view.returns.ReturnFrame;
import view.extend.ExtendFrame;
import view.rental.RentalMainFrame;

	
public class MainNextAction implements ActionListener{

	String next;
	public MainNextAction(String next) {
		this.next = next;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		JFrame df = (JFrame)((JButton)e.getSource()).getRootPane().getParent();
		df.dispose();
		if(next.equals("rental")) {	
			new RentalMainFrame();

		} else if (next.equals("return")) {
			new ReturnFrame();
			
		} else if (next.equals("extention")) {
			new ExtendFrame();
		}
		
	}

}
