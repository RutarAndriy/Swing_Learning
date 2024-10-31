// UsingDefaultTreeModel.java
// Використання стандартної моделі дерева та 
// вузлів DefaultMutableTreeNode
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class UsingDefaultTreeModel extends JFrame {
  // для зручності листи будемо зберігати в масивах
  private String[] drinks =  { "Коктейль", "Сік", "Морс" };
  private String[] fruits =  { "Яблука", "Апельсини" };
  public UsingDefaultTreeModel() {
    super("UsingDefaultTreeModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо нашу деревовидну структуру
    DefaultMutableTreeNode root =
        new DefaultMutableTreeNode("Корінь дерева");
    // основні гілки
    DefaultMutableTreeNode drink =
        new DefaultMutableTreeNode("Напитки");
    DefaultMutableTreeNode fruit =
        new DefaultMutableTreeNode("Фрукти");
    // додаємо гілки
    root.add(drink);
    root.add(fruit);
    // спеціальний конструктор
    root.add(new DefaultMutableTreeNode("Десерт", true));
    // додаємо листи
    for (String _drink : drinks) {
      drink.add(
          new DefaultMutableTreeNode(_drink, false));
    }
    for (String _fruit : fruits) {
      fruit.add(
          new DefaultMutableTreeNode(_fruit, false));
    }
    // створюємо стандартну модель і дерево
    DefaultTreeModel dtm1 =
        new DefaultTreeModel(root, true);
    JTree tree1 = new JTree(dtm1);
    // модель можна створити, починаючи із будь-якого вузла
    DefaultTreeModel dtm2 = new DefaultTreeModel(drink);
    JTree tree2 = new JTree(dtm2);
    // додаємо дерево у вікно і відображаємо його
    setLayout(new GridLayout(1, 2));
    add(new JScrollPane(tree1));
    add(new JScrollPane(tree2));
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingDefaultTreeModel(); } });
  }
}
