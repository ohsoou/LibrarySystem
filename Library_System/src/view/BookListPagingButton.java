package view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToggleButton;

public class  BookListPagingButton extends JButton{
	private JButton DefaultButton;
	private ButtonGroup ButtonGroup;	
	private JToggleButton ToggleButton;
	private TablePanel TablePanel = new TablePanel();
	 
	public BookListPagingButton (String text) {
		DefaultButton = new JButton(text);
		DefaultButton.setBorderPainted(false); 
		TablePanel.add(DefaultButton);
	}
	
	public void JToggleButton(String text) {	
		ToggleButton = new JToggleButton(text);
		ToggleButton.setBorderPainted(false); 
		TablePanel.add(ToggleButton);
		
		ButtonGroup.add(ToggleButton);	
	}
	
}
