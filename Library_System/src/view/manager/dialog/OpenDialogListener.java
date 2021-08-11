package view.manager.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import view.manager.ManagerPanel;

public class OpenDialogListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)(e.getSource());
		
		JFrame df = (JFrame)btn.getRootPane().getParent();
		
		if(btn.getText().equals("추가")) {
			ManagerPanel parentPanel = (ManagerPanel)btn.getParent().getParent();
			
		}
		JDialog update = new ManagerDialog(df, "도서 " + btn.getText());
		update.setVisible(true);
		
	}
}