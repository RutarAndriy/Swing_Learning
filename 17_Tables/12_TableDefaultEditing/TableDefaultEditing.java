// TableDefaultEditing.java
// Застосування стандартного редактора для таблиць
import javax.swing.*;
import java.awt.*;

public class TableDefaultEditing extends JFrame {
  // назви стовбців
  private String[] columns = {
      "Ім'я", "Улюблений колір" };
  // дані для таблиці
  private String[][] data = {
      { "Іван", "Зелений" },
      { "Олександр", "Червоний"},
      { "Петро", "Синій"}
  };
  public TableDefaultEditing() {
    super("TableDefaultEditing");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо таблицю
    JTable table = new JTable(data, columns);
    // налаштовуємо стандартний редактор
    JComboBox combo = new JComboBox(
        new String[] { "Зелений", "Жовтий", "Білий"});
    DefaultCellEditor editor =
        new DefaultCellEditor(combo);
    table.getColumnModel().getColumn(1).
        setCellEditor(editor);
    // виводимо вікно на екран
    add(new JScrollPane(table));
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TableDefaultEditing(); } });
  }
}
