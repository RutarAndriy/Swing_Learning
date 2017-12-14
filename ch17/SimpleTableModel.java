// SimpleTableModel.java
// �������� ������� ������ ��� �������
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class SimpleTableModel extends JFrame {
  public SimpleTableModel() {
    super("SimpleTableModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������� �� ������ ����� ������
    JTable table = new JTable(new SimpleModel());
    table.setRowHeight(32);
    add(new JScrollPane(table));
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }
  // ���� ������
  class SimpleModel extends AbstractTableModel {
    // ���������� �����
    public int getRowCount() {
      return 100000;
    }
    // ���������� ��������
    public int getColumnCount() {
      return 3;
    }
    // ��� ������, �������� � �������
    public Class getColumnClass(int column) {
      switch (column) {
        case 1: return Boolean.class;
        case 2: return Icon.class;
        default: return Object.class;
      }
    }
    // ������ � ������
    public Object getValueAt(int row, int column) {
      boolean isEven = (row % 2 == 0);
      // ������ ������ ��� ������ �������
      switch (column) {
        case 0: return "" + row;
        case 1: return isEven;
        case 2: return new ImageIcon("Table.gif");
      }
      return "�����";
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleTableModel(); } });

  }
}