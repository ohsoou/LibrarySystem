package view.manager.dialog;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BookImageFileChooser extends JFileChooser{
	private String selectedFile;
	public BookImageFileChooser() {

		// 기본 Path의 경로 설정 (바탕화면)
		setCurrentDirectory(new File(System.getProperty("user.home") + "//" + "Desktop"));

		
		setAcceptAllFileFilterUsed(false);
		addChoosableFileFilter(new FileNameExtensionFilter("jpg 파일", "jpg", "jpeg"));
		addChoosableFileFilter(new FileNameExtensionFilter("gif 파일", "gif"));
		addChoosableFileFilter(new FileNameExtensionFilter("png 파일", "png"));
		

		int result = showOpenDialog(this);
		
		if (result == JFileChooser.APPROVE_OPTION) {
			selectedFile = getSelectedFile().getPath();
		}
	}
	public String getFilePath() {
		return selectedFile;
	}

}
