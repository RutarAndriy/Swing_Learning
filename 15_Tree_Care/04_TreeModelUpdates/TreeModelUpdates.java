// TreeModelUpdates.java
// Приклад ефективного оновлення великого
// дерева зі змінними даними
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class TreeModelUpdates extends JFrame {
  // дерево
  private JTree tree;
  // стандартна модель дерева
  private DefaultTreeModel model;
  public TreeModelUpdates() {
    super("TreeModelUpdates");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо дерево на основі моделі
    tree = new JTree(model = createTreeModel());
    add(new JScrollPane(tree));
    setSize(400, 300);
    setVisible(true);
  }
  // створення нескладної, але великої моделі дерева
  private DefaultTreeModel createTreeModel() {
    // корінь нашого дерева
    DefaultMutableTreeNode root =
        new DefaultMutableTreeNode(
            "Велииииииике Дерево");
    // приєднюємо листи
    for (int i=0; i<100; i++) {
      DefaultMutableTreeNode node = new ChangeableColorNode();
      root.add(node);
      for (int k=0; k<10; k++) {
        node.add(new ChangeableColorNode());
      }
    }
    // створюємо стандартну модель
    return new DefaultTreeModel(root);
  }
  // вузол дерева, який динамічно оновлює свій вміст
  class ChangeableColorNode
      extends DefaultMutableTreeNode implements ActionListener {
    // випадкова затримка оновлення
    private int delay = (int) (Math.random()*3000 + 500);
    // колір тексту, який зберігається у вузлі
    private int r,g,b;
    public ChangeableColorNode() {
      // генеруємо кольори і запускаємо таймер оновлення
      generateColors();
      new Timer(delay, this).start();
    }
    // цей метод викликається таймером
    public void actionPerformed(ActionEvent e) {
      // оновлюємо колір та текст
      generateColors();
      // оновлюємо вузол, якщо він розкритий
      TreePath path = new TreePath(
          model.getPathToRoot(this));
      if ( tree.isVisible(path) ) {
        model.nodeChanged(this);
      }
    }
    // метод генерує випадкові кольори і оновлює текст
    public void generateColors() {
      r = (int) (Math.random()*255);
      g = (int) (Math.random()*255);
      b = (int) (Math.random()*255);
      setUserObject("<html><font color=rgb("
          +r+","+g+","+b+")>Який-небуть колір!");
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TreeModelUpdates(); } });
  }
}
