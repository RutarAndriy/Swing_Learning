// MessageDialogs.java
// Методи JOptionPane для відображення повідомлень
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MessageDialogs extends JFrame {
  // цей значок відобразимо в одному із повідомлень
  private ImageIcon icon = new ImageIcon("Question.gif");
  public MessageDialogs() {
    super("MessageDialogs");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // кнопки, після клацання по яких
    // відображаються повідомлення
    JButton message1 = new JButton("2 параметри");
    message1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(
            MessageDialogs.this,
            "<html><h2>Привіт!<br>HTML є і тут!");
      }
    });
    JButton message2 = new JButton("4 параметри");
    message2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(
            MessageDialogs.this,new String[] {
            "Повідомлення може бути",
            "записане масивом!" }, "Свій заголовок",
            JOptionPane.ERROR_MESSAGE);
      }
    });
    JButton message3 = new JButton("5 параметрів");
    message3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(
            MessageDialogs.this,
            "Налаштовано все що тільки можна", "Свій заголовок",
            JOptionPane.INFORMATION_MESSAGE, icon);
      }
    });
    // виведемо вікно на екран
    setLayout(new FlowLayout());
    add(message1);
    add(message2);
    add(message3);
    setSize(400, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new MessageDialogs(); } });
  }
}
