package view.advertising.details;

import java.awt.Font;

import javax.swing.JLabel;

public class AdDetailsLabel extends JLabel{
	
	public AdDetailsLabel(String text, int x, int y, int width, int height) {
		this.setText(text);
		this.setBounds(x, y, width, height);
		setFont(new Font("맑은 고딕", Font.BOLD, 25));
	}

}
