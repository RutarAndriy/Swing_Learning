// UsingTableColumnModel.java
// ������������� ����������� ������ ��������
// ������� � �������� TableColumn
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Enumeration;

public class UsingTableColumnModel extends JFrame {
  // ������ ��������
  private TableColumnModel columnModel;
  // �������� �������� �������
  private String[] columnNames = {
      "���", "������� ����", "�������"
  };
  // ������ ��� �������
  private String[][] data = {
      { "����", "�������", "������������ ���"},
      { "���������", "�������", "������� ���"}
  };
  public UsingTableColumnModel() {
    super("UsingTableColumnModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ���� �������
    JTable table = new JTable(data, columnNames);
    // �������� ����������� ������
    columnModel = table.getColumnModel();
    // ������ ������� ��������
    Enumeration e = columnModel.getColumns();
    while ( e.hasMoreElements() ) {
      TableColumn column =
          (TableColumn)e.nextElement();
      column.setMinWidth(30);
      column.setMaxWidth(90);
    }
    // �������� ���� ������
    JPanel buttons = new JPanel();
    JButton move = new JButton("�������� �������");
    move.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // ������ ������� ������ ��� �������
        columnModel.moveColumn(0, 1);
      }
    });
    buttons.add(move);
    JButton add = new JButton("��������");
    add.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // ��������� �������
        TableColumn newColumn =
            new TableColumn(1, 100);
        newColumn.setHeaderValue("<html><b>�����!");
        columnModel.addColumn(newColumn);
      }
    });
    buttons.add(add);
    // ������� ���� �� �����
    add(new JScrollPane(table));
    add(buttons, "South");
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingTableColumnModel(); } });
  }
}
