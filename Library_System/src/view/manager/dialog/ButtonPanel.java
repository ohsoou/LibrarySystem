package view.manager.dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import view.component.DefaultPanel;


public class ButtonPanel extends DefaultPanel{

	public ButtonPanel() {
		super(new Color(244, 240, 240));
		setPreferredSize(new Dimension(730, 80));
		setLayout(new GridLayout(1, 2));
		setBackground(Color.green);
		JButton cancel = new JButton("CANCEL");
		JButton submit = new JButton("SUBMIT");
		
		cancel.setBackground(new Color(244,240,240)); 
		cancel.setForeground(new Color(158, 158, 158));
		cancel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 22));
		cancel.addActionListener(new cancelDialogListener());
		
		submit.setBackground(new Color(244,240,240)); 
		submit.setForeground(new Color(158, 158, 158));
		submit.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 22));

		add(cancel);
		add(submit);
		
	}
	
	class cancelDialogListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			
			JDialog dialog = (JDialog)btn.getRootPane().getParent();
			
			dialog.setVisible(false);
			dialog.dispose();
			
		}
	}
}
