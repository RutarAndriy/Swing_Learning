// GoodMenu.java
// Клавіатурні комбінації та мнемоніки для меню Swing
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GoodMenu extends JFrame {
  public GoodMenu() {
    super("GoodMenu");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // створюємо строку головного меню
    JMenuBar menuBar = new JMenuBar();
    // деякі випааючі меню, які доволі
    // часто зустрічаються
    menuBar.add(createFileMenu());
    menuBar.add(createEditMenu());
    // помістимо меню в наше вікно
    setJMenuBar(menuBar);
    // виводимо вікно на екран
    setSize(300, 200);
    setVisible(true);
  }
  // створює меню "Файл"
  private JMenu createFileMenu() {
    // випадаюче меню
    JMenu file = new JMenu("Файл");
    file.setMnemonic('Ф');
    // пункт меню "Відкрити"
    JMenuItem open = new JMenuItem("Відкрити");
    open.setMnemonic('В'); // українська літера
    // встановимо клавішу швидкого доступу (латинська літера)
    open.setAccelerator(
      KeyStroke.getKeyStroke('O', KeyEvent.CTRL_MASK));
    // пункт меню "Зберегти"
    JMenuItem save = new JMenuItem("Зберегти");
    save.setMnemonic('З');
    save.setAccelerator(
      KeyStroke.getKeyStroke('S', KeyEvent.CTRL_MASK));
    // додамо все в меню
    file.add(open);
    file.add(save);
    return file;
  }
  // створює меню "Правка"
  private JMenu createEditMenu() {
    // випадаюче меню
    JMenu edit = new JMenu("Правка");
    edit.setMnemonic('П');
    // пункт меню "Вирізати"
    JMenuItem cut = new JMenuItem("Вирізати");
    cut.setMnemonic('В');
    cut.setAccelerator(
      KeyStroke.getKeyStroke('X', KeyEvent.CTRL_MASK));
    // пункт меню "Копіювати"
    JMenuItem copy = new JMenuItem("Копіювати");
    copy.setMnemonic('К');
    // клавішу швидкого доступу можна створити і так
    copy.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
    // готово
    edit.add(cut);
    edit.add(copy);
    return edit;
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new GoodMenu(); } });
  }
}
