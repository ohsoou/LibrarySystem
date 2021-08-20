package view.rental.rentalEndPage;

import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import view.advertising.AdvertisingFrame;
import view.login.LoginHost;
import view.rental.UserSelection;

public class EndPageTimeLabel extends JLabel {

	public static int logOutTimer = 20;
	public static ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
	public static Future<?> future;

	public EndPageTimeLabel(JFrame df) {

//		Runnable runnable = new Runnable() {
//
//			public void run() {
//				if (logOutTimer >= 0) {
//					setText(logOutTimer-- + "초 후 자동 로그아웃됩니다.");
//
//				} else {
//					UserSelection.clearSelectedBook();
//					LoginHost.setStudent_name(null);
//					LoginHost.setStudent_num(null);
//					LoginHost.setStudent_password(null);
//
//					future.cancel(true);
//					logOutTimer = 20;
//					df.dispose();
//					new AdvertisingFrame();
//					
//				}
//			}
//		};
//		future = service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
		
		Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if (logOutTimer >= 0) {
					setText(logOutTimer-- + "초 후 자동 로그아웃됩니다.");

				} else {
					UserSelection.clearSelectedBook();
					LoginHost.setStudent_name(null);
					LoginHost.setStudent_num(null);
					LoginHost.setStudent_password(null);

					logOutTimer = 20;
					df.dispose();
					new AdvertisingFrame();
					timer.cancel();
				}
				
			}
		};
		
		timer.scheduleAtFixedRate(task, 2, 1000);

		setFont(new Font("맑은 고딕", Font.BOLD, 30));
		setForeground(new Color(000, 000, 000));
		setBackground(new Color(225, 238, 246));
		setBorder(new LineBorder(new Color(0xe1eef6)));
		setBounds(250, 350, 450, 120);
	}
}