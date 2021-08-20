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
	private JPanel extendPanel;
	
	public ExtendFrame() {
		super();
		setComp();
		setDesign();
		setFrame();
	}
	
	@Override
	public void setComp() {
		extendPanel = new ExtendPanel();
		
	}
	
	@Override
	public void setDesign() {
		//layout
		add(extendPanel);
	}
	
	private JPanel getExtendPanel() {
		return extendPanel;
	}
	
	
	
	public static void main(String[] args) {
		ExtendFrame frame = new ExtendFrame();
		frame.setVisible(true);
	}
}
