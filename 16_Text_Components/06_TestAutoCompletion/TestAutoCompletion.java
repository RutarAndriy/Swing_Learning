// TestAutoCompletion.java
// Перевірка роботи текстового поля з
// автоматичним доповненням
import com.porty.swing.*;
import javax.swing.*;
import java.awt.*;

public class TestAutoCompletion extends JFrame {
  public TestAutoCompletion() {
    super("TestAutoCompletion");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо і налаштовуємо поле
    JTextField field =
        new JTextField();
    field.setColumns(15);
    // слова для автодоповнення
    AutoCompleteTextDocument doc =
        new AutoCompleteTextDocument(field);
    doc.addWord("прекрасний");
    doc.addWord("чудовий");
    // додаємо поле у вікно
    setLayout(new FlowLayout());
    add(field);
    // виводимо вікно на екран
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TestAutoCompletion(); } });
  }
}
