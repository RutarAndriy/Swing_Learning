// ToggleButtons.java
// Використання вимикачів JToggleButton
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToggleButtons extends JFrame {
  public ToggleButtons() {
    super("ToggleButtons");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // використовуємо послідовне розміщення
    setLayout(new FlowLayout());
    // створюємо пару кнопок JToggleButton
    button1 = new JToggleButton("Перша", true);
    button2 = new JToggleButton("Друга", false);
    // добавимо прослуховувач подій про зміну стану
    button2.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        button1.setSelected(
            ! button2.isSelected());
      }
    });
    add(button1);
    add(button2);
    // виводимо вікна на екран
    pack();
    setVisible(true);
  }
  // посилання на використовувані кнопки
  private JToggleButton button1, button2;
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ToggleButtons(); } });
  }
}
