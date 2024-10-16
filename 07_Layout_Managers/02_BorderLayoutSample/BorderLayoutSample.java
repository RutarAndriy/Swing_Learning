// BorderLayoutSample.java
// Полярне розташування
import javax.swing.*;
import java.awt.*;

public class BorderLayoutSample extends JFrame {
  public BorderLayoutSample()  {
    super("BorderLayoutSample");
    setSize(400, 300);
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // додаємо компоненти
    // у якості параметрів можна передавати строки
    add(new JButton("Північ"), "North");
    add(new JButton("Південь"), "South");
    // … або константи з класу BorderLayout
    add(new JLabel("Захід"), BorderLayout.WEST);
    add(new JLabel("Схід"), BorderLayout.EAST);
    // якщо параметр не задавати взагалі, компонент
    // автоматично додасться у центр
    add(new JButton("Центр"));
    // виводимо вікно на екран
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new BorderLayoutSample(); } });
  }
}
