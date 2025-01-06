// InnerClassEvents.java
// Внутрішні класи для обробки подій

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InnerClassEvents extends JFrame {
  private JTextField text;
  private JButton button;

  public InnerClassEvents() {
    super("InnerClassEvents");
    // при закритті вікна - вихід
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // послідовне розміщення
    setLayout(new FlowLayout());
    // додаємо текстове поле
    add(text = new JTextField(10));
    // і кнопку
    add(button = new JButton("Натисніть"));
    // будемо слідкувати за натисканням кнопки
    button.addActionListener(new ButtonL());
    // виводимо вікно на екран
    pack();
    setVisible(true);
  }

  // клас-прослуховувач натискання на кнопку
  class ButtonL implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      System.out.println(text.getText());
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new InnerClassEvents();
          }
        });
  }
}
