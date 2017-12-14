// SimpleLists.java
// ���������� ������ �������� �������
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class SimpleLists extends JFrame {
  // ������ ��� �������
  private String[] data1 = { "����", "���",
      "���", "������", "����"};
  private String[] data2 = { "������", "�����",
      "�����������", "��� ������ ���"};
  public SimpleLists() {
    super("SimpleLists");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������
    JList list1 = new JList(data1);
    // ��� ������� ������ ���������� ������
    Vector<String> data = new Vector<String>();
    data.addAll(Arrays.asList(data2));
    JList list2 = new JList(data);
    // ����������� �������� ������
    Vector<String> big = new Vector<String>();
    for (int i=0; i<50; i++) {
      big.add("# " + i);
    }
    JList bigList = new JList(big);
    bigList.setPrototypeCellValue("12345");
    // ������� ������ � ������
    setLayout(new FlowLayout());
    add(list1);
    add(list2);
    add(new JScrollPane(bigList));
    // ������� ���� �� �����
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleLists(); } });
  }
}