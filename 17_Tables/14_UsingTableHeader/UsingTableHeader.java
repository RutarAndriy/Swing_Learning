// UsingTableHeader.java
// Налаштування заголовка таблиці JTableHeader
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.*;

public class UsingTableHeader extends JFrame {
  // дані для таблиці
  private String[][] data = {
      { "Червень", "+18 С" },
      { "Липень", "+22 С" },
      { "Серпень", "+19 С" }
  };
  // назви стовбців
  private String[] columnNames = {
      "Місяць", "Середня температура"
  };
  public UsingTableHeader() {
    super("UsingTableHeader");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо таблицю
    JTable table = new JTable(data, columnNames);
    table.setAutoCreateRowSorter(true);
    // налаштовуємо заголовок таблиці
    JTableHeader header = table.getTableHeader();
    header.setReorderingAllowed(false);
    header.setResizingAllowed(false);
    // приєднюємо відображуючий об'єкт
    header.setDefaultRenderer(new HeaderRenderer());
    // додаємо таблицю в панель прокрутки
    add(new JScrollPane(table));
    setSize(400, 300);
    setVisible(true);
  }
  // спеціальний відображуваний об'єкт для заголовку
  class HeaderRenderer
      extends DefaultTableCellRenderer {
    // метод повертає компонент для промальовування
    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int column) {
      // отримуємо налаштовуваний напис від базового класу
      JLabel label = (JLabel)super.
          getTableCellRendererComponent(table,
              value, isSelected, hasFocus,
              row, column);
      // налаштовуємо особливу рамку і колір фону
      label.setBackground(Color.gray);
      label.setBorder(border);
      return label;
    }
    private Border border = BorderFactory.
        createMatteBorder(16, 16, 16, 16,
            new ImageIcon("Bullet.png"));
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingTableHeader(); } });
  }
}
