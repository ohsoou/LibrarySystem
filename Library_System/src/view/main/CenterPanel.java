package view.main;

import java.awt.Color;


public class CenterPanel extends TopPanel {

	/*
	 * [UnderPanel] ���� ��ο� �ϴ� �κ��̸� ������Ʈ�δ� �뿩,�ݳ�,���� ��ư�� ������ �ֽ��ϴ�.
	 */
	String[] images = { "./image/componentImg/main_btn_01.png", "./image/componentImg/main_btn_02.png",
			"./image/componentImg/main_btn_03.png" };
	String[] nextStr = { "rental", "return", "extention" };
	MainButton[] btn = new MainButton[3];

	public CenterPanel() {
		x = 90;
		y = 150;
		width = 200;
		height = 300;
		setLayout(null);

		for (int i = 0; i < btn.length; ++i) {
			btn[i] = new MainButton(images[i], 200, 300);
			btn[i].addActionListener(new MainNextAction(nextStr[i]));
			btn[i].setBounds(x, y, width, height);
			x += 300;
			add(btn[i]);
		}

		setBackground(new Color(0xe1eef6));
		setBounds(0, 0, 980, 600);
		setVisible(true);

	}
}