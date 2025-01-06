// FloatingWindow.java
// Вікно без рамки, яке завжди залишається
// вище основного вікна програми
import javax.swing.*;

public class FloatingWindow extends JFrame {
  public FloatingWindow() {
    super("FloatingWindow");
    // вихід при закриванні вікна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // виводимо головне вікно на екран
    setSize(400, 300);
    setVisible(true);
    // додаємо плаваюче вікно
    JWindow window = new JWindow(this);
    // завжди над іншими вікнами
    window.setAlwaysOnTop(true);
    window.setType(Type.UTILITY);
    // виводимо вікно на екран
    window.setSize(100, 300);
    window.setVisible(true);

  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
      new Runnable() {
        public void run() { new FloatingWindow(); } });
  }
}
