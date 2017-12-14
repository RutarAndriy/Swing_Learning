// SimpleSorting.java
// ���������� ������� �� ���������
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class SimpleSorting extends JFrame {
  public SimpleSorting() {
    super("SimpleSorting");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������� �� ������ ������ �� ���������
    SortModel sm = new SortModel();
    sm.setColumnCount(4);
    // ��������� ��� ����� ��������� �����
    for ( int i = 0; i < 100; i++ ) {
      sm.addRow(new Integer[] { i,
          (int)(5*Math.random()),
          (int)(5*Math.random()),
          (int)(5*Math.random())} );
    }
    JTable table = new JTable();
    // �������������� ��������� ����������
    table.setAutoCreateRowSorter(true);
    // ����������� �� ���������� ��������
    ((TableRowSorter)table.getRowSorter()).setMaxSortKeys(2);
    table.setModel(sm);
    add(new JScrollPane(table));
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }
  // ������ ��� ������������ ���������� � ����������
  static class SortModel extends DefaultTableModel {
    // ��� ������, �������� � �������
    public Class getColumnClass(int column) {
      return Integer.class;
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new FilterAndSelection(); } });
  }
}