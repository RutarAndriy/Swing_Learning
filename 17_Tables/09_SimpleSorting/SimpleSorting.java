// SimpleSorting.java
// Сортування таблиці за замовчуванням
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class SimpleSorting extends JFrame {
  public SimpleSorting() {
    super("SimpleSorting");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо таблицю на основі моделі за замовчуванням
    SortModel sm = new SortModel();
    sm.setColumnCount(4);
    // додаємо сто рядків випадкових чисел
    for ( int i = 0; i < 100; i++ ) {
      sm.addRow(new Integer[] { i,
          (int)(5*Math.random()),
          (int)(5*Math.random()),
          (int)(5*Math.random())} );
    }
    JTable table = new JTable();
    // автоматичне включення сортування
    table.setAutoCreateRowSorter(true);
    // обмеження по кількості стовбців
    ((TableRowSorter)table.getRowSorter()).setMaxSortKeys(2);
    table.setModel(sm);
    add(new JScrollPane(table));
    // виводимо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }
  // модель для демонстрації сортування та фільтрації
  static class SortModel extends DefaultTableModel {
    // тип даних, який зберігається у стовбці
    public Class getColumnClass(int column) {
      return Integer.class;
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleSorting(); } });
  }
}
