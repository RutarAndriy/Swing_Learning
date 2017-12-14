// TreeDefaultRendering.java
// ������������� ������������ ������������
// ������������ ������� DefaultTreeCellRenderer
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class TreeDefaultRendering extends JFrame {
  public TreeDefaultRendering() {
    super("TreeDefaultRendering");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������ �� ������ ������������ ������
    JTree tree = new JTree(createTreeModel());
    // �������� � ����������� ������������ ������
    DefaultTreeCellRenderer renderer =
        new DefaultTreeCellRenderer();
    renderer.setLeafIcon(new ImageIcon("Leaf.gif"));
    renderer.setClosedIcon(
        new ImageIcon("NodeClosed.gif"));
    renderer.setOpenIcon(
        new ImageIcon("NodeOpened.gif"));
    // �������� ��� ������
    tree.setCellRenderer(renderer);
    // ��������� ������ � ������� ���� �� �����
    add(new JScrollPane(tree));
    setSize(400, 300);
    setVisible(true);
  }
  // ������ ������ ������ � ��������
  private String[] langs = {
      "<html><b>Java", "<html><pre>Scala", "Ruby" };
  private String[] ides = {
      "IDEA", "<html><i>Eclipse", "NetBeans" };
  // �������� ��������� ������ ������
  private TreeModel createTreeModel() {
    // ������ ������ ������
    DefaultMutableTreeNode root =
        new DefaultMutableTreeNode(
            "<html><font color=blue>�������� ����");
    // �������� �����
    DefaultMutableTreeNode lang =
        new DefaultMutableTreeNode("�����");
    DefaultMutableTreeNode ide =
        new DefaultMutableTreeNode("�����");
    root.add(lang);
    root.add(ide);
    // ������������ ������
    for (int i=0; i<langs.length; i++) {
      lang.add(new DefaultMutableTreeNode(langs[i]));
      ide.add(new DefaultMutableTreeNode(ides[i]));
    }
    // ������� ����������� ������
    return new DefaultTreeModel(root);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TreeDefaultRendering(); } });
  }
}