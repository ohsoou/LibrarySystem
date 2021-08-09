package view.manager.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import model.dto.Bookinfo;
import view.component.DefaultPanel;
import view.component.RoundTextField;

public class ManagerDialog extends JDialog{
	private FormPanel form;
	private FilePanel image;
	private JTextField summaryField;
	private Bookinfo book;
	public ManagerDialog(JFrame frame, String title) {
		super(frame, title);
		this.setLocation(100, 100);
		getContentPane().setBackground(new Color(244,240,240));
		setLayout(new BorderLayout());
		
		// top (title)
		JLabel pageTitle = new JLabel(title);
		Border border = pageTitle.getBorder();
	    Border margin = new EmptyBorder(20,50,0,0);
	    pageTitle.setBorder(new CompoundBorder(border, margin));
		pageTitle.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 30));
		
		add(pageTitle, "North");
		
		// center(form)
		JPanel center = new DefaultPanel(new Color(244,240,240));
		this.form = new FormPanel();
		this.image = new FilePanel();
		center.setLayout(new FlowLayout());
		center.add(form);
		center.add(image);
		
		JPanel summary = new DefaultPanel(new Color(244,240,240));
		JLabel summaryLabel = new JLabel("¡Ÿ∞≈∏Æ");
		border = summaryLabel.getBorder();
	    margin = new EmptyBorder(0,0,0,20);
	    summaryLabel.setBorder(new CompoundBorder(border, margin));
        this.summaryField = new RoundTextField(550, 50);
		
        summary.add(summaryLabel);
		summary.add(summaryField);
		center.add(summary);
		add(center, "Center");
		
		// bottom (button)
		JPanel bottom = new ButtonPanel(title);
		add(bottom, "South");

		setSize(730, 580);
	
	}
	
	public Bookinfo getBook() {
		book = form.getBook();
        book.setSummary(summaryField.getText());
        if(image.getImageFile() != null) {
        	book.setImagepath("./image/" + image.getImageFile().getName());
        } else {
        	book.setImagepath("./image/NoBookImage.PNG");
        }
        return book;
	}
	
	public File getImageFile() {
		return image.getImageFile();
	}

}
