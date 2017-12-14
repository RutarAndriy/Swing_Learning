// TableResizeModes.java
// ������ ����������������� ������������ �������
// ��� ��������� �������� ��������
import javax.swing.*;
import java.awt.*;

public class TableResizeModes extends JFrame {
  // �������� �������� �������
  private String[] columnNames = {
      "��������", "����", "����"
  };
  // ������ ��� �������
  private String[][] data = {
      { "��������", "�����-�������", "���������"},
      { "�����", "������", "������"}
  };
  // ������ ������
  private JTable[] tables = new JTable[5];
  public TableResizeModes() {
    super("TableResizeModes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ���� ����� �� ���� �����
    setLayout(new GridLayout(5, 1));
    // ������� ������ ������
    for (int i=0; i<tables.length; i++) {
      tables[i] =
          new JTable(data, columnNames);
      add(new JScrollPane(tables[i]));
    }
    // ������ ������ ������������� ������������
    tables[1].setAutoResizeMode(
        JTable.AUTO_RESIZE_OFF);
    tables[2].setAutoResizeMode(
        JTable.AUTO_RESIZE_NEXT_COLUMN);
    tables[3].setAutoResizeMode(
        JTable.AUTO_RESIZE_LAST_COLUMN);
    tables[4].setAutoResizeMode(
        JTable.AUTO_RESIZE_ALL_COLUMNS);
    // ������� ���� ����������� ������ �
    // ������� ��� �� �����
    pack();
    setVisible(true);

  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TableResizeModes(); } });
  }
}
