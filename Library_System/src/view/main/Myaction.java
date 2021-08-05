package view.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;

public class Myaction extends JFrame implements ActionListener{

	int i;
	public Myaction(int i) {
		this.i = i;
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		if(i == 0) {
			new TestPanel();
		} else if (i == 1) {
			
		} else if (i == 2) {
			
		} else if (i == 3){
			
		}
		
	}

}
