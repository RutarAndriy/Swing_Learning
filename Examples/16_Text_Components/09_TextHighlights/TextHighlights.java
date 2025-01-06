// TextHighlights.java
// Додаткове виділення тексту
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class TextHighlights extends JFrame {
  public TextHighlights() {
    super("TextHighlights");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо і налаштовуємо поле
    JTextArea area =
        new JTextArea("Привіт світ!");
    try {
      // додаємо виділений фрагмент фовтого кольору
      Object reference =
          area.getHighlighter().
              addHighlight(0, 6,
                  new DefaultHighlighter.
                      DefaultHighlightPainter(Color.YELLOW));
    } catch (BadLocationException e) {
      e.printStackTrace();
    }
    // додаємо поле у вікно
    add(new JScrollPane(area));
    // виводимо вікно на екран
    setSize(300, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TextHighlights(); } });
  }
}
