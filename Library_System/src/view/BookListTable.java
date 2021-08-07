package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class BookListTable extends JTable{
	
	public BookListTable() {
      String[] columnNames = {"LSBN", "KDC", "������", "����", "���ǻ�", "������", "�帣", "�뿩����"};
      String[][] contents = {
              {"11960503", "300,500", "�Ƴ����� �ִ� ����", "�Ǿ�", "������", "2007-03-05", "����", "N"},
              {"", "", "", "","","","",""},
              {"", "", "", "","","","",""},
              {"", "", "", "","","","",""},
              {"", "", "", "","","","",""},
              {"", "", "", "","","","",""},
              {"", "", "", "","","","",""},
      };   
      JTable table = new JTable(contents, columnNames);
      
      JScrollPane scrollPane = new JScrollPane(table);
      JTableHeader header = table.getTableHeader();
      
      header.setBackground(new Color(234, 234, 234));
      header.setForeground(new Color(0, 78, 102));
      
      // ��Ʈ
      table.getTableHeader().setFont(new Font("Small Fonts", Font.BOLD, 15));
      table.setFont(new Font("����", Font.PLAIN, 15));
      
      //table.setShowHorizontalLines(false); ���� �ٻ���
      table.setShowVerticalLines(false);// ���� �ٻ���
		
      // table ũ��
      table.getTableHeader().setPreferredSize(new Dimension(
			scrollPane.getWidth(), 35
      ));
      table.setRowHeight(20);
      
      scrollPane.setLocation(30,215);
      scrollPane.setSize(900,178);
            
      add(scrollPane);

      //�� ���� �ڵ� ����
      final TableColumnModel columnModel = table.getColumnModel();
      for (int column = 0; column < table.getColumnCount(); column++) {
          int width = 15; // Min width
          
          for (int row = 0; row < table.getRowCount(); row++) {
              TableCellRenderer renderer = table.getCellRenderer(row, column);
              Component comp = table.prepareRenderer(renderer, row, column);
              width = Math.max(comp.getPreferredSize().width +1 , width);
          }
          if(width > 200)
              width=200;
          	  columnModel.getColumn(column).setPreferredWidth(width);
      }
	}
}
