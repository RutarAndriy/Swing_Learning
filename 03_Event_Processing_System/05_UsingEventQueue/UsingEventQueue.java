// UsingEventQueue.java
// Використання черги подій

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UsingEventQueue extends JFrame {
  public UsingEventQueue() {
    super("UsingEventQueue");
    // вихід при закриванні вікна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // кнопка та її прослуховувач
    JButton button = new JButton("Генерувати подію");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // генеруємо подію закривання вікна
        getToolkit().getSystemEventQueue().postEvent(
            new WindowEvent(UsingEventQueue.this,
                WindowEvent.WINDOW_CLOSING));
      }
    });
    // додаємо кнопку в панель вмісту
    setLayout(new FlowLayout());
    add(button);
    // виводимо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new UsingEventQueue();
          }
        });
  }
}
