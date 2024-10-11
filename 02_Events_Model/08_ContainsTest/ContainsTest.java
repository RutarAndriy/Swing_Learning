// ContainsTest.java
// Зміна поведінки миші та метод contains()

import javax.swing.*;
import java.awt.*;

public class ContainsTest extends JFrame {
  public ContainsTest() {
    super("ContainsTest");
    // при закритті вікна - вихід
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // додамо кнопку і переоприділимо метод
    JButton button = new JButton("Невидима") {
      @Override
      public boolean contains(int x, int y) {
        // не містимо жодної точки
        return false;
      }
    };
    // налаштуємо панель вмісту та виведемо вікно на екран
    setLayout(new FlowLayout());
    add(button);
    setSize(300, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new ContainsTest();
          }
        });
  }
}
