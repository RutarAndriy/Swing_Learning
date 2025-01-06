// TableResizeModes.java
// Режими перерозпреділення простору таблиці
// при зміні розмірів стовбців
import javax.swing.*;
import java.awt.*;

public class TableResizeModes extends JFrame {
  // назви стовбців таблиці
  private String[] columnNames = {
      "Нава", "Смак", "Колір"
  };
  // дані для таблиці
  private String[][] data = {
      { "Апельсин", "Кисло-солодкий", "Оранжевий"},
      { "Лимон", "Кислий", "Жовтий"}
  };
  // масив таблиць
  private JTable[] tables = new JTable[5];
  public TableResizeModes() {
    super("TableResizeModes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // вікно ділимо на 5 комірок
    setLayout(new GridLayout(5, 1));
    // створюємо масив таблиць
    for (int i=0; i<tables.length; i++) {
      tables[i] =
          new JTable(data, columnNames);
      add(new JScrollPane(tables[i]));
    }
    // змінюємо режими розпреділення простору
    tables[1].setAutoResizeMode(
        JTable.AUTO_RESIZE_OFF);
    tables[2].setAutoResizeMode(
        JTable.AUTO_RESIZE_NEXT_COLUMN);
    tables[3].setAutoResizeMode(
        JTable.AUTO_RESIZE_LAST_COLUMN);
    tables[4].setAutoResizeMode(
        JTable.AUTO_RESIZE_ALL_COLUMNS);
    // задаємо вікну оптимальний розмір і
    // виводимо його на екран
    pack();
    setVisible(true);

  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TableResizeModes(); } });
  }
}
