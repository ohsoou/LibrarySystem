package view.manager;

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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import view.component.DefaultButton;
import view.component.RoundTextField;

public class FilePanel extends JPanel {
	private JTextField pathField;
	private JLabel image;

	public FilePanel() {
		setLayout(new GridBagLayout());
		setBackground(new Color(244, 240, 240));
		GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        
        Container container = new Container();
		container.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		container.setPreferredSize(new Dimension(350, 40));
		
		JLabel textLabel = new JLabel("이미지");
        pathField = new RoundTextField(180, 30);
        JButton addButton = new DefaultButton("찾기", 60, 30);
        addButton.addActionListener(new OpenFileChooserListener());
        
 
        constraints.gridx = 0;
        constraints.gridy = 0; 
        image = new JLabel();
        image.setPreferredSize(new Dimension(350, 220));
        image.setIcon(getresizedImageIcon("./image/NoBookImage.PNG"));
        image.setHorizontalAlignment(SwingConstants.CENTER);
        
        add(image, constraints);
        
        container.add(textLabel);
        container.add(pathField);
        container.add(addButton);
 
        constraints.gridx = 0;
        constraints.gridy = 1;     
        add(container, constraints);
        
        
	}
	
	private ImageIcon getresizedImageIcon(String imagePath) {
		ImageIcon origin = new ImageIcon(imagePath);
		return new ImageIcon(origin.getImage().getScaledInstance(190, 220, Image.SCALE_SMOOTH));
	}

	class OpenFileChooserListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			
			BookImageFileChooser file = new BookImageFileChooser();
			file.setVisible(true);
			
			String imagePath = file.getFilePath();
			if(imagePath != null) {
				pathField.setText(imagePath);
				image.setIcon(getresizedImageIcon(imagePath));
			}
		}
	}
	
	
}
