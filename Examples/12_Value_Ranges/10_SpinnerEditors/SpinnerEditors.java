// SpinnerEditors.java
// Стандартні редактори лічильників
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class SpinnerEditors extends JFrame {
  // дані для першого лічильника
  private String[] data = {
      "Перший", "Другий", "Останній"
  };
  public SpinnerEditors() {
    super("SpinnerEditors");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // лічильник на основі масиву
    JSpinner spinner1 = new JSpinner(
        new SpinnerListModel(data));
    // налаштовуємо редактор
    ((JSpinner.ListEditor)spinner1.getEditor()).
        getTextField().setColumns(15);
    // вибір дат
    SpinnerDateModel dates = new SpinnerDateModel(
        new Date(), null, null, Calendar.DAY_OF_MONTH);
    JSpinner spinner2 = new JSpinner(dates);
    // налаштовуємо редактор
    ((JSpinner.DateEditor)spinner2.getEditor()).
        getTextField().setEditable(false);
    // додаємо лічильники до панелі вмісту
    setLayout(new FlowLayout());
    add(spinner1);
    add(spinner2);
    // виводимо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SpinnerEditors(); } });
  }
}
