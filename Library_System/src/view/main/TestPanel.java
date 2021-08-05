package view.main;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestPanel extends JFrame{
	
public TestPanel() {
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.black);
		
		add(mainPanel);
		
		setBounds(700,200,980,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new TestPanel();
	}
}
