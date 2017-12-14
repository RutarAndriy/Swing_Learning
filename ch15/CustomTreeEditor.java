// CustomTreeEditor.java
// �������� ������������������� ��������� �����
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;

public class CustomTreeEditor extends JFrame {
  public CustomTreeEditor() {
    super("CustomTreeEditor");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ����������� ������
    JTree tree = new JTree(createTreeModel());
    // �������� �������������� �����
    tree.setEditable(true);
    DefaultTreeCellRenderer renderer =
        new DefaultTreeCellRenderer();
    DefaultTreeCellEditor editor =
        new DefaultTreeCellEditor(tree, renderer,
            new MaskTreeEditor(tree));
    tree.setCellEditor(editor);
    // ������� ���� �� �����
    add(new JScrollPane(tree));
    setSize(400, 300);
    setVisible(true);
  }
  // ������ ���������
  private String[] phoneDirectory = {
      "123-13-13", "444-55-67", "111-23-45"};
  // ������� ������ ������
  private TreeModel createTreeModel() {
    DefaultMutableTreeNode root =
        new DefaultMutableTreeNode("��������");
    DefaultMutableTreeNode node =
        new DefaultMutableTreeNode("����� ������");
    root.add(node);
    // ������������ ������
    for (String phone : phoneDirectory) {
      node.add(new DefaultMutableTreeNode(phone));
    }
    return new DefaultTreeModel(root);
  }
  // ����������� �������� ����� ������
  class MaskTreeEditor extends AbstractCellEditor
      implements TreeCellEditor {
    // ������
    private JTree tree;
    // ��������� ����, ����������� ��� ��������������
    private JFormattedTextField editor;
    // ����������� ���������
    public MaskTreeEditor(JTree tree) {
      this.tree = tree;
      // ������� ������������� ������
      try {
        MaskFormatter phone =
            new MaskFormatter("###-##-##");
        editor = new JFormattedTextField(phone);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      // ������������ � ���� ���������
      editor.addActionListener(new ActionListener() {
        // ���������� ��� ��������� ��������������
        public void actionPerformed(ActionEvent e) {
          stopCellEditing();
        }
      });
    }
    // ���������� ���������, ������������ ��� ��������
    public Component getTreeCellEditorComponent(
        JTree tree, Object value, boolean selected,
        boolean expanded, boolean leaf, int row) {
      // ������������� ����� ��������
      editor.setText(value.toString());
      // ���������� ��������� ����
      return editor;
    }
    // ��������� ������� �������� � ���������
    public Object getCellEditorValue() {
      return editor.getText();
    }
    // ����������, ����� �� ��������� ��������������
    public boolean isCellEditable(EventObject event) {
      MutableTreeNode node = (MutableTreeNode)
          tree.getLastSelectedPathComponent();
      return ( (node != null) && ( node.isLeaf()) );
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new CustomTreeEditor(); } });
  }
}