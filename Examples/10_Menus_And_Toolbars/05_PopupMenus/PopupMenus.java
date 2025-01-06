// PopupMenus.java
// Робота зі спливаючими меню
import javax.swing.*;
import java.awt.*;

public class PopupMenus extends JFrame {
  public PopupMenus() {
    super("PopupMenus");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // отримуємо спливаюче меню
    JPopupMenu popup = createPopupMenu();
    // і прив'язуємо до нашої панелі вмісту
    ((JComponent)getContentPane()).
        setComponentPopupMenu(popup);
    // "прозора" для меню кнопка
    JButton button = new JButton("Проба пера");
    button.setInheritsPopupMenu(true);
    add(button, "South");
    // виводимо вікно на екран
    setSize(300, 200);
    setVisible(true);
  }
  // створюємо наше спливаюче меню
  private JPopupMenu createPopupMenu() {
    // створюємо саме спливаюче меню
    JPopupMenu pm = new JPopupMenu();
    // створюємо його пункти
    JMenuItem good = new JMenuItem("Добре");
    JMenuItem excellent = new JMenuItem("Чудово");
    // і додаємо все тим же методом add()
    pm.add(good);
    pm.add(excellent);
    return pm;
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new PopupMenus(); } });
  }
}
