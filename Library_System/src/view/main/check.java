package view.main;

import javax.swing.JFrame;

public class check extends JFrame{
	
	public check() {
		
		add(new MainPanel());
		
		setVisible(true);
		setBounds(700,200,980,600);
	}
	public static void main(String[] args) {
		new check();
	}

}
