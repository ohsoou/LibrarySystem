package view.manager.dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.dto.Bookinfo;
import view.component.DefaultPanel;
import view.component.RoundTextField;

public class FormPanel extends DefaultPanel {
	private Bookinfo book;
    JTextField isbnField;
    JTextField kdcField;
    JTextField nameField;
    JTextField authorField;
    JTextField publisherField;
    JTextField publicationDateField;
	
	
	
	public FormPanel() {
		super(new Color(244, 240, 240));
		setFont(new Font("���� ���", Font.PLAIN, 14));
		setLayout(new GridBagLayout());
		
		GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        
		JLabel isbnLabel = new JLabel("ISBN");
        isbnField = new RoundTextField(180, 30);
        
        JLabel kdcLabel = new JLabel("KDC");
        kdcField = new RoundTextField(180, 30);
        
        JLabel nameLabel = new JLabel("������");
        nameField = new RoundTextField(180, 30);
        
        JLabel authorLabel = new JLabel("����");
        authorField = new RoundTextField(180, 30);
        
        JLabel publisherLabel = new JLabel("���ǻ�");
        publisherField = new RoundTextField(180, 30);
        
        JLabel publicationDateLabel = new JLabel("������");
        publicationDateField = new RoundTextField(180, 30);
        publicationDateField.setText("0000-01-01");
        
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
        
        book = new Bookinfo();
	}
	
	public Bookinfo getBook() {
		if(isbnField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this.getRootPane().getParent(), "ISBN�� �ʼ� �Է¶� �Դϴ�.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			return null;
		} else {
			book.setISBN(Long.parseLong(isbnField.getText()));
		}
		if(authorField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this.getRootPane().getParent(), "�۰��� �ʼ� �Է¶� �Դϴ�.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			return null;
        } else {
        	book.setAuthor(authorField.getText());
		}
        
        if(nameField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this.getRootPane().getParent(), "å �̸��� �ʼ� �Է¶� �Դϴ�.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			return null;
        } else {
			book.setBook_name(nameField.getText());
		}
        if(publisherField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this.getRootPane().getParent(), "���ǻ�� �ʼ� �Է¶� �Դϴ�.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			return null;
        } else {
        	book.setPublisher(publisherField.getText());
		}
        book.setKDC(kdcField.getText());
        book.setPublication_date(Date.valueOf(publicationDateField.getText()));
		
		return book;
	}
}
