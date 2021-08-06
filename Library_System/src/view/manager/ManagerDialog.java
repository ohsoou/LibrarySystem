package view.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ManagerDialog extends JDialog{
	public ManagerDialog(JFrame frame, String title) {
		super(frame, title);
		this.setLocation(100, 100);
		getContentPane().setBackground(new Color(244,240,240));
		
		setLayout(new BorderLayout());
		JLabel pageTitle = new JLabel(title);
		pageTitle.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		
		add(pageTitle, "North");
		
		JPanel center = new JPanel();
		center.setBackground(new Color(244,240,240));
		center.setLayout(new FlowLayout());
		center.add(new FormPanel());
		center.add(new FilePanel());
		add(center, "Center");
		
		JPanel bottom = new ButtonPanel();
		add(bottom, "South");

		setSize(730, 530);
	
	}
	
	class ButtonPanel extends JPanel {
		public ButtonPanel() {
			setPreferredSize(new Dimension(730, 100));
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
