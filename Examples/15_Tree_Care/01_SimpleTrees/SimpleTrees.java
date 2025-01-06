// SimpleTrees.java
// Створення найпростіших дерев
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class SimpleTrees extends JFrame {
  public SimpleTrees() {
    super("SimpleTrees");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створення дерева на основі масиву
    Object[] data = new Object[] { "Перший", "Другий",
        "Третій", new String[] { "Чийсь нащадок",
            "Ще нащадок" }
    };
    JTree tree1 = new JTree(data);
    // дерево на основі вектора
    Vector<String> vector = new Vector<String>();
    for (int i=0; i<5; i++) vector.add("Лист № " + i);
    JTree tree2 = new JTree(vector);
    // дерево на основі таблиці
    Hashtable<String,String> table =
        new Hashtable<String,String>();
    table.put("Одна", "пара");
    table.put("Ще одна", "також пара");
    JTree tree3 = new JTree(table);
    // можна відобразити показ кореня дерева
    tree3.setRootVisible(true);
    // додамо дерева одне за одним
    setLayout(new FlowLayout());
    add(tree1);
    add(tree2);
    add(tree3);
    // виводимо віно на екран
    setSize(400, 300);
    setVisible(true);

  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleTrees(); } });
  }
}
