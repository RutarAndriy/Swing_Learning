// AnonymousClassEvents.java
// Анонімні класи для обробки подій

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AnonymousClassEvents extends JFrame {
  public AnonymousClassEvents() {
    super("AnonymousClassEvents");
    // анонімний клас приєднується прямо на місці
    // вихід із програми при закритті вікна
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    // додаємо кнопку
    JButton button = new JButton("Натисни мене");
    getContentPane().add(button);
    // прослуховувач створюється в методі
    button.addActionListener(getButtonL());
    // виводимо вікно на екран
    pack();
    setVisible(true);
  }

  // цей метод створює прослуховувача для кнопки
  public ActionListener getButtonL() {
    return new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("ActionListener");
      }
    };
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new AnonymousClassEvents();
          }
        });
  }
}
