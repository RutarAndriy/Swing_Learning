// SimpleTrees.java
// �������� ����� ������� ��������
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class SimpleTrees extends JFrame {
  public SimpleTrees() {
    super("SimpleTrees");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // �������� ������ �� ������ �������
    Object[] data = new Object[] { "������", "������",
        "������", new String[] { "���-�� �������",
            "��� �������" }
    };
    JTree tree1 = new JTree(data);
    // ������ �� ������ �������
    Vector<String> vector = new Vector<String>();
    for (int i=0; i<5; i++) vector.add("���� � " + i);
    JTree tree2 = new JTree(vector);
    // ������ �� ������ �������
    Hashtable<String,String> table =
        new Hashtable<String,String>();
    table.put("����", "����");
    table.put("��� ����", "���� ����");
    JTree tree3 = new JTree(table);
    // ����� �������� ����� ����� ������
    tree3.setRootVisible(true);
    // ������� ������� ���� �� �����
    setLayout(new FlowLayout());
    add(tree1);
    add(tree2);
    add(tree3);
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);

  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleTrees(); } });
  }
}