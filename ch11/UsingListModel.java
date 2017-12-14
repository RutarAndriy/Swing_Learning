// UsingListModel.java
// ������������� ����������� ������ ������
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class UsingListModel extends JFrame {
  // ���� ������
  private DefaultListModel dlm;
  public UsingListModel() {
    super("UsingListModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // �������� ������ �������
    dlm = new DefaultListModel();
    dlm.add(0, "���-���");
    dlm.add(0, "���-��� ���");
    dlm.add(0, "��� �������");
    // ������� ������ � ���� �������
    JButton add = new JButton("��������");
    add.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dlm.add(0, "�������!");
      }
    });
    JList list1 = new JList(dlm);
    JList list2 = new JList(dlm);
    // ��������� ����������
    setLayout(new FlowLayout());
    add(add);
    add(new JScrollPane(list1));
    add(new JScrollPane(list2));
    // ������� ���� �� �����
    setSize(400, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingListModel(); } });
  }
}
