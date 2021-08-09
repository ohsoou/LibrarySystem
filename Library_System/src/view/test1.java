package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;


public class test1 extends DefaultFrame implements ActionListener{
	
	private JPanel contentPane;
	 Cards cards;
	   
	   public test1(){
	      
		  contentPane = new JPanel();
		  contentPane.setBackground(new Color(225, 238, 246));
		  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		   
	      addButton("<", contentPane);
	      addButton(">", contentPane);

	      add(contentPane, BorderLayout.NORTH);
	      cards = new Cards();
	      add(cards, BorderLayout.CENTER);
	      
	      setVisible(true);
	      
	   }
	   
	   public void addButton(String str, Container target){
	      JButton bt = new JButton(str);
	      bt.addActionListener(this);
	      target.add(bt);
	   }
	   
	   class Cards extends JPanel{
	      CardLayout layout;
	      
	      public Cards(){
	         layout = new CardLayout();
	         setLayout(layout);
	         for(int i=1 ; i<=10 ; i++){
	            
	        	JToggleButton bt = new JToggleButton();
	            bt.setText("현재카드 번호는" + i + "입니다");
	            

	            
	            add(bt, BorderLayout.CENTER);
	         }
	         
	      }//end of Cards constructor
	      
	   }//end of Cards class
	   
	   @Override
	   public void actionPerformed(ActionEvent e) {
	         
	         
	         if(e.getActionCommand().equals("<")){
	            cards.layout.previous(cards);
	         }
	         
	         if(e.getActionCommand().equals(">")){
	            cards.layout.next(cards);
	         }
	         
	   }

	public static void main(String[] args) {
		test1 frame = new test1();
	}

}
