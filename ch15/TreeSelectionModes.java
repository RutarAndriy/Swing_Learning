// TreeSelectionModes.java
// ������������� ����������� ������ ��������� �
// ���� �������������� �� �������
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;

public class TreeSelectionModes extends JFrame {
  public TreeSelectionModes() {
    super("TreeSelectionModes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // �������� ������ ������ ������
    TreeModel model = createTreeModel();
    // ������ � ��������� ������� ���������
    JTree tree1 = new JTree(model);
    tree1.getSelectionModel().setSelectionMode(
        TreeSelectionModel.SINGLE_TREE_SELECTION);
    // ������ � ���������� ������������ �����������
    JTree tree2 = new JTree(model);
    tree2.getSelectionModel().setSelectionMode(
        TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);
    // ������ ��������� ����� ������� � ��������
    TreeSelectionModel selModel =
        new DefaultTreeSelectionModel();
    selModel.setSelectionMode(
        TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
    JTree tree3 = new JTree(model);
    tree3.setSelectionModel(selModel);
    // ����� ������� �� ���������� � ��������� ������
    tree3.addTreeSelectionListener(new SelectionL());
    // ��������� ������� � ������
    JPanel contents = new JPanel(new GridLayout(1, 3));
    contents.add(new JScrollPane(tree1));
    contents.add(new JScrollPane(tree2));
    contents.add(new JScrollPane(tree3));
    add(contents);
    // ��������� ��������� ����
    add(new JScrollPane(log), "South");
    // ������� ���� �� �����
    setSize(500, 300);
    setVisible(true);
  }
  // ��������� ���� ��� ����������
  private JTextArea log = new JTextArea(5, 20);
  // ������ ������ ������ � ��������
  private String[] langs = { "Java", "Scala", "Ruby" };
  private String[] ides =
      { "IDEA", "Eclipse", "NetBeans" };
  // �������� ��������� ������ ������
  private TreeModel createTreeModel() {
    // ������ ������ ������
    DefaultMutableTreeNode root =
        new DefaultMutableTreeNode("�������� ����");
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
  // ���� ��������� ������ �� ���������� ���������
  class SelectionL implements TreeSelectionListener {
    public void valueChanged(TreeSelectionEvent e)  {
      // �������� �������� ������� - ������
      JTree tree = (JTree)e.getSource();
      // �����������/��������� ����
      TreePath[] paths = e.getPaths();
      log.append("�������� �����: " +
          paths.length + "\n");
      // ���������� �������� � �� ������ �����
      TreePath[] selected = tree.getSelectionPaths();
      int[] rows = tree.getSelectionRows();
      // ��������� �������� � ����
      for (int i=0; i<selected.length; i++) {
        log.append("�������: " +
            selected[i].getLastPathComponent() +
            " �� ������: " + rows[i] +  "\n");
      }
      // ������ ���������� � ���� � ������
      if ( selected.length > 0 ) {
        TreePath path = selected[0];
        Object[] nodes = path.getPath();
        for (int i=0; i<nodes.length; i++) {
          // ���� ������� �� �����
          DefaultMutableTreeNode node =
              (DefaultMutableTreeNode)nodes[i];
          log.append("������� ���� " + i + " : " +
              node.getUserObject() + " ");
        }
      }
      log.append("\n");
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TreeSelectionModes(); } });
  }
}