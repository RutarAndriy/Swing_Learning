// SimpleTables.java
// Прості таблиці з допомогою зручних конструкторів
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class SimpleTables extends JFrame {
  // дані для таблиць
  private Object[][] colors = new String[][] {
      { "Червоний", "Зелений", "Синій" },
      { "Жовтий", "Оранжевий", "Білий" },
  };
  // назви заголовків стовбців
  private Object[] colorsHeader = new String[] {
      "Колір", "Ще колір", "Також колір"
  };
  public SimpleTables() {
    super("SimpleTables");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // декілька простих таблиць
    JTable table1 = new JTable(colors, colorsHeader);
    JTable table2 = new JTable(5, 5);
    // таблиця на основі вектору, який складається із векторів
    Vector<Vector<String>> data =
        new Vector<Vector<String>>();
    Vector<String> row1 = new Vector<String>();
    Vector<String> row2 = new Vector<String>();
    // вектор із заголовками стовбців
    Vector<String> columnNames = new Vector<String>();
    // наповнення даними
    for (int i=0; i<3; i++) {
      row1.add("Комірка 1." + i);
      row2.add("Комірка 2." + i);
      columnNames.add("Стовбиць #" + i);
    }
    data.add(row1);
    data.add(row2);
    JTable table3 = new JTable(data, columnNames);
    // додаємо таблиці в панель із трьома рядами
    setLayout(new GridLayout(3, 1));
    add(new JScrollPane(table1));
    add(new JScrollPane(table2));
    add(table3);
    // виводимо вікно на екран
    setSize(350, 400);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleTables(); } });
  }
}
