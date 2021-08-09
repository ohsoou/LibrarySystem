package view.manager.dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;

import view.component.DefaultPanel;
import view.component.RoundTextField;

public class FormPanel extends DefaultPanel {
	public FormPanel() {
		super(new Color(244, 240, 240));
		setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		setLayout(new GridBagLayout());
		
		GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        
		JLabel isbnLabel = new JLabel("ISBN");
        JTextField isbnField = new RoundTextField(180, 30);
        
        JLabel kdcLabel = new JLabel("KDC");
        JTextField kdcField = new RoundTextField(180, 30);
        
        JLabel nameLabel = new JLabel("도서명");
        JTextField nameField = new RoundTextField(180, 30);
        
        JLabel authorLabel = new JLabel("저자");
        JTextField authorField = new RoundTextField(180, 30);
        
        JLabel publisherLabel = new JLabel("출판사");
        JTextField publisherField = new RoundTextField(180, 30);
        
        JLabel publicationDateLabel = new JLabel("출판일");
        JTextField publicationDateField = new RoundTextField(180, 30);
        
        constraints.gridx = 0;
        constraints.gridy = 0;     
        add(isbnLabel, constraints);
  
        constraints.gridx = 1;
        add(isbnField, constraints);
          
        constraints.gridx = 0;
        constraints.gridy = 1;     
        add(kdcLabel, constraints);
          
        constraints.gridx = 1;
        add(kdcField, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;     
        add(nameLabel, constraints);
  
        constraints.gridx = 1;
        add(nameField, constraints);
          
        constraints.gridx = 0;
        constraints.gridy = 3;     
        add(authorLabel, constraints);
          
        constraints.gridx = 1;
        add(authorField, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 4;     
        add(publisherLabel, constraints);
  
        constraints.gridx = 1;
        add(publisherField, constraints);
          
        constraints.gridx = 0;
        constraints.gridy = 5;     
        add(publicationDateLabel, constraints);
          
        constraints.gridx = 1;
        add(publicationDateField, constraints);
        
        
	}
}
