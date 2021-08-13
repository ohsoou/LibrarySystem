package view.manager.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import model.dto.AllBookInfo;
import model.dto.Bookinfo;
import view.IFrame;
import view.component.BookListWithSelectedBook;
import view.component.DefaultButton;
import view.component.DefaultPanel;
import view.component.RoundTextField;


public class ManagerDialog extends JDialog implements IFrame {

	private JLabel pageTitle;
	private Container form;
	private Container image;
	private Container summary;
	private JTextField summaryField;
	private String title;
	private boolean update;

	// Form Panel
	private Bookinfo book = new Bookinfo();
	private JTextField isbnField;
	private JTextField kdcField;
	private JTextField nameField;
	private JTextField authorField;
	private JTextField publisherField;
	private JTextField publicationDateField;

	// File Panel
	private JTextField pathField;
	private JLabel bookimage;
	private File localImageFile;

	public ManagerDialog(JFrame frame, String title, boolean update) {
		super(frame, title);
		this.setLocation(100, 100);
		setDialog();

		this.title = title;
		this.update = update;

		setComp();
		setDesign();

		if (update) {
			BookListWithSelectedBook currentTableState = new BookListWithSelectedBook();
			setFormTextFeild(currentTableState.getSelectedBook());
			setBookImage(pathField.getText());
		}

	}

	private void setDialog() {
		this.setLocation(100, 100);
		getContentPane().setBackground(new Color(244, 240, 240));
		setLayout(new BorderLayout());
		setSize(730, 580);
	}

	@Override
	public void setComp() {
		this.pageTitle = setDialogTitle(title);
		this.form = setFormPane(update);
		this.image = setBooImagePane(update);
		this.summary = setSummaryPane();

	}

	@Override
	public void setDesign() {
		// top (title)
		add(pageTitle, "North");

		// center(form)
		JPanel center = new DefaultPanel(new Color(244, 240, 240));

		center.setLayout(new FlowLayout());
		center.add(form);
		center.add(image);
		center.add(summary);

		add(center, "Center");

		// bottom (button)
		JPanel bottom = new ButtonPanel(title);
		add(bottom, "South");
	}

	// update 시 사용
	private void setFormTextFeild(AllBookInfo selectedBook) {
		isbnField.setText(String.valueOf(selectedBook.getIsbn()));
		kdcField.setText(selectedBook.getKdc());
		nameField.setText(selectedBook.getBook_name());
		authorField.setText(selectedBook.getAuthor());
		publisherField.setText(selectedBook.getPublisher());
		if (selectedBook.getPublication_date() == null) {
			publicationDateField.setText("0000-00-00");
		} else {
			publicationDateField.setText(String.valueOf(selectedBook.getPublication_date()));
		}
		pathField.setText(selectedBook.getImagepath());
		summaryField.setText(selectedBook.getSummary());
	}
	
	public File getlocalImageFile() {
		return localImageFile;
	}

	public Bookinfo getBook() {
		if (isEmptyField(isbnField)) {
			return isNoInput("ISBN");
		} else {
			book.setISBN(Long.parseLong(isbnField.getText()));
		}
		if (isEmptyField(authorField)) {
			return isNoInput("작가");
		} else {
			book.setAuthor(authorField.getText());
		}

		if (isEmptyField(nameField)) {
			return isNoInput("책 이름");
		} else {
			book.setBook_name(nameField.getText());
		}
		if (isEmptyField(publisherField)) {
			return isNoInput("출판사");
		} else {
			book.setPublisher(publisherField.getText());
		}
		book.setKDC(kdcField.getText());
		book.setPublication_date(getPublicationDateField());

		book.setSummary(summaryField.getText());

		book.setImagepath("./image/" + localImageFile.getName());

		return book;
	}

