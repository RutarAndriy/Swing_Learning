// Scrollbars.java
// Смуги прокручування JScrollBar
import javax.swing.*;
import java.awt.*;

public class Scrollbars extends JFrame {
  public Scrollbars() {
    super("Scrollbars");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо стандартну модель
    BoundedRangeModel model =
        new DefaultBoundedRangeModel(10, 40, 0, 100);
    // пара смуг прокручування
    JScrollBar scrollbar1 = new JScrollBar(
        JScrollBar.HORIZONTAL);
    JScrollBar scrollbar2 = new JScrollBar(
        JScrollBar.VERTICAL);
    // приєднуємо модель
    scrollbar1.setModel(model);
    scrollbar2.setModel(model);
    // додаємо компоненти до панелі
    add(scrollbar1, "South");
    add(scrollbar2, "East");
    // виводимо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new Scrollbars(); } });
  }
}
