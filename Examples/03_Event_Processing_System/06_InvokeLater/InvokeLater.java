// InvokeLater.java
// Метод invokeLater() та робота з потоком розсилки подій

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InvokeLater extends JFrame {
  public InvokeLater() {
    super("InvokeLater");
    // при закритті вікна - вихід
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // додаємо кнопку із прослуховувачем
    button = new JButton("Виконати важку роботу");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // запускаємо окремий потік
        new ComplexJobThread().start();
        button.setText("Почекайте...");
      }
    });
    // налаштуємо панель вмісту та виведемо вікно на екран
    setLayout(new FlowLayout());
    add(new JTextField(20));
    add(button);
    setSize(300, 200);
    setVisible(true);
  }

  private JButton button;

  // потік, виконуючий "важку роботу"
  class ComplexJobThread extends Thread {
    public void run() {
      try {
        // уявимо затримку
        sleep(3000);
        // робота завершена, потрібно змінити інтерфейс
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            button.setText("Робота завершена");
          }
        });
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new InvokeLater();
          }
        });
  }
}
