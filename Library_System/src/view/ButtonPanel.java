package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class manager extends JFrame{	
	private JPanel contentPane;
	private JButton DefaultBtn;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manager frame = new manager();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public manager() {		
		
		// ������ ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(980, 600);
		setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(225, 238, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// manager system ��
		JLabel lblLogin = new JLabel("<html>manager<br>system</html>");
		lblLogin.setFont(new Font("�ü�ü", Font.BOLD, 52));
		lblLogin.setForeground(new Color(0, 78, 102));
		lblLogin.getForeground();
		lblLogin.setBounds(20, 0, 200, 120);
		contentPane.add(lblLogin);
		
		DefaultBtn = new JButton("�߰�");
		DefaultBtn.setBounds(260, 55, 90, 35);
		DefaultBtn.setBackground(new Color(255, 95, 46)); // ��ư���
		DefaultBtn.setForeground(new Color(255, 255, 255)); //�ϴ� ���  ���ڻ�(0, 78, 102)��û���
		DefaultBtn.getForeground();
		DefaultBtn.setBorderPainted(false); 
		contentPane.add(DefaultBtn);
		
		DefaultBtn = new JButton("����");
		DefaultBtn.setBounds(400, 55, 90, 35);
		DefaultBtn.setBackground(new Color(255, 95, 46));
		DefaultBtn.setForeground(new Color(255, 255, 255));
		DefaultBtn.getForeground();
		DefaultBtn.setBorderPainted(false); 
		contentPane.add(DefaultBtn);
		
		
		DefaultBtn = new JButton("����");
		DefaultBtn.setBounds(540, 55, 90, 35);
		DefaultBtn.setBackground(new Color(255, 95, 46));
		DefaultBtn.setForeground(new Color(255, 255, 255));
		DefaultBtn.getForeground();
		DefaultBtn.setBorderPainted(false); 
		contentPane.add(DefaultBtn);
		
		
		DefaultBtn = new JButton("��ü����");
		DefaultBtn.setBounds(680, 55, 90, 35);
		DefaultBtn.setBackground(new Color(255, 95, 46));
		DefaultBtn.setForeground(new Color(255, 255, 255));
		DefaultBtn.getForeground();
		DefaultBtn.setBorderPainted(false); 
		contentPane.add(DefaultBtn);
		
		DefaultBtn = new JButton("�ݱ�");
		DefaultBtn.setBounds(820, 55, 90, 35);
		DefaultBtn.setBackground(new Color(255, 95, 46));
		DefaultBtn.setForeground(new Color(255, 255, 255));
		DefaultBtn.getForeground();
		DefaultBtn.setBorderPainted(false); 
		contentPane.add(DefaultBtn);

		setVisible(true);	
		  
		// �׼�
		DefaultBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
			}
		});
		

	}
}
