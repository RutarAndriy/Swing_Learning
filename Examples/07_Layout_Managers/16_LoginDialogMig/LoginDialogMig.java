// LoginDialogMig.java
// Діалог входу в систему з допомогою MigLayout
// java -cp miglayout-3.7-swing-java14.jar LoginDialogMig.java
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class LoginDialogMig extends JDialog {
  public LoginDialogMig(JFrame parent) {
    super(parent, "Вхід в систему");
    // видалення вікна при закритті
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    // додаємо розміщення у центр вікна
    add(createGUI());
    // задаємо оптимальний розмір
    pack();
    // виводимо вікно на екран
    setVisible(true);
  }

  // цей метод буде повертати панель із
  // створеним розташуванням
  private JPanel createGUI() {
    // 1. Головна панель
    // В конструкторі задаємо "ріст" другого стовбця
    JPanel main = new JPanel(new MigLayout("", "[][grow]"));
    // перший ряд сітки
    main.add(new JLabel("Ім'я:"));
    main.add(new JTextField(15), "gap rel, wrap rel, growx");
    // другий ряд сітки
    main.add(new JLabel("Пароль:"));
    main.add(new JTextField(15), "gap rel, wrap unrel, growx");
    // третій ряд сітки - кнопки одинакового розміру
    // пропускаємо першу клітинку, розбиваємо другу на дві
    main.add(new JButton("OK"), "skip 1, split, sg buttons, align right");
    main.add(new JButton("Отмена"), "sg buttons");
    // готово
    return main;
  }
  // тестовий метод для перевірки діалогового вікна
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new LoginDialogMig(new JFrame());
      }
    });
  }
}
