package view.component;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;

@SuppressWarnings({ "serial", "rawtypes" })
public class DefaultBookCategoryDropDown extends JComboBox {
	private static String[] categories = { "전체", "책이름", "저자", "출판사" };

	@SuppressWarnings("unchecked")
	public DefaultBookCategoryDropDown() {
		super(categories);
		
		setPreferredSize(new Dimension(150,40));
		setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		
		addActionListener(this);
		
	}
}