// TreeSelectionModes.java
// Використання стандартної моделі виділення і
// всіх підтримуваних нею режимів
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;

public class TreeSelectionModes extends JFrame {
  public TreeSelectionModes() {
    super("TreeSelectionModes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо модель нашого дерева
    TreeModel model = createTreeModel();
    // дерево з одинарним режимом виділення
    JTree tree1 = new JTree(model);
    tree1.getSelectionModel().setSelectionMode(
        TreeSelectionModel.SINGLE_TREE_SELECTION);
    // дерево з виділенням нерозривними інтервалами
    JTree tree2 = new JTree(model);
    tree2.getSelectionModel().setSelectionMode(
        TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);
    // модель виділення можна зберігати і окремо
    TreeSelectionModel selModel =
        new DefaultTreeSelectionModel();
    selModel.setSelectionMode(
        TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
    JTree tree3 = new JTree(model);
    tree3.setSelectionModel(selModel);
    // будемо слідкувати за виділенням у останньому дереві
    tree3.addTreeSelectionListener(new SelectionL());
    // розміщення дерев на панелі
    JPanel contents = new JPanel(new GridLayout(1, 3));
    contents.add(new JScrollPane(tree1));
    contents.add(new JScrollPane(tree2));
    contents.add(new JScrollPane(tree3));
    add(contents);
    // додамо текстове поле
    add(new JScrollPane(log), "South");
    // виводимо вікно на екран
    setSize(500, 300);
    setVisible(true);
  }
  // текстове поле для інформації
  private JTextArea log = new JTextArea(5, 20);
  // листи дерева зберігаємо у масивах
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
    // приєднуємо листи
    for (int i=0; i<langs.length; i++) {
      lang.add(new DefaultMutableTreeNode(langs[i]));
      ide.add(new DefaultMutableTreeNode(ides[i]));
    }
    // створюємо стандартну модель
    return new DefaultTreeModel(root);
  }
  // цей прослуховувач слідкує за зміною виділення
  class SelectionL implements TreeSelectionListener {
    public void valueChanged(TreeSelectionEvent e)  {
      // отримуємо джерело події - дерево
      JTree tree = (JTree)e.getSource();
      // додавання видалення шляхів
      TreePath[] paths = e.getPaths();
      log.append("Змінено шляхів: " +
          paths.length + "\n");
      // виділені елементи та їх номери строк
      TreePath[] selected = tree.getSelectionPaths();
      int[] rows = tree.getSelectionRows();
      // останні елементи в шляху
      for (int i=0; i<selected.length; i++) {
        log.append("Виділений: " +
            selected[i].getLastPathComponent() +
            " на строці: " + rows[i] +  "\n");
      }
      // повна інформація про шляхи в дереві
      if ( selected.length > 0 ) {
        TreePath path = selected[0];
        Object[] nodes = path.getPath();
        for (int i=0; i<nodes.length; i++) {
          // шлях складається із вузлів
          DefaultMutableTreeNode node =
              (DefaultMutableTreeNode)nodes[i];
          log.append("Відрізок шляху " + i + " : " +
              node.getUserObject() + " ");
        }
      }
      log.append("\n");
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TreeSelectionModes(); } });
  }
}
