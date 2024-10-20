// ButtonMnemonics.java
// Підтримка кнопками клавіатурних мнемонік
import javax.swing.*;
import java.awt.*;

public class ButtonMnemonics extends JFrame {
  public ButtonMnemonics() {
    super("ButtonMnemonics");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // використовуємо послідовне розміщення
    setLayout(new FlowLayout());
    // створюємо кнопку
    JButton button = new JButton("Нажміть мене!");
    // мнемоніка (український символ)
    button.setMnemonic('Н');
    add(button);
    // ще одна кнопка, тільки напис англійською
    button = new JButton("All Right!");
    button.setMnemonic('L');
    button.setToolTipText("Сміливо натискайте");
    button.setDisplayedMnemonicIndex(2);
    add(button);
    // виводимо вікно на екран
    pack();
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ButtonMnemonics(); } });
  }
}
