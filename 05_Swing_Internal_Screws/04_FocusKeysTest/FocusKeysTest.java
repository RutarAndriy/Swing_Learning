// FocusKeysTest.java
// Налаштування клавіш переходу фокусу вводу
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashSet;

public class FocusKeysTest extends JFrame {
  public FocusKeysTest() {
    super("FocusKeysTest");
    // вихід при закриванні вікна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // додаємо декілька кнопок
    setLayout(new FlowLayout());
    // особлива кнопка
    JButton button = new JButton("Особлива");
    add(button);
    add(new JButton("Звичайна"));
    // налаштуємо клавіші передавання фокусу
    HashSet<AWTKeyStroke> set = new HashSet<AWTKeyStroke>();
    set.add(AWTKeyStroke.getAWTKeyStroke(
        'Q', KeyEvent.CTRL_MASK));
    button.setFocusTraversalKeys(
        KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, set);
    // виводимо вікно на екран
    setSize(200, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new FocusKeysTest(); } });
  }
}
