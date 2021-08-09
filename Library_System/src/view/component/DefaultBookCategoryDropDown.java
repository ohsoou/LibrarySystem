package view.component;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;

@SuppressWarnings({ "serial", "rawtypes" })
public class DefaultBookCategoryDropDown extends JComboBox {
	private static String[] categories = { "��ü", "å�̸�", "����", "���ǻ�" };

	@SuppressWarnings("unchecked")
	public DefaultBookCategoryDropDown() {
		super(categories);
		
		setPreferredSize(new Dimension(150,40));
		setFont(new Font("���� ���", Font.PLAIN, 14));
		
		addActionListener(this);
		
	}
}