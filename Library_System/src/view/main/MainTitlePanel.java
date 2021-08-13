
package view.main;

import java.awt.FlowLayout;
import javax.swing.JLabel;

import view.defaultcomponent.DefaultPanel;
import view.defaultcomponent.DefaultTablePanel;

public class MainTitlePanel extends DefaultPanel{	
	
	public MainTitlePanel() {		
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 50, 40));	
		JLabel title = new MainTitleLabel("<html>Smart&nbsp;Library&nbsp;System</html>");
		
		add(title);

	}
}



