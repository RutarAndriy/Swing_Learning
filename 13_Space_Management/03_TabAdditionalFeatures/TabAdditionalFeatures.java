// TabAdditionalFeatures.java
// Додаткові можливості панелі із вкладками
import javax.swing.*;
import java.awt.*;

public class TabAdditionalFeatures extends JFrame {
  public TabAdditionalFeatures() {
    super("TabAdditionalFeatures");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // панель із вкладками
    JTabbedPane tabs = new JTabbedPane();
    tabs.addTab("Перша вкладка", new JPanel());
    tabs.addTab("Друга вкладка (S)", new JPanel());
    tabs.addTab("Цікава вкладка", new JPanel());
    // задаємо мнемоніки
    tabs.setMnemonicAt(0, 'П');
    tabs.setMnemonicAt(1, 'S');
    tabs.setMnemonicAt(2, 'Ц');
    // активуємо останню вкладку
    tabs.setEnabledAt(2, false);
    // виводимо вікно на екран
    add(tabs);
    setSize(430, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TabAdditionalFeatures(); } });
  }
}
