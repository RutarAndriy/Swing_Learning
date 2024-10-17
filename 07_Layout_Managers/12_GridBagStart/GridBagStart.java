// GridBagStart.java
// Перші досліди із розміщенням GridBagLayout
import java.awt.*;
import javax.swing.*;

public class GridBagStart extends JFrame {
  public GridBagStart() {
    super("GridBagStart");
    // вихід при закриванні вікна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // встановлюємо розміщення компонентів
    setLayout(new GridBagLayout());
    // додаємо дві кнопки, клітинки за замовчуванням
    add(new JButton("Привіт"));
    add(new JButton("Відміна"));
    // налаштування клітинки для текстового поля
    GridBagConstraints textFieldConstraints =
        new GridBagConstraints();
    // заповнення клітинки по горизонталі
    textFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
    // просимо зайняти всі вільні клітинки
    textFieldConstraints.gridwidth =
        GridBagConstraints.REMAINDER;
    textFieldConstraints.weightx = 1.0f;
    add(new JTextField(10), textFieldConstraints);
    // виводимо вікно на екран
    setSize(400, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new GridBagStart(); } });
  }
}
