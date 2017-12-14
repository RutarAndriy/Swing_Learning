// ListSelectionModes.java
// ��������� ������ ���������
import javax.swing.*;
import java.awt.*;

public class ListSelectionModes extends JFrame {
  private String[] data = { "�������", "�����",
      "�������", "������", "�����"};
  public ListSelectionModes() {
    super("ListSelectionModes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // �������� ������ �������
    DefaultListModel dlm =
        new DefaultListModel();
    for (String next : data)
      dlm.addElement(next);
    // ��� ������ � ������ ����� ���������
    JList list1 = new JList(dlm);
    list1.setSelectionMode(
        ListSelectionModel.SINGLE_SELECTION);
    JList list2 = new JList(dlm);
    list2.setSelectionMode(
        ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    JList list3 = new JList(dlm);
    // ���������� ����������� ������
    list3.getSelectionModel().setSelectionMode(
        ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    // ��������� ����������
    setLayout(new FlowLayout());
    add(new JScrollPane(list1));
    add(new JScrollPane(list2));
    add(new JScrollPane(list3));
    // ������� ���� �� �����
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ListSelectionModes(); } });
  }
}