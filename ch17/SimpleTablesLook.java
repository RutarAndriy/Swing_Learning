// SimpleTablesLook.java
// ��������� ��������� �������� ���� ������
import javax.swing.*;
import java.awt.*;

public class SimpleTablesLook extends JFrame {
  // ������ � ��������� ��� �������
  private Object[][] data = new String[][] {
      { "������", "�����", "����������" },
      { "�����������", "�������", "��������" }
  };
  private Object[] columns = new String[] {
      "������", "����", "������"
  };
  public SimpleTablesLook() {
    super("SimpleTablesLook");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� � ������� ������������ ����� ��������
    JTable table1 = new JTable(data, columns);
    // ��������� ���������� � ������
    table1.setRowHeight(40);
    table1.setIntercellSpacing(new Dimension(10, 10));
    table1.setGridColor(Color.green);
    table1.setShowVerticalLines(false);
    // ������� � ������� �������
    JTable table2 = new JTable(data, columns);
    table2.setForeground(Color.red);
    table2.setSelectionForeground(Color.yellow);
    table2.setSelectionBackground(Color.blue);
    table2.setShowGrid(false);
    // ��������� ������� � ������ �� ���� �����
    setLayout(new GridLayout(1, 2, 5, 5));
    add(new JScrollPane(table1));
    add(new JScrollPane(table2));
    // ������� ���� �� �����
    setSize(600, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleTablesLook(); } });
  }
}