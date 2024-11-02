// StyledText.java
// Багаті можливості редактора JTextPane
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class StyledText extends JFrame {
  public StyledText() {
    super("StyledText");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо редактор
    JTextPane textPane = new JTextPane();
    // створення документа і стилів
    createDocument(textPane);
    // додамо редактор у вікно
    add(new JScrollPane(textPane));
    // виводимо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }
  private void createDocument(JTextPane tp) {
    // налаштування стилів
    // стиль основного тексту
    Style normal = tp.addStyle("Normal", null);
    StyleConstants.setFontFamily(normal, "Verdana");
    StyleConstants.setFontSize(normal, 13);
    // заголовок
    Style heading = tp.addStyle("Heading", normal);
    StyleConstants.setFontSize(heading, 20);
    StyleConstants.setBold(heading, true);
    // наповнюємо документ вмістом, використовуючи стилі
    insertString("Нехитрий Заголовок", tp, heading);
    insertString("Далі йде звичайний вміст,", tp, normal);
    insertString("помічений стилем Normal.", tp, normal);
    insertString("Ще Один Заголовок", tp, heading);
    // змінюємо випадкову частину тексту
    SimpleAttributeSet red = new SimpleAttributeSet();
    StyleConstants.setForeground(red, Color.red);
    StyledDocument doc = tp.getStyledDocument();
    doc.setCharacterAttributes(5, 5, red, false);
    // додамо компонент в кінець тексту
    tp.setCaretPosition(doc.getLength());
    JCheckBox check = new JCheckBox("Все можливо!");
    check.setOpaque(false);
    tp.insertComponent(check);
  }
  // вставляємо строку в кінець документу з переносом,
  // використовуючи заданий стиль оформлення
  private void insertString(String s, JTextPane tp, Style style) {
    try {
      Document doc = tp.getDocument();
      doc.insertString(doc.getLength(), s + "\n", style);
    } catch (BadLocationException ex) {
      ex.printStackTrace();
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new StyledText(); } });
  }
}
