// ControllingCaret.java
// Управління текстовий курсором
import javax.swing.*;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.text.*;
import java.awt.*;

public class ControllingCaret extends JFrame {
  public ControllingCaret() {
    super("ControllingCaret");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // багаторядкове текстове поле
    final JTextArea textArea = new JTextArea();
    // додамо текст
    textArea.append("Просто який-небуть текст");
    // налаштування курсору і виділення тексту
    Caret caret = textArea.getCaret();
    caret.setBlinkRate(50);
    caret.setDot(5);
    caret.moveDot(10);
    // додамо текстове поле у вікно
    add(new JScrollPane(textArea));
    // напис для слова біля курсору
    final JLabel label = new JLabel();
    add(label, "South");
    // прослуховувач переміщень курсору
    textArea.addCaretListener(new CaretListener() {
      public void caretUpdate(CaretEvent e) {
        // виведемо слово біля курсору
        try {
          // початок і кінець слова на позиції
          int wordStart =
              Utilities.getWordStart(textArea, e.getDot());
          int wordEnd =
              Utilities.getWordEnd(textArea, e.getDot());
          label.setText(textArea.getText(
              wordStart, wordEnd - wordStart));
        } catch (BadLocationException ex) {
          ex.printStackTrace();
        }
      }
    });
    // виводимо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ControllingCaret(); } });
  }
}
