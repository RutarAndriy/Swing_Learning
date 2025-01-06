// CustomTableEditor.java
// Застосування спеціального редактора для комірок таблиці
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.*;
import com.porty.swing.*;

public class CustomTableEditor extends JFrame {
  // заголовки стовбців таблиці
  private String[] columns = {
      "Операція", "Дата" };
  // дані таблиці
  private Object[][] data = {
      { "Купівля", new Date() },
      { "Продаж", new Date() }
  };
  public CustomTableEditor() {
    super("CustomTableEditor");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо таблицю на основі стандартної моделі
    DefaultTableModel model =
        new DefaultTableModel(data, columns) {
          // необхідно вказати тип стовбця
          public Class getColumnClass(int column) {
            return data[0][column].getClass();
          }
        };
    JTable table = new JTable(model);
    table.setRowHeight(20);
    // вказуємо редактор для дат
    table.setDefaultEditor(
        Date.class, new DateCellEditor());
    // виводимо вікно на екран
    getContentPane().add(new JScrollPane(table));
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new CustomTableEditor(); } });
  }
}
