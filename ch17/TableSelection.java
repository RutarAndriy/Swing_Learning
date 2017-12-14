// TableSelection.java
// ������ ��������� ����� �������
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class TableSelection extends JFrame {
  // �������� �������� �������
  private String[] columnNames = {
      "��������", "����", "����"
  };
  // ������ ��� �������
  private String[][] data = {
      { "��������", "�����-�������", "���������"},
      { "�����", "�������", "�����-�������"},
      { "�����", "������", "������"}
  };
  public TableSelection() {
    super("TableSelection");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ���� ������ � ����������� �������
    // ������ ������� - ��������� �� �������
    JTable table1 = new JTable(data, columnNames);
    table1.getSelectionModel().setSelectionMode(
        ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    // ������ ������� - ��������� �� ��������
    JTable table2 = new JTable(data, columnNames);
    table2.setRowSelectionAllowed(false);
    TableColumnModel cm = table2.getColumnModel();
    cm.setColumnSelectionAllowed(true);
    cm.getSelectionModel().setSelectionMode(
        ListSelectionModel.SINGLE_SELECTION);
    // ��������� ������� � ������� ���� �� �����
    setLayout(new GridLayout(1, 2));
    add(new JScrollPane(table1));
    add(new JScrollPane(table2));
    pack();
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TableSelection(); } });
  }
}
