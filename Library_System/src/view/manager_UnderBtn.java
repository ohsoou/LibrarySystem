package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
   
public class manager_UnderBtn extends DefaultFrame implements ActionListener{
	private JPanel contentPane;
	private JButton DefaultBtn;
	
	private ButtonGroup bg = new ButtonGroup();	
	private JToggleButton DefaultBtn1= new JToggleButton();
	private JToggleButton DefaultBtn2= new JToggleButton();
	private JToggleButton DefaultBtn3= new JToggleButton();
	private JToggleButton DefaultBtn4= new JToggleButton();
	TablePanel TablePanel = new TablePanel();
	
	public manager_UnderBtn() {
		add(TablePanel);
		
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setBackground(new Color(225, 238, 246));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);

		DefaultBtn = new JButton("<");
		DefaultBtn.setBounds(330, 420, 45, 35);
		DefaultBtn.setBackground(new Color(255, 95, 46));
		DefaultBtn.setForeground(new Color(255, 255, 255));
		DefaultBtn.getForeground();
		DefaultBtn.setBorderPainted(false); 
		TablePanel.add(DefaultBtn);
				
		DefaultBtn = new JButton(">");
		DefaultBtn.setBounds(630, 420, 45, 35);
		DefaultBtn.setBackground(new Color(255, 95, 46));
		DefaultBtn.setForeground(new Color(255, 255, 255));
		DefaultBtn.getForeground();
		DefaultBtn.setBorderPainted(false); 
		TablePanel.add(DefaultBtn);

		// toggle
		DefaultBtn1 = new JToggleButton("1");
		DefaultBtn1.setBounds(390, 420, 45, 35);
		DefaultBtn1.setBackground(new Color(255, 95, 46));
		DefaultBtn1.setForeground(new Color(255, 255, 255));
		DefaultBtn1.getForeground();
		DefaultBtn1.setBorderPainted(false); 
		TablePanel.add(DefaultBtn1);
				
		DefaultBtn2 = new JToggleButton("2");	
		DefaultBtn2.setBounds(450, 420, 45, 35);
		DefaultBtn2.setBackground(new Color(255, 95, 46));
		DefaultBtn2.setForeground(new Color(255, 255, 255));
		DefaultBtn2.getForeground();
		DefaultBtn2.setBorderPainted(false); 
		TablePanel.add(DefaultBtn2);

				
		DefaultBtn3 = new JToggleButton("3");
		DefaultBtn3.setBounds(510, 420, 45, 35);
		DefaultBtn3.setBackground(new Color(255, 95, 46));
		DefaultBtn3.setForeground(new Color(255, 255, 255));
		DefaultBtn3.getForeground();
		DefaultBtn3.setBorderPainted(false); 
		TablePanel.add(DefaultBtn3);
				
		DefaultBtn4 = new JToggleButton("4");
		DefaultBtn4.setBounds(570, 420, 45, 35);
		DefaultBtn4.setBackground(new Color(255, 95, 46));
		DefaultBtn4.setForeground(new Color(255, 255, 255));
		DefaultBtn4.getForeground();
		DefaultBtn4.setBorderPainted(false); 
		TablePanel.add(DefaultBtn4);
		
		bg.add(DefaultBtn1);
		bg.add(DefaultBtn2);
		bg.add(DefaultBtn3);
		bg.add(DefaultBtn4);

		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}