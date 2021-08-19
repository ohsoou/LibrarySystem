package view.rental.rentalEndPage;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.dto.AllBookInfo;
import view.defaultcomponent.DefaultPanel;
import view.rental.UserSelection;
import view.rental.rentalUnderPane;

public class EndPanel extends DefaultPanel{
	
	public EndPanel() {
		setBackground(new Color(225, 238, 246));
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.insets = new Insets(7, 7, 7, 7);
		
		String[] columnNames = {  "ISBN", "KDC", "도서명", "저자", "출판사", "출판일", "장르", "대여상태" };
		String[][] contents = new String[5][8];
		contents = initTableBookList(contents);
		
		DefaultTableModel model = new DefaultTableModel(contents, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JTable table = new JTable(model);
		JScrollPane tablePane = new rentalUnderPane(table);
	
		
		constraints.gridy = 1;
		add(tablePane, constraints);
	}
	
	
	public String[][] initTableBookList(String[][] contents) {		
		for(int i = 0, end = UserSelection.getSelectionSize(); i < end; i++) {
			AllBookInfo book = UserSelection.getSelectedBooks().get(i);
			contents[i][0] = String.valueOf(book.getIsbn());
			contents[i][1] = book.getKdc();
			contents[i][2] = book.getBook_name();
			contents[i][3] = book.getAuthor();
			contents[i][4] = book.getPublisher();
			contents[i][5] = String.valueOf(book.getPublication_date() == null? "" : book.getPublication_date());
			contents[i][6] = book.getCategory_name();
			contents[i][7] = book.getLoan_state();
		}
		return contents;
	}

}
