// RadioButtons.java
// Використання перемикачів
import javax.swing.*;
import java.awt.*;

public class RadioButtons extends JFrame {
  public RadioButtons() {
    super("RadioButtons");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // використовуємо послідовне розміщення
    setLayout(new FlowLayout());
    // окремий перемикач
    JRadioButton r = new JRadioButton("Сам по собі");
    // група зв'язаних перемикачів у своїй
    // власній панелі
    JPanel panel = new JPanel(new GridLayout(0, 1, 0, 5));
    panel.setBorder(
        BorderFactory.createTitledBorder("Зовнішній вигляд"));
    ButtonGroup bg = new ButtonGroup();
    String[] names = { "Зовнішній вигляд Java",
        "MS Windows", "Aqua (Mac)" };
    for (String name : names) {
      JRadioButton radio = new JRadioButton(name);
      panel.add(radio);
      bg.add(radio);
    }
    // додаємо все в контейнер
    add(r);
    add(panel);
    // виводимо вікно на екран
    pack();
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new RadioButtons(); } });
  }
}
