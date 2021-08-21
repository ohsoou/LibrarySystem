package view.rental.rentalEndPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import view.advertising.AdvertisingFrame;
import view.login.LoginHost;
import view.rental.UserSelection;

public class EndPageTimeLabel extends JLabel {

	private int logOutTimer = 20;
	public static Timer timer;
	

	public EndPageTimeLabel(RentalEndFrame df) {
		timer = new Timer();
		
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if (logOutTimer > 0) {
					setText(logOutTimer-- + "초 후 자동 로그아웃됩니다.");

				} else if(logOutTimer == 0){
					setText(logOutTimer-- + "초 후 자동 로그아웃됩니다.");
					
					
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
		
		timer.scheduleAtFixedRate(task, 500, 1000);

		setFont(new Font("맑은 고딕", Font.BOLD, 30));
		setForeground(new Color(000, 000, 000));
		setBackground(new Color(225, 238, 246));
		setBorder(new LineBorder(new Color(0xe1eef6)));
		setPreferredSize(new Dimension(510, 120));
		setHorizontalAlignment(LEFT);
	}
}