package view.extend;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.defaultcomponent.DefaultFrame;
import view.login.LoginFrame;
import view.login.LoginHost;
import view.returns.ReturnTitleLable;

public class ExtendFrame extends DefaultFrame{
	private JPanel extendTable;
	private JLabel title;
	public ExtendFrame() {
		super();
		setComp();
		setDesign();
		setFrame();
	}
	@Override
	public void setComp() {
		extendTable = new ExtendTable();
		title = new ReturnTitleLable(ExtendTable.student_name+"님의 연장 페이지");
	}
	
	@Override
	public void setDesign() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
		
		add(title);
		add(extendTable);
	}
	
	private JLabel getExtendTitle() {
		return title;
	}
	
	private Container setTablePane() {
		
		Container con = new Container();
		con.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(0, 0, 5, 0);
		
		constraints.gridy=0;
		con.add(title,constraints);
		
		constraints.gridy=1;
		con.add(extendTable,constraints);
		
		add(con);
		
		return con;
	}
	
	public static void main(String[] args) {
		ExtendFrame frame = new ExtendFrame();
		frame.setVisible(true);
	}
}
