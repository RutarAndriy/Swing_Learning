// TestCheckBoxTree.java
// �������� ������ � ���������� �������
import com.porty.swing.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class TestCheckBoxTree extends JFrame {
  public TestCheckBoxTree() {
    super("TestCheckBoxTree");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������ � ������
    TreeModel model = createTreeModel();
    CheckBoxTree tree = new CheckBoxTree(model);
    // ��������� ������ � ����
    add(new JScrollPane(tree));
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }
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
    // ������������ ������ � ������� ��� �������
    for (int i=0; i<langs.length; i++) {
      lang.add(new DefaultMutableTreeNode(
          new CheckBoxListElement(false, langs[i])));
      ide.add(new DefaultMutableTreeNode(
          new CheckBoxListElement(false, ides[i])));
    }
    // ������� ����������� ������
    return new DefaultTreeModel(root);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TestCheckBoxTree(); } });
  }
}