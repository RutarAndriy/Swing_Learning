// TreeExpansionEvents.java
// ������� ��� ������������� ����� ������
import javax.swing.*;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.ExpandVetoException;
import java.awt.*;

public class TreeExpansionEvents extends JFrame {
  public TreeExpansionEvents() {
    super("TreeExpansionEvents");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������ �� ������ ������
    JTree tree = new JTree(createTreeModel());
    // ��������� ����������
    TreeListener listener = new TreeListener();
    tree.addTreeExpansionListener(listener);
    tree.addTreeWillExpandListener(listener);
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
  // ��������� ������� � ������������� �����
  class TreeListener implements TreeExpansionListener,
      TreeWillExpandListener {
    public void treeExpanded(TreeExpansionEvent event) {
      System.out.println("���� ���������: " + event.getPath());
    }
    public void treeCollapsed(TreeExpansionEvent event) {
      System.out.println("���� �������: " + event.getPath());
    }
    public void treeWillExpand(TreeExpansionEvent event)
        throws ExpandVetoException { }
    public void treeWillCollapse(TreeExpansionEvent event)
        throws ExpandVetoException {
      if ( event.getPath().getLastPathComponent().
          toString().equals("�����") )
        throw new ExpandVetoException(event);
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TreeExpansionEvents(); } });
  }
}