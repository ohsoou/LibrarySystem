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
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import model.dao.AllBookInfoDao;
import model.dao.BookDao;
import model.dao.BookinfoDao;
import model.dto.AllBookInfo;
import model.dto.Bookinfo;
import view.defaultcomponent.DefaultPanel;
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
		cancel.setFont(new Font("���� ���", Font.PLAIN, 22));
		cancel.addActionListener(new cancelDialogListener());
		
		submit.setBackground(new Color(244,240,240)); 
		submit.setForeground(new Color(158, 158, 158));
		submit.setFont(new Font("���� ���", Font.PLAIN, 22));
		submit.addActionListener(new submitDialogListener());

		add(cancel);
		add(submit);
		
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
		private ManagerDialog dialog;
		BookDao bookdao;
		BookinfoDao bookinfodao;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			bookdao = BookDao.getInstance();
			bookinfodao = BookinfoDao.getInstance();
			
			JButton btn = (JButton) e.getSource();
			dialog = (ManagerDialog)(btn.getRootPane().getParent());
			
			
			if (dialog.getBook() != null) {
				book = dialog.getBook();
				long isbn = book.getISBN();
				
				if(function.equals("�߰�") && bookinfodao.existBookInfo(book.getISBN()) > 0) {
					JOptionPane.showMessageDialog(dialog, "ISBN " + isbn + "��/�� �̹� �����ϴ� å �����Դϴ�. �ش�Ǵ� ��� å������ �����˴ϴ�.", "EXIST BOOK INFO",
							JOptionPane.NO_OPTION);
					function = "����";
					bookdao.insertBook(isbn);
				}
				updateBookDB(isbn);
			}
			
			reloadBookTable();
			cancel.doClick();
		}
		
		private void updateBookDB(long isbn) {
			if(function.equals("�߰�")) {
				bookinfodao.insertBookInfo(isbn, book.getKDC(), 
						book.getAuthor(), book.getPublisher(), book.getPublication_date(), 
						book.getBook_name(), book.getImagepath(), book.getSummary());
				bookdao.insertBook(isbn);
				writeImage(dialog.getlocalImageFile());
			} else if (function.equals("����")) {	
				bookinfodao.updateAuthor(isbn, book.getAuthor());
				bookinfodao.updateBookName(isbn, book.getBook_name());
				bookinfodao.updatePublicationDate(isbn, book.getPublication_date());
				bookinfodao.updatePublisher(isbn, book.getPublisher());
				bookinfodao.updateImagePath(isbn, book.getImagepath());
				bookinfodao.updateSummary(isbn, book.getSummary());
				writeImage(dialog.getlocalImageFile());
			}
		}
		
		private void writeImage(File localImageFile) {
			// ���� ����
			if(localImageFile != null) {
				File dstFile = new File("./image/" + localImageFile.getName());
				BufferedImage image;
				try {
					image = ImageIO.read(localImageFile);
					ImageInputStream iis = ImageIO.createImageInputStream(localImageFile);

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
			default: // ��ü
				booklist = allbookinfodao.listBySomethig(text);
				break;
			}
			
			BookListWithSelectedBook.setBooklist(booklist);
			BookListWithSelectedBook.setSelectedBook(null);
			
			ManagerFrame df = (ManagerFrame)dialog.getParent();
			df.currentPageButton.doClick();
		}
		
	}
}
