package view.extend;


import javax.swing.JPanel;

import view.defaultcomponent.DefaultFrame;
import view.main.MainFrame;


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


		add(extendPanel);
	}
	
	private JPanel getExtendPanel() {
		return extendPanel;
	}
	
	public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ExtendFrame frame = new ExtendFrame();
                frame.setVisible(true);
            }
        });

    }

}
