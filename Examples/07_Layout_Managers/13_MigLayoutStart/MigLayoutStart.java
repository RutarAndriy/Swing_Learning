// MigLayoutStart.java
// Знайомство з MigLayout
// java -cp miglayout-3.7-swing-java14.jar MigLayoutStart.java
import net.miginfocom.swing.MigLayout;
import javax.swing.*;

public class MigLayoutStart extends JFrame {
  public MigLayoutStart() {
    super("MigLayoutStart");
    // вихід при закриванні вікна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // встановлюємо менеджер розміщення
    setLayout(new MigLayout());
    // додаємо компоненти з описом клітинок
    add(new JLabel("Ім'я:"), "gap, sg 1");
    add(new JTextField(10), "wrap");
    add(new JLabel("Прізвище:"), "gap, sg 1");
    add(new JTextField(10), "wrap");
    // виводимо вікно на екран
    pack();
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new MigLayoutStart(); } });
  }
}
