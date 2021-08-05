package view.main;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPage extends JFrame{
	
	
	public MainPage() {
		
		JPanel mainPanel = new MainPanel();
		
		
		add(mainPanel);
		setBounds(700,200,980,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MainPage();
	}
	
	

}
