// ContentPaneAdd.java
// Заміна панелі вмісту
import javax.swing.*;
import java.awt.*;

public class ContentPaneAdd extends JFrame {
  public ContentPaneAdd() {
    super("ContentPaneAdd");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створимо панель із двома кнопками
    JPanel contents = new JPanel();
    contents.add(new JButton("Один"));
    contents.add(new JButton("Два"));
    // замінимо панель вмісту
    setContentPane(contents);
    // виведемо вікно на екран
    setSize(200, 100);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ContentPaneAdd(); } });
  }
}
