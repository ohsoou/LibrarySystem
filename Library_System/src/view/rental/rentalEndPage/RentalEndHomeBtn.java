package view.rental.rentalEndPage;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.Future;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import view.advertising.AdCenterPanel;
import view.advertising.AdGetImage;
import view.advertising.AdTopPanel;
import view.advertising.AdvertisingFrame;
import view.main.MainFrame;
import view.rental.UserSelection;

public class RentalEndHomeBtn extends JButton implements MouseListener{
	
	Border[] borders = new Border[3];
	
	public RentalEndHomeBtn(String path, int width, int height) {
		borders[0] = new LineBorder(new Color(0xe1eef6));
		borders[1] = new BevelBorder(BevelBorder.RAISED);
		borders[2] = new SoftBevelBorder(SoftBevelBorder.LOWERED);
		this.setBorder(borders[0]);
		this.setIcon(AdGetImage.makeImageIcon(path,width,height));	
		setBounds(720, 390, 150, 120);
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton btn = (JButton)e.getSource();
		JFrame df = (JFrame)btn.getRootPane().getParent();
		UserSelection.clearSelectedBook();	
		EndPageTimeLabel.future.cancel(true);
		EndPageTimeLabel.logOutTimer = 20;
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				MainFrame frame = new MainFrame();
				
				frame.setVisible(true);
				
			}
		});
		df.dispose();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		setBorder(borders[2]);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		setBorder(borders[2]);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setBorder(borders[1]);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setBorder(borders[0]);
		
	}

}
