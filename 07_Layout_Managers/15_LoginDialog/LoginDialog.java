// LoginDialog.java
// Етапи створення першокласного
// користувацького інтерфейсу на прикладі
// діалогового вікна входу в систему
import javax.swing.*;
import java.awt.*;
import com.porty.swing.BoxLayoutUtils;
import com.porty.swing.GUITools;

public class LoginDialog extends JDialog {
  public LoginDialog(JFrame parent) {
    super(parent, "Вхід в систему");
    // видалення вікна при закритті
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    // додаємо розміщення у центр вікна
    add(createGUI());
    // задаємо оптимальний розмір
    pack();
    // выводим окно на экран
    setVisible(true);
  }

  // цей метод буде повертати панель із
  // створеним розміщенням
  private JPanel createGUI() {
    // 1. Створюється панель, яка буде містити
    // всі інші елементи та панелі розміщення
    JPanel main =
        BoxLayoutUtils.createVerticalPanel();
    // Щоб інтерфейс відповідав вимогам Java,
    // необхідно відділити його вміст від
    // меж вікна на 12 пікселів.
    // Для цього використовуємо пусту рамку
    main.setBorder(
        BorderFactory.createEmptyBorder(12,12,12,12));
    // 2. Почергово створюються "смуги", на які
    // був розбитий інтерфейс на етапі аналізу
    // а) перше текстове поле і напис до нього
    JPanel name =
        BoxLayoutUtils.createHorizontalPanel();
    JLabel nameLabel = new JLabel("Ім'я:");
    name.add(nameLabel);
    name.add(BoxLayoutUtils.createHorizontalStrut(12));
    JTextField nameField = new JTextField(15);
    name.add(nameField);
    // б) друге текстове поле і напис до нього
    JPanel password =
        BoxLayoutUtils.createHorizontalPanel();
    JLabel passwrdLabel = new JLabel("Пароль:");
    password.add(passwrdLabel);
    password.add(BoxLayoutUtils.createHorizontalStrut(12));
    JTextField passwrdField = new JTextField(15);
    password.add(passwrdField);
    // в) ряд кнопок
    JPanel flow = new JPanel( new FlowLayout(
        FlowLayout.RIGHT, 0, 0) );
    JPanel grid = new JPanel( new GridLayout(
        1,2,5,0) );
    JButton ok = new JButton("OK");
    JButton cancel = new JButton("Відміна");
    grid.add(ok);
    grid.add(cancel);
    flow.add(grid);
    // 3. Проводяться необхідні дії по
    // вирівнюванню компонентів, уточненню їхніх
    // розмірів, задання однакових розмірів
    // а) узгодження вирівнювання
    // вложених панелей
    BoxLayoutUtils.setGroupAlignmentX(
        Component.LEFT_ALIGNMENT,
        name, password, main, flow);
    // б) центральне вирівнювання написів
    // і текстових полів
    BoxLayoutUtils.setGroupAlignmentY(
        Component.CENTER_ALIGNMENT,
        nameField, passwrdField, nameLabel, passwrdLabel);
    // в) одинакові розміри написів до текстових полів
    GUITools.makeSameSize(nameLabel, passwrdLabel);
    // г) ліквідація "безкінечної" висоти текстових полів
    GUITools.fixTextFieldSize(nameField);
    GUITools.fixTextFieldSize(passwrdField);
    // 4. Кінцевий "сбір" смуг в інтерфейс
    main.add(name);
    main.add(BoxLayoutUtils.createVerticalStrut(12));
    main.add(password);
    main.add(BoxLayoutUtils.createVerticalStrut(17));
    main.add(flow);
    // готово
    return main;
  }
  // тестовий метод для перевірки діалогового вікна
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new LoginDialog(new JFrame());
      }
    });
  }
}
