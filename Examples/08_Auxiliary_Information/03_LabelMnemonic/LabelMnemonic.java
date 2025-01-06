// LabelMnemonic.java
// Використання написів для виводу мнемонік
import javax.swing.*;
import java.awt.*;

public class LabelMnemonic extends JFrame {
  public LabelMnemonic() {
    super("LabelMnemonic");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // додамо пару текстових полів
    JPanel contents = new JPanel(new GridLayout(2,2));
    JTextField tf = new JTextField(10);
    JLabel label = new JLabel("Ваше ім'я:");
    // налаштування мнемоніки
    label.setLabelFor(tf);
    label.setDisplayedMnemonic('І');
    // додаємо компоненти в таблицю
    contents.add(new JLabel("Ваше прізвище:"));
    contents.add(new JTextField(10));
    contents.add(label);
    contents.add(tf);
    // виводимо вікно на екран
    setContentPane(contents);
    pack();
    setVisible(true);
  }
  public static void main(String args[]) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new LabelMnemonic(); } });
  }
}
