// TableSelection.java
// Режими виділення комірок таблиці
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class TableSelection extends JFrame {
  // назви стовбців таблиці
  private String[] columnNames = {
      "Назва", "Смак", "Колір"
  };
  // дані для таблиці
  private String[][] data = {
      { "Апельсин", "Кисло-солодкий", "Оранжевий"},
      { "Кавун", "Солодкий", "Темно-зелений"},
      { "Лимон", "Кислий", "Жовтий"}
  };
  public TableSelection() {
    super("TableSelection");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо пару таблицт із одинаковими даними
    // перша таблиця - виділення по рядках
    JTable table1 = new JTable(data, columnNames);
    table1.getSelectionModel().setSelectionMode(
        ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    // друга таблиця - виділення по стовбцях
    JTable table2 = new JTable(data, columnNames);
    table2.setRowSelectionAllowed(false);
    TableColumnModel cm = table2.getColumnModel();
    cm.setColumnSelectionAllowed(true);
    cm.getSelectionModel().setSelectionMode(
        ListSelectionModel.SINGLE_SELECTION);
    // додаємо таблиці та виводимо вікно на екран
    setLayout(new GridLayout(1, 2));
    add(new JScrollPane(table1));
    add(new JScrollPane(table2));
    pack();
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TableSelection(); } });
  }
}
