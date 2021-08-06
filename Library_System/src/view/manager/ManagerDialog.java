package view.manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ManagerDialog extends JDialog{
	public ManagerDialog(JFrame frame, String title) {
		super(frame, title);
		this.setLocation(100, 100);
		getContentPane().setBackground(new Color(244,240,240));
		setLayout(new GridBagLayout());
		
		GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.BOTH;
		
		JLabel pageTitle = new JLabel(title);
		pageTitle.setFont(new Font("���� ����", Font.BOLD, 20));
		
		constraints.gridx = 0;
        constraints.gridy = 0;     
        add(pageTitle, constraints);
        
        constraints.gridy = 1;     
        add(new FormPanel(), constraints);
 
        constraints.gridx = 1;
        constraints.gridy = 1;     
        add(new FilePanel(), constraints);
        
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 2; 
        add(new JButton("CANCEL"), constraints);
        constraints.gridx = 1;
        add(new JButton("SUBMIT"), constraints);

		setSize(730, 530);
	
	}

}
