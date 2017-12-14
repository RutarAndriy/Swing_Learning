// TableDefaultEditing.java
// ���������� ������������ ��������� ��� ������
import javax.swing.*;
import java.awt.*;

public class TableDefaultEditing extends JFrame {
  // �������� ��������
  private String[] columns = {
      "���", "������� ����" };
  // ������ ��� �������
  private String[][] data = {
      { "����", "�������" },
      { "���������", "�������"},
      { "����", "�����"}
  };
  public TableDefaultEditing() {
    super("TableDefaultEditing");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� �������
    JTable table = new JTable(data, columns);
    // ����������� ����������� ��������
    JComboBox combo = new JComboBox(
        new String[] { "�������", "������", "�����"});
    DefaultCellEditor editor =
        new DefaultCellEditor(combo);
    table.getColumnModel().getColumn(1).
        setCellEditor(editor);
    // ������� ���� �� �����
    add(new JScrollPane(table));
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TableDefaultEditing(); } });
  }
}