	// title
	private JLabel setDialogTitle(String title) {
		JLabel pageTitle = new JLabel(title);
		Border border = pageTitle.getBorder();
		Border margin = new EmptyBorder(20, 50, 0, 0);
		pageTitle.setBorder(new CompoundBorder(border, margin));
		pageTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));

		return pageTitle;
	}

	// summary
	private Container setSummaryPane() {
		Container summary = new Container();
		summary.setBackground(new Color(244, 240, 240));
		JLabel summaryLabel = new JLabel("줄거리");
		Border border = summaryLabel.getBorder();
		Border margin = new EmptyBorder(0, 0, 0, 20);
		summaryLabel.setBorder(new CompoundBorder(border, margin));
		this.summaryField = new RoundTextField(550, 50);

		summary.add(summaryLabel);
		summary.add(summaryField);

		return summary;
	}

	// Form Panel
	private Container setFormPane(boolean update) {
		Container con = new Container();
		con.setBackground(new Color(244, 240, 240));
		con.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		con.setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);

		JLabel isbnLabel = new JLabel("ISBN");
		isbnField = new RoundTextField(180, 30);

		JLabel kdcLabel = new JLabel("KDC");
		kdcField = new RoundTextField(180, 30);

		JLabel nameLabel = new JLabel("도서명");
		nameField = new RoundTextField(180, 30);

		JLabel authorLabel = new JLabel("저자");
		authorField = new RoundTextField(180, 30);

		JLabel publisherLabel = new JLabel("출판사");
		publisherField = new RoundTextField(180, 30);

		JLabel publicationDateLabel = new JLabel("출판일");
		publicationDateField = new RoundTextField(180, 30);
		publicationDateField.setText("0000-00-00");

		constraints.gridx = 0;
		constraints.gridy = 0;
		con.add(isbnLabel, constraints);

		constraints.gridx = 1;
		con.add(isbnField, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		con.add(kdcLabel, constraints);

		constraints.gridx = 1;
		con.add(kdcField, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		con.add(nameLabel, constraints);

		constraints.gridx = 1;
		con.add(nameField, constraints);

		constraints.gridx = 0;
		constraints.gridy = 3;
		con.add(authorLabel, constraints);

		constraints.gridx = 1;
		con.add(authorField, constraints);

		constraints.gridx = 0;
		constraints.gridy = 4;
		con.add(publisherLabel, constraints);

		constraints.gridx = 1;
		con.add(publisherField, constraints);

		constraints.gridx = 0;
		constraints.gridy = 5;
		con.add(publicationDateLabel, constraints);

		constraints.gridx = 1;
		con.add(publicationDateField, constraints);

		return con;
	}

	private Date getPublicationDateField() {
		return publicationDateField.getText() == "0000-00-00" ? null : Date.valueOf(publicationDateField.getText());
	}

	private boolean isEmptyField(JTextField field) {
		return field.getText().isEmpty();
	}

	private Bookinfo isNoInput(String fieldName) {
		JOptionPane.showMessageDialog(this.getRootPane().getParent(), fieldName + "은/는 필수 입력란 입니다.", "NO INPUT",
				JOptionPane.NO_OPTION);
		return null;
	}

	// BooImage File Panel
	private Container setBooImagePane(boolean update) {
		Container con = new Container();
		con.setBackground(new Color(244, 240, 240));
		con.setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);

		Container container = new Container();
		container.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		container.setPreferredSize(new Dimension(350, 40));

		JLabel textLabel = new JLabel("이미지");
		pathField = new RoundTextField(220, 30);
		JButton addButton = new DefaultButton("찾기", 60, 30);
		addButton.addActionListener(new OpenFileChooserListener());

		constraints.gridx = 0;
		constraints.gridy = 0;
		String noImagePath = "./image/NoBookImage.PNG";
		bookimage = new JLabel();
		bookimage.setPreferredSize(new Dimension(350, 220));
		bookimage.setHorizontalAlignment(SwingConstants.CENTER);
		setBookImage(noImagePath);
		localImageFile = null;

		con.add(bookimage, constraints);

		container.add(textLabel);
		container.add(pathField);
		container.add(addButton);

		constraints.gridx = 0;
		constraints.gridy = 1;
		con.add(container, constraints);

		return con;

	}

	class OpenFileChooserListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			BookImageFileChooser file = new BookImageFileChooser();
			file.setVisible(true);

			localImageFile = file.getSelectedFile();

			String imagePath = file.getFilePath();
			if (imagePath != null) {
				pathField.setText(imagePath);
				setBookImage(imagePath);
			}
		}
	}

	// image label
	private void setBookImage(String path) {
		bookimage.setIcon(getResizedImageIcon(path));
	}

	private ImageIcon getResizedImageIcon(String imagePath) {
		ImageIcon origin = new ImageIcon(imagePath);
		return new ImageIcon(origin.getImage().getScaledInstance(190, 220, Image.SCALE_SMOOTH));
	}

}
