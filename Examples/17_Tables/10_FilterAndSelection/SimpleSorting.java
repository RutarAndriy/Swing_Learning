// SimpleSorting.java
// Сортування таблиці за замовчуванням
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SimpleSorting {
  // модель для демонстрації сортування та фільтрації
  static class SortModel extends DefaultTableModel {
    // тип даних, який зберігається у стовбці
    public Class getColumnClass(int column) {
      return Integer.class;
    }
  }
}
