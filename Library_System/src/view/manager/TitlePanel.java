package view.manager;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.dto.AllBookInfo;
import view.component.DefaultButton;
import view.component.DefaultPanel;
import view.manager.dialog.ManagerDialog;

public class TitlePanel extends DefaultPanel{	
	
	public TitlePanel() {		
		
		setLayout(new FlowLayout(FlowLayout.LEFT, 50, 10));

		
		JLabel title = new TitleLabel("<html>manager<br>system</html>");
		
		
		JButton addBtn = new DefaultButton("추가");
		addBtn.addActionListener(new OpenDialogListener());
		
		JButton updateBtn = new DefaultButton("수정");
		updateBtn.addActionListener(new OpenDialogListener());
		
		JButton deleteBtn = new DefaultButton("삭제"); 
		
		JButton listBtn = new DefaultButton("창닫기");
		
		add(title);
		add(addBtn);
		add(updateBtn);
		add(deleteBtn);
		add(listBtn);
		 

	}
	
	class OpenDialogListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)(e.getSource());
			JFrame df = (JFrame)btn.getRootPane().getParent();
			JDialog dialog;
			
			ManagerPanel parentPanel = (ManagerPanel)btn.getParent().getParent();
			BookListWithSelectedBook currentTableState = new BookListWithSelectedBook();
			AllBookInfo selectedBook = currentTableState.getSelectedBook();
			
			if(btn.getText().equals("수정")) {
				if(selectedBook == null) {
					JOptionPane.showMessageDialog(parentPanel, "수정할 책을 선택해주세요", "NO SELECTION", JOptionPane.NO_OPTION);
				} else {
					dialog = new ManagerDialog(df, "도서 " + btn.getText(), true);
					dialog.setVisible(true);
				}
			} else {
				dialog = new ManagerDialog(df, "도서 " + btn.getText(), false);
				dialog.setVisible(true);
			}
			
		}
	}
}
