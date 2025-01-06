// ImageList.java
// Список, використовуючий новий малюючий об'єкт
import javax.swing.*;
import com.porty.swing.*;

import java.awt.*;

public class ImageList {
  // дані списку
  private static Icon bullet = new ImageIcon("Bullet.gif");
  private static Object[] data = {
      new ImageListElement(bullet, "Перший"),
      new ImageListElement(bullet, "Другий"),
      new ImageListElement(bullet,
          "<html><h4><font color=green>І третій!")
  };
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            // створюємо список і налаштовуємо його
            JList<Object> list = new JList<>(data);
            list.setCellRenderer(new ImageListCellRenderer());
            // додаємо у вікно
            JFrame frame = new JFrame("ImageList");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(200, 200);
            frame.add(new JScrollPane(list));
            frame.setVisible(true);
          } });
  }
}
