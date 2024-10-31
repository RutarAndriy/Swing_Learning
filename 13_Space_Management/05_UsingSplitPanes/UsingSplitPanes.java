// UsingSplitPanes.java
// Використання розділювальних панелей
import javax.swing.*;
import java.awt.*;

public class UsingSplitPanes extends JFrame {
  // цей значок будемо використовувати в написах
  private Icon icon = new ImageIcon("Image.jpg");
  public UsingSplitPanes() {
    super("UsingSplitPanes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // перша розділювальна панель
    JSplitPane splitMain = new JSplitPane();
    splitMain.setOneTouchExpandable(true);
    // розмір смуги
    splitMain.setDividerSize(20);
    // вертикальна розділювальна панель
    JSplitPane split2 = new JSplitPane(
        JSplitPane.VERTICAL_SPLIT, true);
    // налаштовуємо її компоненти
    split2.setTopComponent(
        new JScrollPane(new JLabel(icon)));
    split2.setBottomComponent(
        new JScrollPane(new JLabel(icon)));
    // налаштуємо компоненти першої панелі
    splitMain.setLeftComponent(
        new JScrollPane(new JLabel(icon)));
    splitMain.setRightComponent(split2);
    // додаємо панель і виводимо вікно на екран
    add(splitMain);
    setSize(600, 400);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingSplitPanes(); } });
  }
}
