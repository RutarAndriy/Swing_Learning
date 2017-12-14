// CustomTableEditor.java
// ���������� ������������������� ���������
// ��� ����� �������
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.*;
import com.porty.swing.*;

public class CustomTableEditor extends JFrame {
  // ��������� �������� �������
  private String[] columns = {
      "��������", "����" };
  // ������ �������
  private Object[][] data = {
      { "�������", new Date() },
      { "�������", new Date() }
  };
  public CustomTableEditor() {
    super("CustomTableEditor");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������� �� ������ ����������� ������
    DefaultTableModel model =
        new DefaultTableModel(data, columns) {
          // ���������� ������� ��� �������
          public Class getColumnClass(int column) {
            return data[0][column].getClass();
          }
        };
    JTable table = new JTable(model);
    table.setRowHeight(20);
    // ��������� �������� ��� ���
    table.setDefaultEditor(
        Date.class, new DateCellEditor());
    // ������� ���� �� �����
    getContentPane().add(new JScrollPane(table));
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new CustomTableEditor(); } });
  }
}
