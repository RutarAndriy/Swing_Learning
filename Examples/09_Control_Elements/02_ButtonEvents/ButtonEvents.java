// ButtonEvents.java
// Обробка подій від кноаок JButton
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonEvents extends JFrame {
  private JTextArea info;
  public ButtonEvents() {
    super("ButtonEvents");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // створюємо кнопку і поміщаємо її на північ вікна
    JButton button = new JButton("Нажміть мене!");
    add(button, "North");
    // поле для виводу повідомлень про події
    info = new JTextArea("Поки подій не було\n");
    add(new JScrollPane(info));
    // прив'язуємо до нашої кнопки прослуховувачів подій
    // прослуховувачі описані як внутрішні класи
    button.addActionListener(new ActionL());
    button.addChangeListener(new ChangeL());
    // приєднуємо прослуховувачів прямо на місці
    button.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        info.append("Це ви все одно не побачите");
      }
    });
    // виводимо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }
  class ActionL implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      info.append(
          "Отримано повідомлення про натискання кнопки! Від - "
              + e.getActionCommand() + "\n");
    }
  }
  class ChangeL implements ChangeListener {
    public void stateChanged(ChangeEvent e) {
      info.append(
          "Отримано повідомлення про зміну стану кнопки!\n");
      // це джерело події
      Object src = e.getSource();
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ButtonEvents(); } });
  }
}
