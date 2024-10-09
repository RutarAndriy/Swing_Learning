// Adapters.java
// Використання адаптерів замість інтерфейсів

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Adapters extends JFrame {
  public Adapters() {
    super("Adapters");
    // при закритті вікна - вихід
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // реєструємо прослуховувача
    addMouseListener(new MouseL());
    // виводимо вікно на екран
    setSize(200, 200);
    setVisible(true);
  }

  // наслідуємо від адаптера
  class MouseL extends MouseAdapter {
    // слідкуємо за клацанням миші у вікні
    @Override
    public void mouseClicked(MouseEvent e) {
      System.out.println(e);
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new Adapters();
          }
        });
  }
}
