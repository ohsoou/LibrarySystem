package view.advertising;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.defaultcomponent.DefaultButton;

	/*
	 	[AdActionButton]
	 	버튼을 누르면 추천도서와 신간도서의 페널을 바꿔주고
	 	신간,추천 버튼의 색을 변경하여준다.
	 */
public class AdActionButton extends DefaultButton implements ActionListener{
	
	Boolean visible;
	public AdActionButton(Boolean visible,String text, int width, int height) {
		super(text);
		this.visible = visible;
		setPreferredSize(new Dimension(width,height));
		setBackground(new Color(225, 238, 246));
		setForeground(new Color(0, 78, 102));
		setFont(new Font("맑은 고딕", Font.BOLD, 25));
		
		decorate();
		addActionListener(this);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!visible) {
			AdCenterPanel.suggestBtn.setForeground(new Color(252, 190, 50));
			AdCenterPanel.newBtn.setForeground(new Color(0, 78, 102));

			AdCenterPanel.newBook.setVisible(false);
			AdCenterPanel.suggestPanel.setVisible(true);

			AdTopPanel.newTitle.setVisible(false);
			AdTopPanel.suggestTitle.setVisible(true);
		}else if(visible){
			AdCenterPanel.suggestBtn.setForeground(new Color(0, 78, 102));
			AdCenterPanel.newBtn.setForeground(new Color(252, 190, 50));
			AdCenterPanel.suggestPanel.setVisible(false);
			AdCenterPanel.newBook.setVisible(true);
			
			AdTopPanel.suggestTitle.setVisible(false);
			AdTopPanel.newTitle.setVisible(true);
		}
	}

}
