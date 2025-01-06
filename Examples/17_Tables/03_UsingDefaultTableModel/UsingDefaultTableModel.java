// UsingDefaultTableModel.java
// Використання стандартної моделі при створенні таблиці
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;

public class UsingDefaultTableModel extends JFrame {
  // наша модель
  private DefaultTableModel dtm;
  public UsingDefaultTableModel() {
    super("UsingDefaultTableModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо стандартну модель
    dtm = new DefaultTableModel();
    // задаємо назви стовбців
    dtm.setColumnIdentifiers(
        new String[] {"Номер", "Товар", "Ціна"});
    // наповнюємо модель даними
    dtm.addRow(new String[] {"№1", "Блокнот", "5.5"});
    dtm.addRow(new String[] {"№2", "Телефон", "175"});
    dtm.addRow(new String[] {"№3", "Олівець", "1.2"});
    // передаємо модель у таблицю
    JTable table = new JTable(dtm);
    // дані можуть змінюватися динамічно
    JButton add = new JButton("Додати");
    add.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // додаємо нові дані
        dtm.addRow(
            new String[] {"?", "Новинка!", "Супер Ціна!"});
      }
    });
    JButton remove = new JButton("Видалити");
    remove.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // видаляємо останній рядок (відлік з нуля)
        dtm.removeRow(dtm.getRowCount() - 1);
      }
    });
    // додаємо кнопки і таблицю
    add(new JScrollPane(table));
    JPanel buttons = new JPanel();
    buttons.add(add);
    buttons.add(remove);
    add(buttons, "South");
    // виводимо вікно на екран
    setSize(300, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingDefaultTableModel(); } });
  }
}
