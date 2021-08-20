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

public class EndPageTimeLabel extends JLabel {

	public static int logOutTimer = 20;
	public static ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
	public static Future<?> future;

	public EndPageTimeLabel() {

		Runnable runnable = new Runnable() {

			public void run() {
				if (logOutTimer >= 0) {
					setText(logOutTimer-- + "ÃÊ ÈÄ ÀÚµ¿ ·Î±×¾Æ¿ôµË´Ï´Ù.");

				} else {
					UserSelection.clearSelectedBook();
					LoginHost.setStudent_name(null);
					LoginHost.setStudent_num(null);
					LoginHost.setStudent_password(null);

					future.cancel(true);
					logOutTimer = 20;
					new AdvertisingFrame();
					RentalEndFrame.frameRental.setVisible(false);
				}
			}
		};
		future = service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);

		setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		setForeground(new Color(000, 000, 000));
		setBackground(new Color(225, 238, 246));
		setBorder(new LineBorder(new Color(0xe1eef6)));
		setBounds(250, 350, 450, 120);
	}
}