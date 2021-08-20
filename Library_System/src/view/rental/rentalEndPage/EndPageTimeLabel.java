package view.rental.rentalEndPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import model.dao.AllBookInfoDao;
import view.advertising.AdCenterPanel;
import view.advertising.AdvertisingFrame;
import view.advertising.NewBookPanel;
import view.advertising.SuggestionBookPanel;
import view.login.LoginHost;
import view.rental.UserSelection;

public class EndPageTimeLabel extends JButton{
	
	public static int logOutTimer = 20;
	public static ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
	public static Future<?> future;
	
	public EndPageTimeLabel() {
		
		LineBorder line = new LineBorder(new Color(0xe1eef6));
		JLabel label = new JLabel();
		
		Runnable runnable = new Runnable() {
			
			public void run() {
				if(logOutTimer >= 0) {
					label.setText(logOutTimer-- +"ÃÊ ÈÄ ÀÚµ¿ ·Î±×¾Æ¿ôµË´Ï´Ù.");

				}else {
					UserSelection.clearSelectedBook();
					LoginHost.setStudent_name(null);
					LoginHost.setStudent_num(null);
					LoginHost.setStudent_password(null);
					
					future.cancel(true);
					logOutTimer = 20;
					 java.awt.EventQueue.invokeLater(new Runnable() {
						public void run() {
							AdCenterPanel.suggestPanel = new SuggestionBookPanel();
							AdCenterPanel.newBook = new NewBookPanel();				
							AdvertisingFrame.frame = new AdvertisingFrame();
							AdCenterPanel.btn[1].doClick();
						}
					});
					 rentalEndFrame.frameRental.setVisible(false);
			}
			}
		};
		future  = service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
		
		label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		label.setForeground(new Color(000,000,000));
		label.setBackground(new Color(225, 238, 246));
		add(label);
		
		setBackground(new Color(225, 238, 246));
		setBorder(line);
		setBounds(250, 350, 450, 120);
	}
	
	
	
	
	
}	