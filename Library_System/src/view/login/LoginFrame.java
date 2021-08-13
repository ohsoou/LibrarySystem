package view.login;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.dao.StudentDao;
import model.dto.Student;
import view.defaultcomponent.DefaultFrame;

public class LoginFrame extends DefaultFrame {

	private final static int COMPONENT_SIZE = 7;

	private JLabel title;
	private JLabel idLabel;
	private JLabel pwLabel;
	private JButton jb;
	
	private JLabel errorLabel;
	private JTextField idField;
	private JTextField passwordField;
	
	private LoginHost studentInfo;
	
	public LoginFrame() {
		super();
		studentInfo = new LoginHost();
		setFrame();

		setComp();
		setDesign();
	}

	@Override
	public void setComp() {
		title = new LoginTitleLable();
		idLabel = new IdLabel();
		pwLabel = new PwLabel();
		errorLabel = new LoginErrorLabel();

		idField = new IdTextField();
		passwordField = new PwTextField();

		jb = new LoginButton();
		jb.addActionListener(new LoginListener());
	}

	@Override
	public void setDesign() {
		setLayout(new GridBagLayout());

		GridBagConstraints[] gbc = new GridBagConstraints[COMPONENT_SIZE];

		for (int i = 0; i < COMPONENT_SIZE; i++) {
			gbc[i] = new GridBagConstraints();
			gbc[i].insets = new Insets(5, 5, 5, 5);
		}
		gbc[0].gridx = 0;
		gbc[0].gridy = 0;
		gbc[0].gridheight = 1;
		gbc[0].gridwidth = 2;
		gbc[0].fill = GridBagConstraints.BOTH;
		add(title, gbc[0]);

		gbc[1].gridx = 0;
		gbc[1].gridy = 1;
		add(idLabel, gbc[1]);

		gbc[2].gridx = 0;
		gbc[2].gridy = 2;
		add(pwLabel, gbc[2]);

		gbc[3].gridx = 1;
		gbc[3].gridy = 1;
		add(idField, gbc[3]);

		gbc[4].gridx = 1;
		gbc[4].gridy = 2;
		add(passwordField, gbc[4]);

		gbc[5].gridx = 0;
		gbc[5].gridy = 3;
		gbc[5].gridheight = 2;
		gbc[5].gridheight = 1;
		gbc[5].gridwidth = 2;
		gbc[5].fill = GridBagConstraints.BOTH;
		add(jb, gbc[5]);

		gbc[6].gridx = 0;
		gbc[6].gridy = 4;
		gbc[6].gridheight = 2;
		gbc[6].gridwidth = 2;
		gbc[6].fill = GridBagConstraints.BOTH;
		add(errorLabel, gbc[6]);
		
	}
	
	private class LoginListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String studentNumber;
			String studentPassword;
			ArrayList<Student> dtos;
			StudentDao dao = StudentDao.getInstance();
			String loginId = idField.getText();
			String loginPassword = passwordField.getText();

			boolean checkInputId = (!loginId.equals("아이디") || loginId.length() != 0);
			boolean checkInputPassword = (!loginPassword.equals("비밀번호") || loginPassword.length() != 0);

			dtos = dao.listPasswordByStudentNum(idField.getText());

			if (dtos.get(0) == null) {
				studentNumber = "";
				studentPassword = "";
			} else {
				Student dto = dtos.get(0);
				studentNumber = dto.getStudent_num();
				studentPassword = dto.getStudent_password();
				studentInfo.setStudent_num(studentNumber);
				studentInfo.setStudent_password(studentPassword);
			}
			 
			if (!checkInputId || studentPassword.equals("")) {
				errorLabel.setText("아이디를 입력하세요");
			} else if (!checkInputPassword || studentPassword.equals("")) {
				errorLabel.setText("비밀번호를 입력하세요");
			} else if (!studentNumber.equals(loginId)) {
				errorLabel.setText("아이디가 틀립니다");
			} else if (!studentPassword.equals(loginPassword)) {
				errorLabel.setText("비밀번호가 틀립니다");
			} else if (studentNumber.equals(loginId) && studentPassword.equals(loginPassword)) {
				errorLabel.setText("로그인성공");
				JButton btn = (JButton)e.getSource();
				JFrame df = (JFrame)btn.getRootPane().getParent();
				df.dispose();
			}
		}
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				LoginFrame frame = new LoginFrame();
				frame.setVisible(true);
			}
		});

	}


}