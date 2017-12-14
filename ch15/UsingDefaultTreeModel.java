// UsingDefaultTreeModel.java
// ������������� ����������� ������ ������ � 
// ����� DefaultMutableTreeNode
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class UsingDefaultTreeModel extends JFrame {
  // ��� �������� ������ ����� ������� � ��������
  private String[] drinks =  { "��������", "���", "����" };
  private String[] fruits =  { "������", "���������" };
  public UsingDefaultTreeModel() {
    super("UsingDefaultTreeModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ���� ����������� ���������
    DefaultMutableTreeNode root =
        new DefaultMutableTreeNode("������ ������");
    // �������� �����
    DefaultMutableTreeNode drink =
        new DefaultMutableTreeNode("�������");
    DefaultMutableTreeNode fruit =
        new DefaultMutableTreeNode("������");
    // ��������� �����
    root.add(drink);
    root.add(fruit);
    // ����������� �����������
    root.add(new DefaultMutableTreeNode("������", true));
    // ��������� ������
    for (String _drink : drinks) {
      drink.add(
          new DefaultMutableTreeNode(_drink, false));
    }
    for (String _fruit : fruits) {
      fruit.add(
          new DefaultMutableTreeNode(_fruit, false));
    }
    // ������� ����������� ������ � ������
    DefaultTreeModel dtm1 =
        new DefaultTreeModel(root, true);
    JTree tree1 = new JTree(dtm1);
    // ������ ����� �������, ������� � ������ ����
    DefaultTreeModel dtm2 = new DefaultTreeModel(drink);
    JTree tree2 = new JTree(dtm2);
    // ��������� ������� � ���� � ���������� ���
    setLayout(new GridLayout(1, 2));
    add(new JScrollPane(tree1));
    add(new JScrollPane(tree2));
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingDefaultTreeModel(); } });
  }
}