package view.manager.dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JButton;
import javax.swing.JDialog;

import model.dao.AllBookInfoDao;
import model.dao.BookDao;
import model.dao.BookinfoDao;
import model.dto.Bookinfo;
import view.DefaultFrame;
import view.component.DefaultPanel;
import view.manager.BookListWithSelectedBook;
import view.manager.ManagerFrame;


public class ButtonPanel extends DefaultPanel{
	private String function;
	private Bookinfo book;
	private JButton cancel;
	private JButton submit;
	
	public ButtonPanel(String title) {
		super(new Color(244, 240, 240));
		setPreferredSize(new Dimension(730, 80));
		setLayout(new GridLayout(1, 2));
		
		this.function = title.substring(3);
		cancel = new JButton("CANCEL");
		submit = new JButton("SUBMIT");
		
		cancel.setBackground(new Color(244,240,240)); 
		cancel.setForeground(new Color(158, 158, 158));
		cancel.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		cancel.addActionListener(new cancelDialogListener());
		
		submit.setBackground(new Color(244,240,240)); 
		submit.setForeground(new Color(158, 158, 158));
		submit.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		submit.addActionListener(new submitDialogListener());

		add(cancel);
		add(submit);
		
	}
	public JButton getSubmitButton() {
		return submit;
	}
	class cancelDialogListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			
			JDialog dialog = (JDialog)btn.getRootPane().getParent();
			
			dialog.setVisible(false);
			dialog.dispose();
			
		}
	}
	
	class submitDialogListener implements ActionListener {
		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent e) {
			BookDao bookdao = BookDao.getInstance();
			BookinfoDao bookinfodao = BookinfoDao.getInstance();
			
			JButton btn = (JButton) e.getSource();
			ManagerDialog dialog = (ManagerDialog)(btn.getRootPane().getParent());
			
			
			if (dialog.getBook() != null) {
				book = dialog.getBook();
				long isbn = book.getISBN();
				if(function.equals("추가")) {
					bookinfodao.insertBookInfo(isbn, book.getKDC(), 
							book.getAuthor(), book.getPublisher(), book.getPublication_date(), 
							book.getBook_name(), book.getImagepath(), book.getSummary());
					bookdao.insertBook(isbn);
					writeImage(dialog.getImageFile());
				} else if (function.equals("수정")) {
					
					bookinfodao.updateAuthor(isbn, book.getAuthor());
					bookinfodao.updateBookName(isbn, book.getBook_name());
					bookinfodao.updatePublicationDate(isbn, book.getPublication_date());
					bookinfodao.updatePublisher(isbn, book.getPublisher());
					bookinfodao.updateImagePath(isbn, book.getImagepath());
					bookinfodao.updateSummary(isbn, book.getSummary());
					writeImage(dialog.getImageFile());
				}
			}
			
			BookListWithSelectedBook currentTableState = new BookListWithSelectedBook();
			AllBookInfoDao allBookInfoDao = AllBookInfoDao.getInstance();
			String text = currentTableState.getSearchedText();

			switch (currentTableState.getFilter()) {
			case 1: // 책이름
				currentTableState.setBooklist(allBookInfoDao.listByBookName(text));
				break;
			case 2: // 저자
				currentTableState.setBooklist(allBookInfoDao.listByAuthor(text));
				break;
			case 3: // 출판사
				currentTableState.setBooklist(allBookInfoDao.listByPublisher(text));
				break;
			default: // 전체
				if(text == null) {
					currentTableState.setBooklist(allBookInfoDao.listBySomethig(text));
				} else {
					currentTableState.setBooklist(allBookInfoDao.listAll_AllBookinfo());
				}
				break;
			} 

			((DefaultFrame)dialog.getParent()).revalidate();
			((DefaultFrame)dialog.getParent()).repaint();
			//((DefaultFrame)dialog.getParent()).add(new ManagerPanel());
			cancel.doClick();
		}
		private void writeImage(File imageFile) {
			// 파일 저장
			if(imageFile != null) {
				File dstFile = new File("./image/" + imageFile.getName());
				BufferedImage image;
				try {
					image = ImageIO.read(imageFile);
					ImageInputStream iis = ImageIO.createImageInputStream(imageFile);

					Iterator<ImageReader> imageReaders = ImageIO.getImageReaders(iis);

					while (imageReaders.hasNext()) {
					    ImageReader reader = (ImageReader) imageReaders.next();
					    ImageIO.write(image, reader.getFormatName(), dstFile);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
