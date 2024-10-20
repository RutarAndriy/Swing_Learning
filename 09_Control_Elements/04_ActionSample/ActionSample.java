// ActionSample.java
// Використання архітектури Action
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionSample extends JFrame {
  public ActionSample() {
    super("ActionSample");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // використовуємо послідовне розміщення
    setLayout(new FlowLayout());
    // створимо пару кнопок, виконуючих
    // одну дію
    Action action = new SimpleAction();
    JButton button1 = new JButton(action);
    JButton button2 = new JButton(action);
    add(button1);
    add(button2);
    // виводимо вікно на екран
    setSize(300, 100);
    setVisible(true);
  }
  // цей внутрішній клас інкапсулює нашу команду
  class SimpleAction extends AbstractAction {
    SimpleAction() {
      // встановлюємо параметри команди
      putValue(NAME, "Привіт, Action!");
      putValue(SHORT_DESCRIPTION, "Це підказка");
      putValue(MNEMONIC_KEY, new Integer('A'));
    }
    // у цьому методі обробляється подія, як
    // і в попередньому методі ActionListener
    public void actionPerformed(ActionEvent e) {
      // можна вимкнути команду, не знаючи, до
      // яких компонентів вона приєднана
      setEnabled(false);
      // змінюємо напис
      putValue(NAME, "Бувай, Action!");
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ActionSample(); } });
  }
}
