// DoubleClickList.java
// ��������� �������� ������ �� ����� ������
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class DoubleClickList extends JFrame {
  // ������ ������
  private String[] data = { "�����", "�������",
      "����", "�������"};
  private JList list;
  public DoubleClickList() {
    super("DoubleClickList");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������
    list = new JList(data);
    list.setSelectionMode(
        ListSelectionModel.SINGLE_SELECTION);
    // ������� c�������� ������� �� ����
    list.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        if ( e.getClickCount() == 2 ) {
          // �������� ������� � ������� ���
          int pos =
              list.locationToIndex(e.getPoint());
          JOptionPane.showMessageDialog(
              list, "��� ���������: " +
                  list.getModel().getElementAt(pos));
        }
      }
    });
    // ������� ���� �� �����
    add(new JScrollPane(list));
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new DoubleClickList(); } });
  }
}