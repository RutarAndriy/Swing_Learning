// UsingTableColumnModel.java
// Використання стандартної моделі стовбців таблиці і об'єктів TableColumn
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Enumeration;

public class UsingTableColumnModel extends JFrame {
  // модель стовбців
  private TableColumnModel columnModel;
  // назви стовбців таблиці
  private String[] columnNames = {
      "Ім'я", "Улюблений колір", "Напиток"
  };
  // данные для таблицы
  private String[][] data = {
      { "Іван", "Зелений", "Апельсиновий сік"},
      { "Олександр", "Бежевий", "Зелений чай"}
  };
  public UsingTableColumnModel() {
    super("UsingTableColumnModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // наша таблиця
    JTable table = new JTable(data, columnNames);
    // отримуємо стандартну модель
    columnModel = table.getColumnModel();
    // змінюємо розміри стовбців
    Enumeration e = columnModel.getColumns();
    while ( e.hasMoreElements() ) {
      TableColumn column =
          (TableColumn)e.nextElement();
      column.setMinWidth(30);
      column.setMaxWidth(90);
    }
    // створимо декілька кнопок
    JPanel buttons = new JPanel();
    JButton move = new JButton("Поміняти місцями");
    move.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // міняємо місцями перших два стовбці
        columnModel.moveColumn(0, 1);
      }
    });
    buttons.add(move);
    JButton add = new JButton("Додати");
    add.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // додаємо стовбець
        TableColumn newColumn =
            new TableColumn(1, 100);
        newColumn.setHeaderValue("<html><b>Новий!");
        columnModel.addColumn(newColumn);
      }
    });
    buttons.add(add);
    // виводимо вікно на екран
    add(new JScrollPane(table));
    add(buttons, "South");
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingTableColumnModel(); } });
  }
}
