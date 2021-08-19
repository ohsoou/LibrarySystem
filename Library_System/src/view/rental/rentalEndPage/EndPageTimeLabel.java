package view.rental.rentalEndPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import view.advertising.AdCenterPanel;
import view.advertising.AdTopPanel;
import view.advertising.AdvertisingFrame;
import view.rental.UserSelection;
import view.rental.selectBtnAction;

public class EndPageTimeLabel extends JButton implements ActionListener{
	
	public static int logOutTimer = 20;
	public static ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
	
	public EndPageTimeLabel() {
		
		LineBorder line = new LineBorder(new Color(0xe1eef6));
		JLabel label = new JLabel();
		
		Runnable runnable = new Runnable() {
			
			public void run() {
				if(logOutTimer >= 0) {
					label.setText(logOutTimer-- +"ÃÊ ÈÄ ÀÚµ¿ ·Î±×¾Æ¿ôµË´Ï´Ù.");

				}else {	
					UserSelection.clearSelectedBook();					
					service.shutdown();
					java.awt.EventQueue.invokeLater(new Runnable() {
						public void run() {
							AdvertisingFrame frame = new AdvertisingFrame();
							frame.setVisible(true);					
						}
					});
					rentalEndFrame.frameRental.dispose();
				}
			}
		};
		service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
		label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		label.setForeground(new Color(000,000,000));
		label.setBackground(new Color(225, 238, 246));
		add(label);
		
		setBackground(new Color(225, 238, 246));
		setBorder(line);
		setBounds(250, 350, 450, 120);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		JFrame df = (JFrame)btn.getRootPane().getParent();
		UserSelection.clearSelectedBook();
		
		service.shutdown();
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				AdvertisingFrame frame = new AdvertisingFrame();
				frame.setVisible(true);
			}
		});
		df.dispose();
		
	}

	


}	


