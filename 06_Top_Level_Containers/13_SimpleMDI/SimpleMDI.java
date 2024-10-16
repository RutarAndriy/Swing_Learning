// SimpleMDI.java
// Демонстрація внутрішніх вікон Swing
import javax.swing.*;

public class SimpleMDI extends JFrame {
  public SimpleMDI() {
    super("SimpleMDI");
    setSize(400, 300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо робочий стіл Swing
    JDesktopPane desktopPane = new JDesktopPane();
    // додаємо його в центр вікна
    add(desktopPane);
    // створюємо декілька внутрішніх вікон
    JInternalFrame frame1 =
        new JInternalFrame("Вікно 1", true);
    JInternalFrame frame2 =
        new JInternalFrame("Вікно 2", true, true, true, true);
    JInternalFrame frame3 =
        new JInternalFrame("Палітра", false, true);
    // зміна типу вікна на "палітру"
    frame3.putClientProperty("JInternalFrame.isPalette", true);
    // додаємо внутрішні вікна на робочий стіл
    desktopPane.add(frame1);
    desktopPane.add(frame2);
    desktopPane.add(frame3);
    // задаємо розміри та місцезнаходження, робимо вікна видимими
    frame1.setSize(200, 100);
    frame1.setLocation(80, 100); frame1.setVisible(true);
    frame2.setSize(200, 60); frame2.setVisible(true);
    frame3.setSize(100, 200); frame3.setVisible(true);
    // виводимо вікно на екран
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleMDI(); } });
  }
}
