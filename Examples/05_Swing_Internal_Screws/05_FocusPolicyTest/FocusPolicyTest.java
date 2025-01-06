// FocusPolicyTest.java
// Різноманітні алгорипми передавання фокусу вводу
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FocusPolicyTest extends JFrame {
  public FocusPolicyTest() {
    super("FocusPolicyTest");
    // при закриванні вікна - вихід
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // додаємо три кнопки
    add(new JButton("Ліва"), "West");
    // додаємо цю кнопку другою, але вона буде нижче
    // двох інших кнопок
    JButton button = new JButton("Змінити");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // при натисканні змінюємо алгоритм для вікна
        setFocusTraversalPolicy(
            new ContainerOrderFocusTraversalPolicy());
      }
    });
    add(button, "South");
    add(new JButton("Права"), "East");
    // виводимо вікно на екран
    setSize(200, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new FocusPolicyTest(); } });
  }
}
