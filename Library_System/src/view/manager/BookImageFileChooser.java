package view.manager;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BookImageFileChooser extends JFileChooser{
	private String selectedFile;
	public BookImageFileChooser() {

		// �⺻ Path�� ��� ���� (����ȭ��)
		setCurrentDirectory(new File(System.getProperty("user.home") + "//" + "Desktop"));

		
		addChoosableFileFilter(new FileNameExtensionFilter("gif ����", "gif"));
		addChoosableFileFilter(new FileNameExtensionFilter("png ����", "png"));
		addChoosableFileFilter(new FileNameExtensionFilter("jpg ����", "jpg", "jpeg"));

		int result = showOpenDialog(this);
		
		if (result == JFileChooser.APPROVE_OPTION) {
			selectedFile = getSelectedFile().getPath();
		}
	}
	public String getFilePath() {
		return selectedFile;
	}

}
