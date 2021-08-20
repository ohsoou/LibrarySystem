package view.returns;


import javax.swing.JPanel;

import view.defaultcomponent.DefaultFrame;

public class ReturnFrame extends DefaultFrame{
	private JPanel returnPanel;

	
	public ReturnFrame() {
		super();
		setComp();
		setDesign();
		setFrame();
	
	}
	
	@Override
	public void setComp() {
		returnPanel =new ReturnPanel();
		
	}
	
	@Override
	public void setDesign() {
		// layout
		add(returnPanel);
		
	}
	
	private JPanel getReturnPanel() {
		return returnPanel;
	}
	
	
	public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReturnFrame frame = new ReturnFrame();
                frame.setVisible(true);
            }
        });

    }
} 