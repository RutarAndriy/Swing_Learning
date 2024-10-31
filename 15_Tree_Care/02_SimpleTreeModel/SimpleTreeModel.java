// SimpleTreeModel.java
// Створення простої моделі для дерева
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.util.*;
import java.awt.*;

public class SimpleTreeModel extends JFrame {
  public SimpleTreeModel() {
    super("SimpleTreeModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // дерево на основі нашої моделі
    JTree tree = new JTree(new SimpleModel());
    // додаємо його у вікно
    add(new JScrollPane(tree));
    setSize(300, 200);
    setVisible(true);
  }

  // наша модель для дерева
  class SimpleModel implements TreeModel {
    // корінь дерева і основні вузли
    private String root = "Що-небуть цікаве";
    private String
        colors = "Кольори",
        food = "Їжа";
    // сховища даних
    private ArrayList<String> rootList = new ArrayList<String>(),
        colorsList = new ArrayList<String>(),
        foodList = new ArrayList<String>();
    public SimpleModel() {
      // заповнюємо списки даними
      rootList.add(colors);
      rootList.add(food);
      colorsList.add("Червоний");
      colorsList.add("Зелений");
      foodList.add("Морозиво");
      foodList.add("Бутерброд");
    }

    // повертаємо корінь дерева
    public Object getRoot() {
      return root;
    }

    // овідомляє про кількість нащадків вузла
    public int getChildCount(Object parent) {
      if ( parent == root ) return rootList.size();
      else if ( parent == colors )
        return colorsList.size();
      else if ( parent == food ) return foodList.size();
      return 0;
    }

    // повертає нащадка вузла за порядковим номером
    public Object getChild(Object parent, int index) {
      if ( parent == root )
        return rootList.get(index);
      else if ( parent == colors )
        return colorsList.get(index);
      else if ( parent == food )
        return foodList.get(index);
      return null;
    }

    // дозволяє отримати порядковий номер нащадка
    public int getIndexOfChild(
        Object parent, Object child) {
      if ( parent == root )
        return rootList.indexOf(child);
      else if ( parent == colors )
        return colorsList.indexOf(child);
      else if ( parent == food )
        return foodList.indexOf(child);
      return 0;
    }

    // визначає, які вузли є листами
    public boolean isLeaf(Object node) {
      if ( colorsList.contains(node) ||
          foodList.contains(node) ) return true;
      else return false;
    }

    // викликається при зміні значення деякого вузла
    // для нашої моделі не знадобиться
    public void valueForPathChanged(
        TreePath path, Object value) {
    }

    // методи для приєднання та видалення прослуховувачів
    // нашій простій моделі не знадобляться
    public void addTreeModelListener(
        TreeModelListener tml) {
    }
    public void removeTreeModelListener(
        TreeModelListener tml) {
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleTreeModel(); } });
  }
}
