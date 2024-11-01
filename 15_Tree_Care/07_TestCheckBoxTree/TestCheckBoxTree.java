// TestCheckBoxTree.java
// Перевірка дерева з підтримкою прапорців
import com.porty.swing.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class TestCheckBoxTree extends JFrame {
  public TestCheckBoxTree() {
    super("TestCheckBoxTree");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо модель і дерево
    TreeModel model = createTreeModel();
    CheckBoxTree tree = new CheckBoxTree(model);
    // додаємо дерево у вікно
    add(new JScrollPane(tree));
    // виводимо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }
  // листя дерева зберігаємо у масивах
  private String[] langs = { "Java", "Scala", "Ruby" };
  private String[] ides =
      { "IDEA", "Eclipse", "NetBeans" };
  // створення нескладної моделі дерева
  private TreeModel createTreeModel() {
    // корінь нашого дерева
    DefaultMutableTreeNode root =
        new DefaultMutableTreeNode("Створення коду");
    // основні гілки
    DefaultMutableTreeNode lang =
        new DefaultMutableTreeNode("Мови");
    DefaultMutableTreeNode ide =
        new DefaultMutableTreeNode("Середовища");
    root.add(lang);
    root.add(ide);
    // приєднуємо листя з даними для прапорців
    for (int i=0; i<langs.length; i++) {
      lang.add(new DefaultMutableTreeNode(
          new CheckBoxListElement(false, langs[i])));
      ide.add(new DefaultMutableTreeNode(
          new CheckBoxListElement(false, ides[i])));
    }
    // створюємо стандартну модель
    return new DefaultTreeModel(root);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TestCheckBoxTree(); } });
  }
}
