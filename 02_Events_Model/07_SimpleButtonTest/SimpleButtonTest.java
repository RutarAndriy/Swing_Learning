// SimpleButtonTest.java
// Обробка події нового компонента

import javax.swing.*;

import com.porty.swing.*;
import com.porty.swing.event.*;

import java.awt.*;

public class SimpleButtonTest extends JFrame {
  public SimpleButtonTest() {
    super("SimpleButtonTest");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо кнопку і приєднуємо прослуховувачів
    SimpleButton button = new SimpleButton();
    // анонімний клас
    button.addButtonPressListener(
        new ButtonPressListener() {
          public void buttonPressed(ButtonPressEvent e) {
            System.out.println("1!");
          }
        });
    // внутрішній клас
    button.addButtonPressListener(new ButtonL());
    // додаємо кнопку у вікно
    JPanel contents = new JPanel();
    contents.add(button);
    setContentPane(contents);
    // виводимо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }

  class ButtonL implements ButtonPressListener {
    public void buttonPressed(ButtonPressEvent e) {
      System.out.println("2!");
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new SimpleButtonTest();
          }
        });
  }
}
