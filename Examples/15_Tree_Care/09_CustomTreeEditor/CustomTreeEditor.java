// CustomTreeEditor.java
// Створення спеціалізованого редактора вузлів
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
    // налаштовуємо дерево
    JTree tree = new JTree(createTreeModel());
    // вмикаємо редагування вузлів
    tree.setEditable(true);
    DefaultTreeCellRenderer renderer =
        new DefaultTreeCellRenderer();
    DefaultTreeCellEditor editor =
        new DefaultTreeCellEditor(tree, renderer,
            new MaskTreeEditor(tree));
    tree.setCellEditor(editor);
    // виводимо вікно на екран
    add(new JScrollPane(tree));
    setSize(400, 300);
    setVisible(true);
  }
  // список телефонів
  private String[] phoneDirectory = {
      "123-13-13", "444-55-67", "111-23-45"};
  // створює модель дерева
  private TreeModel createTreeModel() {
    DefaultMutableTreeNode root =
        new DefaultMutableTreeNode("Компанія");
    DefaultMutableTreeNode node =
        new DefaultMutableTreeNode("Відділ кадрів");
    root.add(node);
    // приєднуємо листи
    for (String phone : phoneDirectory) {
      node.add(new DefaultMutableTreeNode(phone));
    }
    return new DefaultTreeModel(root);
  }
  // спеціальний редактор вузлів дерева
  class MaskTreeEditor extends AbstractCellEditor
      implements TreeCellEditor {
    // дерево
    private JTree tree;
    // текстове поле, яке використовується для редагування
    private JFormattedTextField editor;
    // конструктор редактора
    public MaskTreeEditor(JTree tree) {
      this.tree = tree;
      // створюємо форматуючий об'єкт
      try {
        MaskFormatter phone =
            new MaskFormatter("###-##-##");
        editor = new JFormattedTextField(phone);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      // приєднюємо до поля прослуховувача
      editor.addActionListener(new ActionListener() {
        // викликається при закінченні редагування
        public void actionPerformed(ActionEvent e) {
          stopCellEditing();
        }
      });
    }
    // повертає компонент, який використовується як редактор
    public Component getTreeCellEditorComponent(
        JTree tree, Object value, boolean selected,
        boolean expanded, boolean leaf, int row) {
      // встановлюємо нове значення
      editor.setText(value.toString());
      // повертаємо текстове поле
      return editor;
    }
    // повертаємо поточне значення в редакторі
    public Object getCellEditorValue() {
      return editor.getText();
    }
    // визначає, чи можна проводити редагування
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
