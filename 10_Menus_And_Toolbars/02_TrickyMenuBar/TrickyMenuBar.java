// TrickyMenuBar.java
// Смужка меню JMenuBar може багато
import javax.swing.*;
import java.awt.*;

public class TrickyMenuBar extends JFrame {
  public TrickyMenuBar() {
    super("TrickyMenuBar");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // створюємо основну смужку меню
    JMenuBar menuBar = new JMenuBar();
    // додаємо в неї випадаючі меню
    menuBar.add(new JMenu("Файл"));
    menuBar.add(new JMenu("Правка"));
    // ми знаємо, що використовується блочне
    // розташування, так що заповнювач
    // цілком доречний
    menuBar.add(Box.createHorizontalGlue());
    // тепер помістимо у смужку меню
    // не випадаюче меню, а напис зі значком
    JLabel icon = new JLabel(
        new ImageIcon("images/Download.gif"));
    icon.setBorder(
        BorderFactory.createLoweredBevelBorder());
    menuBar.add(icon);
    // моміщаємо меню у наше вікно
    setJMenuBar(menuBar);
    // виводимо вікно на екран
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new TrickyMenuBar(); } });
  }
}
