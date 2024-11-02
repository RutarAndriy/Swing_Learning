// FormattedFields.java
// Використання полів JFormattedTextField
import javax.swing.*;
import javax.swing.text.*;
import java.text.*;
import java.util.Date;
import java.awt.*;

public class FormattedFields extends JFrame {
  // поля для форматованого вводу даних
  private JFormattedTextField
      phoneField, dateField, numberField;
  public FormattedFields() {
    super("FormattedFields");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // обмежуємо ввід на основі маски
    // телефонний номер
    try {
      MaskFormatter phone =
          new MaskFormatter("+#-###-###-##-##");
      phone.setPlaceholderCharacter('0');
      phoneField = new JFormattedTextField(phone);
      phoneField.setColumns(15);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    // редагування дати
    // формат дати
    DateFormat date =
        new SimpleDateFormat("dd MMMM yyyy, EEEE");
    // налаштування форматуючого об'єкту
    DateFormatter formatter = new DateFormatter(date);
    formatter.setAllowsInvalid(false);
    formatter.setOverwriteMode(true);
    // налаштування текстового поля
    dateField = new JFormattedTextField(formatter);
    dateField.setColumns(15);
    dateField.setValue(new Date());
    // редагування чисел
    // формат числа з експонентою
    NumberFormat number = new DecimalFormat("##0.##E0");
    numberField = new JFormattedTextField(
        new NumberFormatter(number));
    // налаштування поля
    numberField.setColumns(10);
    numberField.setValue(1500);
    // додаємо поля до панелі вмісту
    setLayout(new FlowLayout());
    add(new JLabel("Телефон:"));
    add(phoneField);
    add(new JLabel("Дата:"));
    add(dateField);
    add(new JLabel("Число:"));
    add(numberField);
    // виводимо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new FormattedFields(); } });
  }
}
