package view.main;

import java.awt.Color;

import javax.swing.JPanel;

import view.component.DefaultPanel;

public class TopPanel extends DefaultPanel{
	
	/*
	 	[TopPanel]
	 	���� ��ο� ��ܺκ��̸� ������Ʈ�δ� �ڷΰ��� ��ư �ϳ��� ������ �ֽ��ϴ�.
	*/
	int x = 50;
	int y = 50;
	int width = 50;
	int height = 50;
	String image = "./image/componentImg/main_btn_04.png";
	String nextStr = "back";
	
	public TopPanel() {
		
		MainButton btn = new MainButton(image,50,50);
		setLayout(null);
		btn.setBounds(x,y,width,height);
		btn.addActionListener(new MainNextAction(nextStr));
		
		add(btn);
		
		setBackground(new Color(0xe1eef6));
		setBounds(0,0,980,100);
		setVisible(true);		
	}
}
