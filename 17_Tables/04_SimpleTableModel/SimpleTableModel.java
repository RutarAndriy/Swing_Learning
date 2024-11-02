// SimpleTableModel.java
// Створення простої моделі для таблиці
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class SimpleTableModel extends JFrame {
  public SimpleTableModel() {
    super("SimpleTableModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо таблицю на основі нашої моделі
    JTable table = new JTable(new SimpleModel());
    table.setRowHeight(32);
    add(new JScrollPane(table));
    // виводимо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }
  // наша модель
  class SimpleModel extends AbstractTableModel {
    // кількість рядків
    public int getRowCount() {
      return 100000;
    }
    // кількість стовбців
    public int getColumnCount() {
      return 3;
    }
    // тип даних, який зберігається у стовбці
    public Class getColumnClass(int column) {
      switch (column) {
        case 1: return Boolean.class;
        case 2: return Icon.class;
        default: return Object.class;
      }
    }
    // дані в комірці
    public Object getValueAt(int row, int column) {
      boolean isEven = (row % 2 == 0);
      // різні дані для різних стовбців
      switch (column) {
        case 0: return "" + row;
        case 1: return isEven;
        case 2: return new ImageIcon("Table.gif");
      }
      return "Пусто";
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleTableModel(); } });

  }
}
