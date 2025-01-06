// InputDialogs.java
// Стандартні діалогові вікна JOptionPane для вводу даних
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class InputDialogs extends JFrame {
  // значок для одного із повідомлень
  private ImageIcon icon = new ImageIcon("Question.gif");
  // дані для вибору
  private String[] values = {"Білий","Червоний","Зелений" };
  public InputDialogs() {
    super("InputDialogs");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // після клацання нпо кнопках виводяться повідомлення
    JButton input1 = new JButton("2 і 3 параметри");
    input1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // ввід строки у текстове поле
        String res = JOptionPane.showInputDialog(
            InputDialogs.this,
            "<html><h2>Чи світить сонце?");
        res = JOptionPane.showInputDialog(
            InputDialogs.this,
            "Ваша відповідь була такою:", res);
      }
    });
    JButton input2 = new JButton("4 параметри");
    input2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // дозволяє задавати тип і заголовок
        String res = JOptionPane.showInputDialog(
            InputDialogs.this, new String[] {
            "Пароль введено неправильно!", "Повторіть ввід:"},
            "Пароль", JOptionPane.WARNING_MESSAGE);
      }
    });
    JButton input3 = new JButton("7 параметрів");
    input3.addActionListener(new ActionListener() {
      // вибір із декількох альтернатив
      public void actionPerformed(ActionEvent e) {
        Object res = JOptionPane.showInputDialog(
            InputDialogs.this,"Виберіть улюблений колір:",
            "Вибір кольору", JOptionPane.QUESTION_MESSAGE,
            icon, values, values[0]);
        JOptionPane.showMessageDialog(
            InputDialogs.this, res);
      }
    });
    // додаємо кнопки у вікно
    setLayout(new FlowLayout());
    add(input1);
    add(input2);
    add(input3);
    setSize(400, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new InputDialogs(); } });
  }
}
