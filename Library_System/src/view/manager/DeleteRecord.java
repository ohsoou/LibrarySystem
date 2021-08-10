package view.manager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DeleteRecord extends JFrame implements MouseListener{
	private JButton delBtn;
	private JTextField []fields=new JTextField[6];
	private JTable table;
	
	public void removeRecord(int index) {
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		if(index<0) {
			if(table.getRowCount()==0)//비어있는 테이블이면
				return;
			index=0;
		}
		model.removeRow(index);
	}
	
	// 클릭시 호출
	@Override
	public void mouseClicked(MouseEvent e) {
		Object src=e.getSource();
		if(src==delBtn) {
			int selected=table.getSelectedRow();
			removeRecord(selected);
		}
	}
		
	@Override
	public void mousePressed(MouseEvent e) {
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {	
	}
	
	@Override
	public void mouseExited(MouseEvent e) {		
	}

}
