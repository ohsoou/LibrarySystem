package view.rental.rentalEndPage;

import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import view.advertising.AdvertisingFrame;
import view.login.LoginHost;
import view.rental.UserSelection;

public class EndPageTimeLabel extends JLabel {

	int logOutTimer = 20;
	public static Timer timer;

	public EndPageTimeLabel(JFrame df) {
		
		timer = new Timer();
		
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if (logOutTimer >= 0) {
					setText(logOutTimer-- + "�� �� �ڵ� �α׾ƿ��˴ϴ�.");

				} else {
					UserSelection.clearSelectedBook();
					LoginHost.setStudent_name(null);
					LoginHost.setStudent_num(null);
					LoginHost.setStudent_password(null);

					logOutTimer = 20;
					df.dispose();
					JFrame frame = new AdvertisingFrame();
					timer.cancel();
				}
				
			}
		};
		
		timer.scheduleAtFixedRate(task, 20, 1000);

		setFont(new Font("���� ����", Font.BOLD, 30));
		setForeground(new Color(000, 000, 000));
		setBackground(new Color(225, 238, 246));
		setBorder(new LineBorder(new Color(0xe1eef6)));
		setBounds(250, 350, 450, 120);
	}
}