
package view.advertising;

import java.awt.FlowLayout;
import javax.swing.JLabel;

import view.defaultcomponent.DefaultPanel;

public class AdTitlePanel extends DefaultPanel{	
	
	public AdTitlePanel() {		
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 50, 40));	
		JLabel title = new AdTitleLabel("<html><span style=color:\"Yellow\">이달의&nbsp;추천&nbsp;도서</span><br>"
				+ "<font size=\"5\">선택하시면&nbsp;로그인&nbsp;후&nbsp;바로&nbsp;대여하실&nbsp;수&nbsp;있습니다.</span></html>");
		
		add(title);

	}
}



