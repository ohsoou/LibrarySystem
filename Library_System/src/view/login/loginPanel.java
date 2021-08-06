package view.login;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.dao.StudentDao;
import model.dto.Student;

public class loginPanel extends JPanel{
	
	private final static int COMPONENT_SIZE = 7;
	
	public loginPanel() {
		setLayout(new GridBagLayout());
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(new Color(225, 238, 246)); 
		GridBagConstraints[] gbc = new GridBagConstraints[COMPONENT_SIZE];
		
		for(int i = 0; i < COMPONENT_SIZE; i++) {
			gbc[i] = new GridBagConstraints();
		}
		
		JLabel title = new loginTitleLable();
		JLabel idLabel = new idLabel();
		JLabel pwLabel = new pwLabel();
		JLabel errorLabel = new loginErrorLabel();
		
		JTextField idField = new idTextField();
		JTextField passwordField = new pwTextField();
		
		JButton jb = new loginButton();
		
		gbc[0].gridx = 0;
		gbc[0].gridy = 0;
		gbc[0].gridheight = 1;
		gbc[0].gridwidth = 2;
		gbc[0].fill = GridBagConstraints.BOTH;
		add(title,gbc[0]);
		
		gbc[1].gridx = 0;
		gbc[1].gridy = 1;
		add(idLabel,gbc[1]);
		
		gbc[2].gridx = 0;
		gbc[2].gridy = 2;
		add(pwLabel,gbc[2]);
		
		gbc[3].gridx = 1;
		gbc[3].gridy = 1;
		add(idField,gbc[3]);
		
		gbc[4].gridx = 1;
		gbc[4].gridy = 2;
		add(passwordField,gbc[4]);
		
		gbc[5].gridx = 0;
		gbc[5].gridy = 3;
		gbc[5].gridheight = 1;
		gbc[5].gridwidth = 2;
		gbc[5].fill = GridBagConstraints.BOTH;
		add(jb,gbc[5]);
		
		gbc[6].gridx = 0;
		gbc[6].gridy = 4;
		gbc[6].gridheight = 2;
		gbc[6].gridwidth = 2;
		gbc[6].fill = GridBagConstraints.BOTH;
		add(errorLabel,gbc[6]);
		
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String studentNumber="";
				String studentPassword="";
				ArrayList<Student> dtos;
				StudentDao dao = StudentDao.getInstance();				
				dtos = dao.listByStudentNum(idField.getText());
				
				if(dtos == null) {
					for(int i = 0; i < dtos.size(); ++i) {
						Student dto = dtos.get(i);
						studentNumber = dto.getStudent_num();
						studentPassword = dto.getStudent_password();
					}
				}
				
				String loginId = idField.getText();
				String loginPassword = passwordField.getText();
				
				boolean checkInputId = (loginId.equals("아이디")||loginId.length()==0);
				boolean checkInputPassword = (loginPassword.equals("비밀번호")||loginPassword.length()==0);
				
				if(checkInputId) {
					errorLabel.setText("아이디를 입력하세요");
				}else if(checkInputPassword) {
					errorLabel.setText("비밀번호를 입력하세요");
				}else if(!studentNumber.equals(loginId)){
					errorLabel.setText("아이디가 틀립니다");
				}else if(!studentPassword.equals(loginPassword)) {
					errorLabel.setText("비밀번호가 틀립니다");
				}else if (studentNumber.equals(loginId)&&studentPassword.equals(loginPassword)) {
					errorLabel.setText("로그인성공");
				}
			}		
		});
	}
}
