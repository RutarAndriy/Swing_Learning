// ForwardingEvents.java
// Техніка диспетчеризації подій

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ForwardingEvents extends JFrame {
  public ForwardingEvents() {
    super("ForwardingEvents");
    // при закритті вікна - вихід
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // послідовне розміщення
    getContentPane().setLayout(new FlowLayout());
    // додаємо пару кнопок
    button1 = new JButton("ОК");
    button2 = new JButton("Відміна");
    getContentPane().add(button1);
    getContentPane().add(button2);
    // будемо слідкувати за натисканнями кнопок
    Forwarder forwarder = new Forwarder();
    button1.addActionListener(forwarder);
    button2.addActionListener(forwarder);
    // виводимо вікно на екран
    pack();
    setVisible(true);
  }

  JButton button1, button2;

  // клас-прослуховувач натискання на кнопку
  class Forwarder implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      // розсилаємо події по методах
      if (e.getSource() == button1) onOK(e);
      if (e.getSource() == button2) onCancel(e);
    }
  }

  // обробка події від кнопки "ОК"
  public void onOK(ActionEvent e) {
    System.out.println("onOK()");
  }

  // обробка події від кнопки "Відміна"
  public void onCancel(ActionEvent e) {
    System.out.println("onCancel()");
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new ForwardingEvents();
          }
        });
  }
}
