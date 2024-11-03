// FilterAndSelection.java
// Налаштування фільтрації таблиці та виділення рядка
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class FilterAndSelection extends JFrame {
  public FilterAndSelection() {
    super("FilterAndSelection");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо таблицю на основі моделі за замовчуванням
    SimpleSorting.SortModel sm = new SimpleSorting.SortModel();
    sm.setColumnCount(4);
    // додаємо 100 рядків випадкових чисел
    for ( int i = 0; i < 100; i++ ) {
      sm.addRow(new Integer[] { i,
          (int)(5*Math.random()),
          (int)(5*Math.random()),
          (int)(5*Math.random())} );
    }
    final JTable table = new JTable(sm);
    // автоматичне включення сортування
    table.setAutoCreateRowSorter(true);
    // приєднюємо фільтруючий об'єкт
    ((TableRowSorter)table.getRowSorter()).
        setRowFilter(new RowFilter() {
          public boolean include(Entry entry) {
            // вмикаємо лише парні рядки
            return ((Integer)entry.getValue(0)) % 2 == 0;
          }
        });
    add(new JScrollPane(table));
    // поле для відображення номерів вибраних рядків
    final JTextArea out = new JTextArea(4, 10);
    add(new JScrollPane(out), "South");
    // слідкуємо за виділенням у таблиці
    table.getSelectionModel().addListSelectionListener(
        new ListSelectionListener() {
          public void valueChanged(ListSelectionEvent e) {
            if ( table.getSelectedRow() != -1) {
              out.append("Рядок:" + table.getSelectedRow() + "\n");
              out.append("Стовбець:" + table.getSelectedColumn() + "\n");
              out.append("Рядок моделі:" +
                  table.convertRowIndexToModel(
                      table.getSelectedRow()) + "\n");
            }
          }
        });
    // виводимо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new FilterAndSelection(); } });
  }
}
