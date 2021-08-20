package view.rental;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import view.main.MainFrame;

public class SelectBtnActionMain implements ActionListener{
	
	JButton btn;
	public SelectBtnActionMain(JButton btn) {
		this.btn = btn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UserSelection.clearSelectedBook();
		JFrame df = (JFrame)((JButton)e.getSource()).getRootPane().getParent();
		new MainFrame();
		df.dispose();
		
	}

}
