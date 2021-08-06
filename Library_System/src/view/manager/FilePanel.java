package view.manager;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.component.DefaultButton;
import view.component.RoundTextField;

public class FilePanel extends JPanel {

	public FilePanel() {
		setLayout(new GridBagLayout());
		setBackground(new Color(244,244,244));
		GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        
        Container container = new Container();
		container.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		container.setPreferredSize(new Dimension(350, 80));
		
		JLabel textLabel = new JLabel("이미지");
        JTextField pathField = new RoundTextField(180, 30);
        JButton addButton = new DefaultButton("추가", 60, 30);
        
 
        constraints.gridx = 0;
        constraints.gridy = 0; 
        JLabel image = new JLabel();
        image.setIcon(new ImageIcon("./image/NoBookImage.PNG"));
        
        add(image, constraints);
        
        container.add(textLabel);
        container.add(pathField);
        container.add(addButton);
 
        constraints.gridx = 0;
        constraints.gridy = 1;     
        add(container, constraints);
        
        
	}

}
