package view.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class OpenDialogListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)(e.getSource());
		
		JFrame df = (JFrame)btn.getRootPane().getParent();
		JDialog update = new UpdateDialog(df, "µµ¼­ " + btn.getText());
		update.setVisible(true);
		
	}
}