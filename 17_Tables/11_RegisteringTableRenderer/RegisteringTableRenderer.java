// RegisteringTableRenderer.java
// Реєстрація в таблиці власного об'єкта для відображення
import javax.swing.*;
import javax.swing.table.*;
import com.porty.swing.*;
import java.awt.*;

public class RegisteringTableRenderer extends JFrame {
  public RegisteringTableRenderer() {
    super("RegisteringTableRenderer");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо таблиці на основі нашої моделі
    JTable table = new JTable(new SpecialModel());
    // реєструємо об'єкт для промальовування нових даних
    table.setDefaultRenderer(ImageListElement.class,
        new ImageTableCellRenderer());
    // виводимо вікно на екран
    add(new JScrollPane(table));
    pack();
    setVisible(true);
  }
  // модель таблиці
  class SpecialModel extends AbstractTableModel {
    // значки
    private Icon
        image1 = new ImageIcon("Clip1.gif"),
        image2 = new ImageIcon("Clip2.gif");
    // назви стовбців
    private String[] columnNames = {
        "Компанія", "Адреса"
    };
    // дані таблиці
    private Object[][] data = {
        { new ImageListElement(image1, "MegaWorks"),
            "<html><font color=\"red\">Париж" },
        { new ImageListElement(image2, "TerraMedia"),
            "<html><b>Відень" }
    };
    // кількість стовбців
    public int getColumnCount() {
      return columnNames.length;
    }
    // назви стовбців
    public String getColumnName(int column) {
      return columnNames[column];
    }
    // кількість рядків
    public int getRowCount() {
      return data.length;
    }
    // тип даних стовбця
    public Class getColumnClass(int column) {
      return data[0][column].getClass();
    }
    // значення в комірці
    public Object getValueAt(int row, int column) {
      return data[row][column];
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new RegisteringTableRenderer(); } });
  }
}
