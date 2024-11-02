// UsingTextArea.java
// Використання багатострокових полів
import javax.swing.*;
import java.awt.*;

public class UsingTextArea extends JFrame {
  public UsingTextArea() {
    super("UsingTextArea");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо пару багатострокових полів
    JTextArea area1 = new JTextArea(
        "Багатострокове поле", 5, 10);
    // нестандартний шрифт і табуляція
    area1.setFont(new Font("Dialog", Font.PLAIN, 14));
    area1.setTabSize(10);
    JTextArea area2 = new JTextArea(15, 10);
    // параметри переносу слів
    area2.setLineWrap(true);
    area2.setWrapStyleWord(true);
    // додамо поля у вікно
    setLayout(new FlowLayout());
    add(new JScrollPane(area1));
    add(new JScrollPane(area2));
    // виводимо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingTextArea(); } });
  }
}
