package view.manager;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.dao.AllBookInfoDao;
import model.dao.BookDao;
import model.dto.AllBookInfo;
import view.advertising.AdvertisingFrame;
import view.defaultcomponent.DefaultButton;
import view.defaultcomponent.DefaultPanel;
import view.manager.dialog.ManagerDialog;

public class TitlePanel extends DefaultPanel {

	public TitlePanel() {

		setLayout(new FlowLayout(FlowLayout.LEFT, 50, 10));

		JLabel title = new TitleLabel("<html>manager<br>system</html>");

		JButton addBtn = new DefaultButton("�߰�");
		addBtn.addActionListener(new openDialogListener());

		JButton updateBtn = new DefaultButton("����");
		updateBtn.addActionListener(new openDialogListener());

		JButton deleteBtn = new DefaultButton("����");
		deleteBtn.addActionListener(new deleteRecordListener());

		JButton exitBtn = new DefaultButton("������");
		exitBtn.addActionListener(new exitRecordListener());

		add(title);
		add(addBtn);
		add(updateBtn);
		add(deleteBtn);

		add(exitBtn);

	}

	private class openDialogListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) (e.getSource());
			JFrame df = (JFrame) btn.getRootPane().getParent();
			JDialog dialog;

			AllBookInfo selectedBook = BookListWithSelectedBook.getSelectedBook();

			if (btn.getText().equals("����")) {
				if (selectedBook == null) {
					JOptionPane.showMessageDialog(df, "������ å�� �������ּ���", "NO SELECTION", JOptionPane.NO_OPTION);
				} else {
					dialog = new ManagerDialog(df, "���� " + btn.getText(), true);
					dialog.setVisible(true);
				}
			} else {
				dialog = new ManagerDialog(df, "���� " + btn.getText(), false);
				dialog.setVisible(true);
			}

		}
	}

	private class deleteRecordListener implements ActionListener {

		ManagerFrame df;
		AllBookInfo selectedBook;
		JButton btn;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			btn = (JButton) (e.getSource());
			

			selectedBook = BookListWithSelectedBook.getSelectedBook();
			deleteSelectedBook();
		}

		private void deleteSelectedBook() {
			if(selectedBook.getLoan_state().equals("N")) {
				JOptionPane.showMessageDialog(df, "�뿩���� å�Դϴ�. ������ �� �����ϴ�.", "BEING RENTED", JOptionPane.ERROR_MESSAGE);
			} else {
				BookDao bookdao = BookDao.getInstance();
				int BookId = selectedBook.getBook_id();

				bookdao.deleteBook(BookId);
				df = (ManagerFrame) btn.getRootPane().getParent();
				reloadBookTable();
			}
		}
		private void reloadBookTable() {
			ArrayList<AllBookInfo> booklist = BookListWithSelectedBook.getBooklist();
			booklist.clear();
			BookListWithSelectedBook.setBooklist(booklist);

			int category = BookListWithSelectedBook.getFilter();
			String text = BookListWithSelectedBook.getSearchedText();

			AllBookInfoDao allbookinfodao = AllBookInfoDao.getInstance();

			switch (category) {
			case 1: // å�̸�
				booklist = allbookinfodao.listByBookName(text);
				break;
			case 2: // ����
				booklist = allbookinfodao.listByAuthor(text);
				break;
			case 3: // ���ǻ�
				booklist = allbookinfodao.listByPublisher(text);
				break;
			case 4: // �帣
				booklist = allbookinfodao.listByCategoryName(text);
				break;
			default: // ��ü
				booklist = allbookinfodao.listBySomethig(text);
				break;
			}


			BookListWithSelectedBook.setBooklist(booklist);
			BookListWithSelectedBook.setSelectedBook(null);

			df.currentPageButton.doClick();
		}
	}

	private class exitRecordListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) (e.getSource());
			JFrame df = (JFrame) btn.getRootPane().getParent();
			
			df.dispose();
			new AdvertisingFrame();
		}
	}
}