package view.advertising;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;

import model.dto.Student;

public class AdTitleLabel extends JLabel{
	
	
	public AdTitleLabel(String string) {
		
		super("<html><span style=color:\"Yellow\">�̴���&nbsp;��õ&nbsp;����</span><br>"
				+ "<font size=\"5\">�����Ͻø�&nbsp;�α���&nbsp;��&nbsp;�ٷ�&nbsp;�뿩�Ͻ�&nbsp;��&nbsp;�ֽ��ϴ�.</span></html>");
		setFont(new Font("�ü�ü", Font.BOLD, 52));
		setForeground(new Color(0, 78, 102));
		setBounds(20, 0, 200, 120);
	}
	
}
