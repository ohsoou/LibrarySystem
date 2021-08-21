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

		JButton addBtn = new DefaultButton("추가");
		addBtn.addActionListener(new openDialogListener());

		JButton updateBtn = new DefaultButton("수정");
		updateBtn.addActionListener(new openDialogListener());

		JButton deleteBtn = new DefaultButton("삭제");
		deleteBtn.addActionListener(new deleteRecordListener());

		JButton exitBtn = new DefaultButton("나가기");
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

			if (btn.getText().equals("수정")) {
				if (selectedBook == null) {
					JOptionPane.showMessageDialog(df, "수정할 책을 선택해주세요", "NO SELECTION", JOptionPane.NO_OPTION);
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
				JOptionPane.showMessageDialog(df, "대여중인 책입니다. 삭제할 수 없습니다.", "BEING RENTED", JOptionPane.ERROR_MESSAGE);
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
			case 1: // 책이름
				booklist = allbookinfodao.listByBookName(text);
				break;
			case 2: // 저자
				booklist = allbookinfodao.listByAuthor(text);
				break;
			case 3: // 출판사
				booklist = allbookinfodao.listByPublisher(text);
				break;
			case 4: // 장르
				booklist = allbookinfodao.listByCategoryName(text);
				break;
			default: // 전체
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