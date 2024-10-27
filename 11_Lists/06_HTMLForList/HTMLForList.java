// HTMLForList.java
// Використання стандартного об'єкта
// DefaultListCellRenderer
import javax.swing.*;
import java.awt.*;

public class HTMLForList {
  // дані списку
  private static Object[] data = {
      "<html><font size=4 color=red>Перший",
      new ImageIcon("Bullet.gif"),
      "<html><h2><font color=yellow>Великий"
  };
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            // створюємо список
            JList list = new JList(data);
            // поміщаємо його у вікно
            JFrame frame = new JFrame("HTMLForList");
            frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
            frame.setSize(200, 200);
            frame.add(new JScrollPane(list));
            frame.setVisible(true);
          } });
  }
}
