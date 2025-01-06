// SimpleSliders.java
// Прості повзунки
import javax.swing.*;
import java.awt.*;

public class SimpleSliders extends JFrame {
  public SimpleSliders() {
    super("SimpleSliders");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо декілька повзунків
    JSlider s1 = new JSlider(0, 100);
    JSlider s2 = new JSlider(
        JSlider.VERTICAL, 0, 200, 50);
    // налаштування зовнішнього вигляду
    s2.setPaintTicks(true);
    s2.setMajorTickSpacing(50);
    s2.setMinorTickSpacing(10);
    JSlider s3 = new JSlider(0, 50, 40);
    s3.setPaintLabels(true);
    s3.setMajorTickSpacing(10);
    // додамо їх у панель вмісту
    setLayout(new FlowLayout());
    add(s1);
    add(s2);
    add(s3);
    // виводимо вікно на екран
    setSize(300, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleSliders(); } });
  }
}
