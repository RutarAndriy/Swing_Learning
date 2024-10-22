// CascadedMenus.java
// Створення вкладених меню будь-якої складності
import javax.swing.*;
import java.awt.*;

public class CascadedMenus extends JFrame {
  public CascadedMenus() {
    super("CascadedMenus");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // створюємо строку головного меню
    JMenuBar menuBar = new JMenuBar();
    // створюємо випадаюче меню
    JMenu text = new JMenu("Текст");
    // і декілька вкладених меню
    JMenu style = new JMenu("Стиль");
    JMenuItem bold = new JMenuItem("Жирный");
    JMenuItem italic = new JMenuItem("Курсив");
    JMenu font = new JMenu("Шрифт");
    JMenuItem arial = new JMenuItem("Arial");
    JMenuItem times = new JMenuItem("Times");
    font.add(arial);
    font.add(times);
    // розміщуємо все в потрібному порядку
    style.add(bold);
    style.add(italic);
    style.addSeparator();
    style.add(font);
    text.add(style);
    menuBar.add(text);
    // поміщаємо меню у вікно
    setJMenuBar(menuBar);
    // розділювач може бути корисним не тільки в меню
    ((JComponent)getContentPane()).setBorder(
      BorderFactory.createEmptyBorder(0, 5, 0, 0));
    add(new JSeparator(SwingConstants.VERTICAL), "West");
    // виводимо вікно на екран
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new CascadedMenus(); } });
  }
}
