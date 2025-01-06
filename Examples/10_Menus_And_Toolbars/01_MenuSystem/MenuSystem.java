// MenuSystem.java
// Створення системи меню в Swing
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;

public class MenuSystem extends JFrame {
  public MenuSystem() {
    super("MenuSystem");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // створюємо строку головного меню
    JMenuBar menuBar = new JMenuBar();
    // додаємо в неї випадаючі меню
    menuBar.add(createFileMenu());
    menuBar.add(createWhoMenu());
    // і встановлюємо її в якості
    // меню нашого вікна
    setJMenuBar(menuBar);
    // виводимо вікно на екран
    setSize(300, 200);
    setVisible(true);
  }
  // створює меню "Файл"
  private JMenu createFileMenu() {
    // створимо випадаюче меню, яке буде
    // містити звичайні пункти меню
    JMenu file = new JMenu("Файл");
    // пункт меню (зі значком)
    JMenuItem open =
        new JMenuItem("Відкрити",
            new ImageIcon("images/Open16.gif"));
    // пункт меню із команди
    JMenuItem exit = new JMenuItem(new ExitAction());
    // додамо все в меню
    file.add(open);
    // роздлювач
    file.addSeparator();
    file.add(exit);
    return file;
  }
  // створимо кумедне меню
  private JMenu createWhoMenu() {
    // створимо випадаюче меню
    JMenu who = new JMenu("Хто ВИ ?");
    // меню-флажки
    JCheckBoxMenuItem clever =
        new JCheckBoxMenuItem("Розумний");
    JCheckBoxMenuItem smart =
        new JCheckBoxMenuItem("Красивий");
    JCheckBoxMenuItem tender =
        new JCheckBoxMenuItem("Ніжний");
    // меню-перемикачі
    JRadioButtonMenuItem male =
        new JRadioButtonMenuItem("Чоловік");
    JRadioButtonMenuItem female =
        new JRadioButtonMenuItem("Жінка");
    // організуємо перимикачі в логічну групу
    ButtonGroup bg = new ButtonGroup();
    bg.add(male); bg.add(female);
    // додамо все в меню
    who.add(clever);
    who.add(smart);
    who.add(tender);
    // розділювач можна створити явно
    who.add( new JSeparator());
    who.add(male);
    who.add(female);
    return who;
  }
  // команда виходу з програми
  class ExitAction extends AbstractAction {
    ExitAction() {
      putValue(NAME, "Вихід");
    }
    public void actionPerformed(ActionEvent e) {
      System.exit(0);
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new MenuSystem(); } });
  }
}
