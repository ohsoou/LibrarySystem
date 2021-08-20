package view.returns;




import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class PrevBtnLabel extends JLabel{	
	public PrevBtnLabel() {
		super();
		
		String url = "./image/componentImg/prev_arrow_btn.png";
		ImageIcon icon = new ImageIcon(url);
		setIcon(icon);
		setHorizontalAlignment(JLabel.LEFT);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 클릭 시 이전화면 
			}
		});
	}
	
	
}
