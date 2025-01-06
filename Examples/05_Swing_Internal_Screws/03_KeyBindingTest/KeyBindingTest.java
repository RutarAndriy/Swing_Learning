// KeyBindingTest.java
// Приклад використання клавіатурних скорочень
import javax.swing.*;
import java.awt.event.*;

public class KeyBindingTest extends JFrame {
  public KeyBindingTest() {
    super("KeyBindingTest");
    // вихід при закриванні вікна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // налаштування карти команд та вхідних подій для
    // кореневої панелі програми
    InputMap im = getRootPane().getInputMap();
    ActionMap am = getRootPane().getActionMap();
    // спрацьовує при відпусканні комбінації Ctrl+A
    im.put(KeyStroke.getKeyStroke(
        KeyEvent.VK_A,
        KeyEvent.CTRL_DOWN_MASK, true), "Action");
    // спрацьовує при друкуванні великої літери 'Я'
    im.put(KeyStroke.getKeyStroke('Я'), "Action");
    am.put("Action", new AnAction());
    // виводимо вікно на екран
    setSize(200, 200);
    setVisible(true);
  }

  // клас нашої команди
  class AnAction extends AbstractAction {
    public void actionPerformed(ActionEvent e) {
      System.out.println("OK");
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new KeyBindingTest(); } });
  }
}
