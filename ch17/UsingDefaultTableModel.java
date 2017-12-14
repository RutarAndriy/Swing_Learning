// UsingDefaultTableModel.java
// ������������� ����������� ������ ��� �������� �������
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;

public class UsingDefaultTableModel extends JFrame {
  // ���� ������
  private DefaultTableModel dtm;
  public UsingDefaultTableModel() {
    super("UsingDefaultTableModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ����������� ������
    dtm = new DefaultTableModel();
    // ������ �������� ��������
    dtm.setColumnIdentifiers(
        new String[] {"�����", "�����", "����"});
    // ��������� ������ �������
    dtm.addRow(new String[] {"�1", "�������", "5.5"});
    dtm.addRow(new String[] {"�2", "�������", "175"});
    dtm.addRow(new String[] {"�3", "��������", "1.2"});
    // �������� ������ � �������
    JTable table = new JTable(dtm);
    // ������ ����� �������� �����������
    JButton add = new JButton("��������");
    add.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // ��������� ����� ������
        dtm.addRow(
            new String[] {"?", "�������!", "����� ����!"});
      }
    });
    JButton remove = new JButton("�������");
    remove.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // ������� ��������� ������ (������ � ����)
        dtm.removeRow(dtm.getRowCount() - 1);
      }
    });
    // ��������� ������ � �������
    add(new JScrollPane(table));
    JPanel buttons = new JPanel();
    buttons.add(add);
    buttons.add(remove);
    add(buttons, "South");
    // ������� ���� �� �����
    setSize(300, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingDefaultTableModel(); } });
  }
}
