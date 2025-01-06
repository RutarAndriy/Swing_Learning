// TreeDefaultRendering.java
// Використання можливостей стандартного
// відображуваного об'єкта DefaultTreeCellRenderer
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class TreeDefaultRendering extends JFrame {
  public TreeDefaultRendering() {
    super("TreeDefaultRendering");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо дерево на основі невибагливої моделі
    JTree tree = new JTree(createTreeModel());
    // створюємо та налаштовуємо відображуваний об'єкт
    DefaultTreeCellRenderer renderer =
        new DefaultTreeCellRenderer();
    renderer.setLeafIcon(new ImageIcon("Leaf.gif"));
    renderer.setClosedIcon(
        new ImageIcon("NodeClosed.gif"));
    renderer.setOpenIcon(
        new ImageIcon("NodeOpened.gif"));
    // передаємо його дереву
    tree.setCellRenderer(renderer);
    // додаємо дерево і виводимо його на екран
    add(new JScrollPane(tree));
    setSize(400, 300);
    setVisible(true);
  }
  // листи дерева зберігаємо у масивах
  private String[] langs = {
      "<html><b>Java", "<html><pre>Scala", "Ruby" };
  private String[] ides = {
      "IDEA", "<html><i>Eclipse", "NetBeans" };
  // створення нескладної моделі дерева
  private TreeModel createTreeModel() {
    // корінь нашого дерева
    DefaultMutableTreeNode root =
        new DefaultMutableTreeNode(
            "<html><font color=blue>Створення коду");
    // основні гілки
    DefaultMutableTreeNode lang =
        new DefaultMutableTreeNode("Мови");
    DefaultMutableTreeNode ide =
        new DefaultMutableTreeNode("Середовища");
    root.add(lang);
    root.add(ide);
    // приєднання листів
    for (int i=0; i<langs.length; i++) {
      lang.add(new DefaultMutableTreeNode(langs[i]));
      ide.add(new DefaultMutableTreeNode(ides[i]));
    }
    // створюємо стандартну модель
    return new DefaultTreeModel(root);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TreeDefaultRendering(); } });
  }
}
