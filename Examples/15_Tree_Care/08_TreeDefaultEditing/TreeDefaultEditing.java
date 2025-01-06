// TreeDefaultEditing.java
// Стандартні редактори для дерев
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class TreeDefaultEditing extends JFrame {
  // листи дерев зберігаємо у масивах
  private String[] basics = {
      "Червоний", "Зелений", "Синій" };
  private String[] extendeds = {
      "Жовтий", "Голубий", "Рожевий" };
  public TreeDefaultEditing() {
    super("TreeDefaultEditing");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо дерево на основі простої моделі
    JTree tree = new JTree(createTreeModel());
    // вмикаємо редагування
    tree.setEditable(true);
    // "справжній" редактор
    JComboBox<String> combo = new JComboBox<>(
        new String[] {"Червоний", "Зелений"});
    DefaultCellEditor editor = new DefaultCellEditor(combo);
    // спеціальний редактор для дерев
    DefaultTreeCellRenderer renderer =
        new DefaultTreeCellRenderer();
    DefaultTreeCellEditor treeEditor =
        new DefaultTreeCellEditor(tree, renderer, editor);
    // приєднуємо редактор до дерева
    tree.setCellEditor(treeEditor);
    // виводимо вікно на екран
    add(new JScrollPane(tree));
    setSize(400, 300);
    setVisible(true);
  }
  // створення нескладної моделі дерева
  private TreeModel createTreeModel() {
    // корінь нашого дерева
    DefaultMutableTreeNode root =
        new DefaultMutableTreeNode("Кольори");
    // основні гілки
    DefaultMutableTreeNode basic =
        new DefaultMutableTreeNode("Основні");
    DefaultMutableTreeNode extended =
        new DefaultMutableTreeNode("Додаткові");
    root.add(basic);
    root.add(extended);
    // приєднюємо листи
    for (int i=0; i<basics.length; i++) {
      basic.add(new DefaultMutableTreeNode(basics[i]));
      extended.add(
          new DefaultMutableTreeNode(extendeds[i]));
    }
    // створюємо стандартну модель
    return new DefaultTreeModel(root);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TreeDefaultEditing(); } });
  }
}
