package view.returns;

import java.awt.Container;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;



import javax.swing.JLabel;
import javax.swing.JPanel;


import view.defaultcomponent.DefaultFrame;

public class ReturnFrame extends DefaultFrame{
	private JPanel returnTable;
	private JLabel title;
	
	public ReturnFrame() {
		super();
		setComp();
		setDesign();
		setFrame();
	 
	}
	
	@Override
	public void setComp() {
		returnTable = new ReturnTable();
		title = new ReturnTitleLable("반납 페이지 입니다.");
	}
	
	@Override
	public void setDesign() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
		
		add(title);
		add(returnTable);
	}
	
	private JLabel getReturnTitle() {
		return title;
	}
	
	private Container setTablePane() {
		// layout
		Container con = new Container();
		con.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0, 0, 5, 0);
		
		con.add(returnTable,constraints);
		
		add(con);
		
		
		return con;
	}
	
	public static void main(String[] args) {
		ReturnFrame frame = new ReturnFrame();
		frame.setVisible(true);
	}
} 
 