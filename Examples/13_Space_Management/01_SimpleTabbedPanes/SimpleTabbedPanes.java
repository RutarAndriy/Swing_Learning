// SimpleTabbedPanes.java
// Використання панелей із вкладками
import javax.swing.*;
import java.awt.*;

public class SimpleTabbedPanes extends JFrame {
  public SimpleTabbedPanes() {
    super("SimpleTabbedPanes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // перша панель із вкладками
    JTabbedPane tabsOne = new JTabbedPane(
        JTabbedPane.BOTTOM, JTabbedPane.SCROLL_TAB_LAYOUT);
    // додаємо вкладки
    for (int i=1; i<8; i++) {
      JPanel tab = new JPanel();
      tab.add(new JButton("Просто кнопка " + i));
      tabsOne.addTab("Вкладка №: " + i, tab);
    }
    // друга панель із вкладками
    JTabbedPane tabsTwo = new
        JTabbedPane(JTabbedPane.TOP);
    // додаємо вкладки
    for (int i=1; i<8; i++) {
      JPanel tab = new JPanel();
      tab.add(new JButton("Знову кнопка " + i));
      tabsTwo.addTab("<html><i>Вкладка №: " + i,
          new ImageIcon("Icon.gif"),
          tab, "Натисніть " + i + "!");
    }
    // додаємо вкладки до панелі вмісту
    setLayout(new GridLayout());
    add(tabsOne);
    add(tabsTwo);
    // виводимо вікно на екран
    setSize(600, 250);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleTabbedPanes(); } });
  }
}
