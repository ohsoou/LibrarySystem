package view.rental.rentalEndPage;

import java.awt.Color;
import java.awt.Font;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;

import view.advertising.AdvertisingFrame;
import view.rental.UserSelection;
import view.rental.selectBtnAction;

public class EndPageTimeLabel extends JLabel{
	
	int logOutTimer = 20;
	ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
	
	public EndPageTimeLabel() {	
		Runnable runnable = new Runnable() {
			public void run() {
				if(logOutTimer >= 0) {
				setText(logOutTimer-- +"초 후 자동 로그아웃됩니다.");
				
				}else {				
					UserSelection.clearSelectedBook();
					selectBtnAction.frame.dispose();
					service.shutdown();
					java.awt.EventQueue.invokeLater(new Runnable() {
						public void run() {
							AdvertisingFrame frame = new AdvertisingFrame();
							frame.setVisible(true);
						}
					});
				}
			}
		};
				service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
				
		setFont(new Font("맑은 고딕", Font.BOLD, 30));
		setForeground(new Color(000,000,000));
		setBounds(270, 350, 800, 120);
	}

	


}	


