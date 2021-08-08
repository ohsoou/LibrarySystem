package view;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TablePanel extends JPanel{
	private JPanel contentPane;
	
	public TablePanel() {	
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	}
 
	private void setContentPane(JPanel contentPane2) {

		
	}

}
