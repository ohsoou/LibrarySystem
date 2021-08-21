package view.rental.rentalEndPage;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


import view.defaultcomponent.DefaultFrame;

public class RentalEndFrame extends DefaultFrame {

	private final static String path = "./image/componentImg/rentalEnd_btn.png";

	private JLabel time;
	private JLabel label;
	private JButton home;
	private JPanel table;
	private Container con;
	
	public RentalEndFrame() {
		super();
		setFrame();
		setComp();
		setDesign();
	}

	@Override
	public void setComp() {
		time = new EndPageTimeLabel(this);
		label = new EndpageLabel();
		home = new RentalEndHomeBtn(path, 150, 150);
		table = new EndPanel();
		con = new Container();
	}

	@Override
	public void setDesign() {
		con.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		con.setPreferredSize(new Dimension(900, 300));
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));
		
		add(label);
		add(table);
		
		con.add(time);
		con.add(home);
		
		add(con);
		
		

	}

	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				RentalEndFrame frame = new RentalEndFrame();
				frame.setVisible(true);
			}
		});
	}

}
