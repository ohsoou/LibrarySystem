
package view.advertising;

import java.awt.FlowLayout;
import javax.swing.JLabel;

import view.defaultcomponent.DefaultPanel;

public class AdTitlePanel extends DefaultPanel{	
	
	public AdTitlePanel() {		
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 50, 40));	
		JLabel title = new AdTitleLabel("<html><span style=color:\"Yellow\">�̴���&nbsp;��õ&nbsp;����</span><br>"
				+ "<font size=\"5\">�����Ͻø�&nbsp;�α���&nbsp;��&nbsp;�ٷ�&nbsp;�뿩�Ͻ�&nbsp;��&nbsp;�ֽ��ϴ�.</span></html>");
		
		add(title);

	}
}



