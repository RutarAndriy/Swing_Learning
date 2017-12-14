// TreeModelUpdates.java
// ������ ������������ ���������� ��������
// ������ � ����������� �������
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class TreeModelUpdates extends JFrame {
  // ������
  private JTree tree;
  // ����������� ������ ������
  private DefaultTreeModel model;
  public TreeModelUpdates() {
    super("TreeModelUpdates");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������ �� ������ ������
    tree = new JTree(model = createTreeModel());
    add(new JScrollPane(tree));
    setSize(400, 300);
    setVisible(true);
  }
  // �������� ���������, �� ������� ������ ������
  private DefaultTreeModel createTreeModel() {
    // ������ ������ ������
    DefaultMutableTreeNode root =
        new DefaultMutableTreeNode(
            "���������� ������");
    // ������������ ������
    for (int i=0; i<100; i++) {
      DefaultMutableTreeNode node = new ChangeableColorNode();
      root.add(node);
      for (int k=0; k<10; k++) {
        node.add(new ChangeableColorNode());
      }
    }
    // ������� ����������� ������
    return new DefaultTreeModel(root);
  }
  // ���� ������, ����������� ����������� ���� ����������
  class ChangeableColorNode
      extends DefaultMutableTreeNode implements ActionListener {
    // ��������� �������� ����������
    private int delay = (int) (Math.random()*3000 + 500);
    // ����� ������, ��������� � ����
    private int r,g,b;
    public ChangeableColorNode() {
      // ���������� ����� � ��������� ������ ����������
      generateColors();
      new Timer(delay, this).start();
    }
    // ���� ����� ���������� ��������
    public void actionPerformed(ActionEvent e) {
      // ��������� ����� � �����
      generateColors();
      // ��������� ���� ���� �� ���������
      TreePath path = new TreePath(
          model.getPathToRoot(this));
      if ( tree.isVisible(path) ) {
        model.nodeChanged(this);
      }
    }
    // ����� ���������� ��������� ����� � ��������� �����
    public void generateColors() {
      r = (int) (Math.random()*255);
      g = (int) (Math.random()*255);
      b = (int) (Math.random()*255);
      setUserObject("<html><font color=rgb("
          +r+","+g+","+b+")>�����-�� ����!");
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TreeModelUpdates(); } });
  }
}
