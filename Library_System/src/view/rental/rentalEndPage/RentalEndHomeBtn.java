package view.rental.rentalEndPage;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;

import view.advertising.AdGetImage;
import view.main.MainFrame;
import view.rental.UserSelection;

public class RentalEndHomeBtn extends JButton implements MouseListener{
	
	Border border;
	
	public RentalEndHomeBtn(String path, int width, int height) {
		border = new SoftBevelBorder(SoftBevelBorder.RAISED);
		this.setBorder(null);
		this.setIcon(AdGetImage.makeImageIcon(path,width,height));	
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		setPreferredSize(new Dimension(150, 120));
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		RentalEndFrame df = (RentalEndFrame)btn.getRootPane().getParent();
		UserSelection.clearSelectedBook();	
		EndPageTimeLabel.timer.cancel();
		
		new MainFrame();
		df.dispose();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		setBorder(border);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		setBorder(border);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setBorder(border);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setBorder(null);
		
	}

}
