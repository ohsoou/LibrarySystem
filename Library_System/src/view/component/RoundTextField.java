package view.component;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextField;

public class RoundTextField extends JTextField{
	private Shape shape;
	
	public RoundTextField() {
		this(100, 40);
	}
	
	public RoundTextField(int width, int hight) {
		setPreferredSize(new Dimension(width, hight));
		setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
        setOpaque(false); // As suggested by @AVD in comment.
    }
	
	
    protected void paintComponent(Graphics g) {
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
         super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
         g.setColor(getForeground());
         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }
    public boolean contains(int x, int y) {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
         }
         return shape.contains(x, y);
    }

}
