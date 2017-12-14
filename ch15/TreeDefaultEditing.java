// TreeDefaultEditing.java
// ����������� ��������� ��� ��������
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class TreeDefaultEditing extends JFrame {
  // ������ ������ ������ � ��������
  private String[] basics = {
      "�������", "�������", "�����" };
  private String[] extendeds = {
      "������", "�������", "�������" };
  public TreeDefaultEditing() {
    super("TreeDefaultEditing");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������ �� ������ ������� ������
    JTree tree = new JTree(createTreeModel());
    // �������� ��������������
    tree.setEditable(true);
    // "���������" ��������
    JComboBox combo = new JComboBox(
        new String[] {"�������", "�������"});
    DefaultCellEditor editor = new DefaultCellEditor(combo);
    // ����������� �������� ��� ������
    DefaultTreeCellRenderer renderer =
        new DefaultTreeCellRenderer();
    DefaultTreeCellEditor treeEditor =
        new DefaultTreeCellEditor(tree, renderer, editor);
    // ������������ �������� � ������
    tree.setCellEditor(treeEditor);
    // ������� ���� �� �����
    add(new JScrollPane(tree));
    setSize(400, 300);
    setVisible(true);
  }
  // �������� ��������� ������ ������
  private TreeModel createTreeModel() {
    // ������ ������ ������
    DefaultMutableTreeNode root =
        new DefaultMutableTreeNode("�����");
    // �������� �����
    DefaultMutableTreeNode basic =
        new DefaultMutableTreeNode("��������");
    DefaultMutableTreeNode extended =
        new DefaultMutableTreeNode("��������������");
    root.add(basic);
    root.add(extended);
    // ������������ ������
    for (int i=0; i<basics.length; i++) {
      basic.add(new DefaultMutableTreeNode(basics[i]));
      extended.add(
          new DefaultMutableTreeNode(extendeds[i]));
    }
    // ������� ����������� ������
    return new DefaultTreeModel(root);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TreeDefaultEditing(); } });
  }
}
