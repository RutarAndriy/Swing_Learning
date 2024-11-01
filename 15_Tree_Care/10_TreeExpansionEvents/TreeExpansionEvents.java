// TreeExpansionEvents.java
// Події при розгортанні вузлів дерева
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
    // створюємо дерево на основі моделі
    JTree tree = new JTree(createTreeModel());
    // додаємо прослуховувачів
    TreeListener listener = new TreeListener();
    tree.addTreeExpansionListener(listener);
    tree.addTreeWillExpandListener(listener);
    add(new JScrollPane(tree));
    setSize(400, 300);
    setVisible(true);
  }
  // листи дерев зберігаємо в масивах
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
    // приєднюємо листи
    for (int i=0; i<langs.length; i++) {
      lang.add(new DefaultMutableTreeNode(langs[i]));
      ide.add(new DefaultMutableTreeNode(ides[i]));
    }
    // створюємо стандартну модель
    return new DefaultTreeModel(root);
  }
  // прослуховувач подій про розгортання вузлів
  class TreeListener implements TreeExpansionListener,
      TreeWillExpandListener {
    public void treeExpanded(TreeExpansionEvent event) {
      System.out.println("Вузол розгорнутий: " + event.getPath());
    }
    public void treeCollapsed(TreeExpansionEvent event) {
      System.out.println("Вузол згорнутий: " + event.getPath());
    }
    public void treeWillExpand(TreeExpansionEvent event)
        throws ExpandVetoException { }
    public void treeWillCollapse(TreeExpansionEvent event)
        throws ExpandVetoException {
      if ( event.getPath().getLastPathComponent().
          toString().equals("Мови") )
        throw new ExpandVetoException(event);
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TreeExpansionEvents(); } });
  }
}
