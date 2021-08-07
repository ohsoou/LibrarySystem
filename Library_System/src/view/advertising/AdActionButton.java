package view.advertising;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	/*
	 	[AdActionButton]
	 	버튼을 누르면 추천도서와 신간도서의 페널을 바꿔주고
	 	신간,추천 버튼의 색을 변경하여준다.
	 */
public class AdActionButton implements ActionListener{

	int visible = 0;
	public AdActionButton(int visible) {
		this.visible = visible;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(visible == 0) {
			AdCenterPanel.btn[1].setForeground(new Color(0, 78, 102));
			AdCenterPanel.btn[0].setForeground(new Color(252, 190, 50));
			AdCenterPanel.newBook.setVisible(false);
			AdCenterPanel.suggestPanel.setVisible(true);
		}else if(visible == 1){
			AdCenterPanel.btn[0].setForeground(new Color(0, 78, 102));
			AdCenterPanel.btn[1].setForeground(new Color(252, 190, 50));
			AdCenterPanel.suggestPanel.setVisible(false);
			AdCenterPanel.newBook.setVisible(true);
		}
	}

}
