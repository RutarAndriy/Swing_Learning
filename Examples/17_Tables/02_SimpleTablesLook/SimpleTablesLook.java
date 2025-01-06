// SimpleTablesLook.java
// Невеликі зміни зовнішнього вигляду таблиць
import javax.swing.*;
import java.awt.*;

public class SimpleTablesLook extends JFrame {
  // дані та заголовки для таблиць
  private Object[][] data = new String[][] {
      { "Потужна", "Синій", "Спортивний" },
      { "Економічна", "Червоний", "Класичний" }
  };
  private Object[] columns = new String[] {
      "Модель", "Колір", "Дизайн"
  };
  public SimpleTablesLook() {
    super("SimpleTablesLook");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // таблиця із різними віддалями між комірками
    JTable table1 = new JTable(data, columns);
    // налаштування віддалей та кольорів
    table1.setRowHeight(40);
    table1.setIntercellSpacing(new Dimension(10, 10));
    table1.setGridColor(Color.green);
    table1.setShowVerticalLines(false);
    // таблиця з різними кольорами
    JTable table2 = new JTable(data, columns);
    table2.setForeground(Color.red);
    table2.setSelectionForeground(Color.yellow);
    table2.setSelectionBackground(Color.blue);
    table2.setShowGrid(false);
    // додаємо таблиці в панель із двох комірок
    setLayout(new GridLayout(1, 2, 5, 5));
    add(new JScrollPane(table1));
    add(new JScrollPane(table2));
    // виводимо вікно на екран
    setSize(600, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleTablesLook(); } });
  }
}
