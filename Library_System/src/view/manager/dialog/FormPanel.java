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

import model.dto.AllBookInfo;
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
	

	public FormPanel(AllBookInfo selectedBook) {
		super(new Color(244, 240, 240));
		setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		setLayout(new GridBagLayout());
		
		GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        
		JLabel isbnLabel = new JLabel("ISBN");
        isbnField = new RoundTextField(180, 30);
        
        JLabel kdcLabel = new JLabel("KDC");
        kdcField = new RoundTextField(180, 30);
        
        JLabel nameLabel = new JLabel("도서명");
        nameField = new RoundTextField(180, 30);
        
        JLabel authorLabel = new JLabel("저자");
        authorField = new RoundTextField(180, 30);
        
        JLabel publisherLabel = new JLabel("출판사");
        publisherField = new RoundTextField(180, 30);
        
        JLabel publicationDateLabel = new JLabel("출판일");
        publicationDateField = new RoundTextField(180, 30);
        publicationDateField.setText("0000-00-00");
        
        if(selectedBook != null) {
        	setBookInfoTextFeild(selectedBook);
        }
        
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
		if(isEmptyField(isbnField)) {
			return isNoInput("ISBN");
		} else {
			book.setISBN(Long.parseLong(isbnField.getText()));
		}
		if(isEmptyField(authorField)) {
			return isNoInput("작가");
        } else {
        	book.setAuthor(authorField.getText());
		}
        
        if(isEmptyField(nameField)) {
        	return isNoInput("책 이름");
        } else {
			book.setBook_name(nameField.getText());
		}
        if(isEmptyField(publisherField)) {
        	return isNoInput("출판사");
        } else {
        	book.setPublisher(publisherField.getText());
		}
        book.setKDC(kdcField.getText());
        book.setPublication_date(getPublicationDateField());
		
		return book;
	}
	
	private void setBookInfoTextFeild(AllBookInfo selectedBook) {
		isbnField.setText(String.valueOf(selectedBook.getIsbn()));
	    kdcField.setText(selectedBook.getKdc());
	    nameField.setText(selectedBook.getBook_name());
	    authorField.setText(selectedBook.getAuthor());
	    publisherField.setText(selectedBook.getPublisher());
	    if(selectedBook.getPublication_date() == null) {
	    	publicationDateField.setText("0000-00-00");
	    } else {
	    	publicationDateField.setText(String.valueOf(selectedBook.getPublication_date()));
	    }
	}
	
	private Date getPublicationDateField() {
		return Date.valueOf(publicationDateField.getText()) == 
				Date.valueOf("0000-00-00") ? 
				null : Date.valueOf(publicationDateField.getText());
	}
	
	private boolean isEmptyField(JTextField field) {
		return field.getText().isEmpty();
	}
	
	private Bookinfo isNoInput(String fieldName) {
		JOptionPane.showMessageDialog(this.getRootPane().getParent(), 
				fieldName+"은/는 필수 입력란 입니다.", "NO INPUT", JOptionPane.NO_OPTION);
		return null;
	}
}
