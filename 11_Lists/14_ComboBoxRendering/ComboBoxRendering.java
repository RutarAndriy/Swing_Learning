// ComboBoxRendering.java
// Відображення елементів випадаючого списку
import javax.swing.*;
import com.porty.swing.*;

import java.awt.*;

public class ComboBoxRendering extends JFrame {
  // дані для першого списку
  private String[] textData = { "<html><code>Перший",
      "<html><b>Жирний", "<html><font color=red>Червоний",
      "<html><em>Виразний" };
  // значки
  private ImageIcon bullet1 =
      new ImageIcon("Server16.gif");
  private ImageIcon bullet2 =
      new ImageIcon("Host16.gif");
  // дані для другого списку зі значками
  private ImageListElement[] iconData = {
      new ImageListElement(bullet1, "Основний сервер"),
      new ImageListElement(bullet1, "Додатковий"),
      new ImageListElement(bullet2,
          "<html><b><em>Машина директора")
  };
  public ComboBoxRendering() {
    super("ComboBoxRendering");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо пару випадаючих списків
    JComboBox combo1 = new JComboBox(textData);
    JComboBox combo2 = new JComboBox(iconData);
    // наш спеціальний відображуваний об'єкт
    combo2.setRenderer(new ImageListCellRenderer());
    // додаємо списки у вікно
    setLayout(new FlowLayout());
    add(combo1);
    add(combo2);
    // виводимо вікно на екран
    setSize(350, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ComboBoxRendering(); } });
  }
}
