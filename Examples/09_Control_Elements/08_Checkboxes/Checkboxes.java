// Checkboxes.java
// Використання крапорців JCheckBox
import javax.swing.*;
import java.awt.*;

public class Checkboxes extends JFrame {
  public Checkboxes() {
    super("Checkboxes");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // використовуємо послідовне розміщення
    setLayout(new FlowLayout());
    // окремий прапорець
    JCheckBox ch = new JCheckBox("Я люблю KFC", true);
    // група зв'язаних прапорців у своїй
    // власній панелі
    JPanel panel = new JPanel(new GridLayout(0, 1, 0, 5));
    panel.setBorder(
        BorderFactory.createTitledBorder("Морозиво"));
    String[] names = { "Крем-брюле",
        "Ром з ізюмом", "Шоколадне" };
    for (String name : names) {
      JCheckBox check = new JCheckBox(name);
      panel.add(check);
    }
    // додаємо все в контейнер
    add(ch);
    add(panel);
    // виводимо вікно на екран
    pack();
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new Checkboxes(); } });
  }
}
