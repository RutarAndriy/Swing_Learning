// ConsumingEvents.java
// Поглинання подій

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConsumingEvents extends JFrame {
  public ConsumingEvents() {
    super("ConsumingEvents");
    // при закритті вікна - вихід
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // прослуховувач, поглинаючий друкування символів
    KeyListener kl = new KeyAdapter() {
      @Override
      public void keyTyped(KeyEvent e) {
        e.consume();
      }
    };
    // додаємо текстові поля
    setLayout(new FlowLayout());
    JTextField swingField = new JTextField(10);
    swingField.addKeyListener(kl);
    add(swingField);
    TextField awtField = new TextField(10);
    add(awtField);
    awtField.addKeyListener(kl);
    // кнопка
    JButton button = new JButton("Натисніть!");
    add(button);
    // прослуховувач намагається поглинути подію від миші
    button.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        e.consume();
      }
    });
    // виводимо вікно на екран
    setSize(300, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new ConsumingEvents();
          }
        });
  }
}
