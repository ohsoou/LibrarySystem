package view.login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.border.Border;

public class loginButton extends JButton{
	public loginButton() {
		setText("Login");
		setFont(new Font("¸¼Àº °íµñ",Font.BOLD | Font.PLAIN, 15));
		setForeground(Color.WHITE);
		setBackground(new Color(255, 95, 46));
		
		setBorder(new RoundedBorder(10));
		
	}
}

class RoundedBorder implements Border {

    private int radius;


    RoundedBorder(int radius) {
        this.radius = radius;
    }


    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }


    public boolean isBorderOpaque() {
        return true;
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}