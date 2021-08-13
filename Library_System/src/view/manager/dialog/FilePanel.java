package view.manager.dialog;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.dto.AllBookInfo;
import view.defaultcomponent.BookListWithSelectedBook;
import view.defaultcomponent.DefaultButton;
import view.defaultcomponent.DefaultPanel;
import view.defaultcomponent.RoundTextField;


public class FilePanel extends DefaultPanel {
	private JTextField pathField;
	private JLabel image;
	private File imageFile;

	public FilePanel(boolean update) {
		super(new Color(244, 240, 240));
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        
        Container container = new Container();
		container.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		container.setPreferredSize(new Dimension(350, 40));
		
		JLabel textLabel = new JLabel("이미지");
        pathField = new RoundTextField(220, 30);
        JButton addButton = new DefaultButton("찾기", 60, 30);
        addButton.addActionListener(new OpenFileChooserListener());
 
        constraints.gridx = 0;
        constraints.gridy = 0; 
        image = new JLabel();
        image.setPreferredSize(new Dimension(350, 220));
        setImage("./image/NoBookImage.PNG");
        image.setHorizontalAlignment(SwingConstants.CENTER);
        imageFile = null;
        
        if(update) {
        	BookListWithSelectedBook currentTableState = new BookListWithSelectedBook();
        	setImagePathField(currentTableState.getSelectedBook());
        	setImage(pathField.getText());
        }
        
        add(image, constraints);
        
        container.add(textLabel);
        container.add(pathField);
        container.add(addButton);
 
        constraints.gridx = 0;
        constraints.gridy = 1;     
        add(container, constraints);
        
        
	}

	class OpenFileChooserListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			BookImageFileChooser file = new BookImageFileChooser();
			file.setVisible(true);
			
			imageFile = file.getSelectedFile();
			
			String imagePath = file.getFilePath();
			if(imagePath != null) {
				pathField.setText(imagePath);
				setImage(imagePath);
			} else {
				pathField.setText("./image/NoBookImage.PNG");
				setImage("./image/NoBookImage.PNG");
			}
		}
	}
	
	public File getImageFile() {
		return imageFile;
	}
	
	private void setImagePathField(AllBookInfo seletedBook) {
		pathField.setText(seletedBook.getImagepath());
	}
	
	private void setImage (String path) {
		image.setIcon(getResizedImageIcon(path));
	}
	private ImageIcon getResizedImageIcon(String imagePath) {
		ImageIcon origin = new ImageIcon(imagePath);
		return new ImageIcon(origin.getImage().getScaledInstance(190, 220, Image.SCALE_SMOOTH));
	}
	
	
	
}
