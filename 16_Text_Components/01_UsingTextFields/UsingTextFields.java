// UsingTextFields.java
// Використання текстових полів Swing
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UsingTextFields extends JFrame {
  // наші поля
  private JTextField smallField, bigField;
  public UsingTextFields() {
    super("UsingTextFields");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо текстові поля
    smallField = new JTextField(10);
    bigField = new JTextField("Текст поля", 25);
    // додаткові налаштування
    bigField.setFont(new Font("Verdana", Font.PLAIN, 16));
    bigField.setHorizontalAlignment(JTextField.RIGHT);
    // прослуховувач завершення вводу
    smallField.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // відображаємо введений текст
        JOptionPane.showMessageDialog(
            UsingTextFields.this,
            "Ваше слово: " +
                smallField.getText());
      }
    });
    // поле з паролем
    JPasswordField password = new JPasswordField(15);
    password.setEchoChar('$');
    // додаємо поля у вікно і виводимо його на екран
    setLayout(new FlowLayout());
    add(smallField);
    add(bigField);
    add(password);
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingTextFields(); } });
  }
}
