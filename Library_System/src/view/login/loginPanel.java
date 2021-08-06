package view.login;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class loginPanel extends JPanel{
	
	private final static int COMPONENT_SIZE = 6;
	
	public loginPanel() {
		setLayout(new GridBagLayout());
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(new Color(225, 238, 246)); 
		GridBagConstraints[] gbc = new GridBagConstraints[COMPONENT_SIZE];
		
		for(int i = 0; i < COMPONENT_SIZE; i++) {
			gbc[i] = new GridBagConstraints();
		}
		
		JLabel title = new loginTitleLable();
		JLabel idLabel = new idLabel();
		JLabel pwLabel = new pwLabel();
		
		JTextField idField = new idTextField();
		JTextField passwordField = new pwTextField();
		
		JButton jb = new loginButton();
		
		gbc[0].gridx = 0;
		gbc[0].gridy = 0;
		gbc[0].gridheight = 1;
		gbc[0].gridwidth = 2;
		gbc[0].fill = GridBagConstraints.BOTH;
		add(title,gbc[0]);
		
		gbc[1].gridx = 0;
		gbc[1].gridy = 1;
		add(idLabel,gbc[1]);
		
		gbc[2].gridx = 0;
		gbc[2].gridy = 2;
		add(pwLabel,gbc[2]);
		
		gbc[3].gridx = 1;
		gbc[3].gridy = 1;
		add(idField,gbc[3]);
		
		gbc[4].gridx = 1;
		gbc[4].gridy = 2;
		add(passwordField,gbc[4]);
		
		gbc[5].gridx = 0;
		gbc[5].gridy = 3;
		gbc[5].gridheight = 2;
		gbc[5].gridwidth = 2;
		gbc[5].fill = GridBagConstraints.BOTH;
		add(jb,gbc[5]);
		
	}
}
