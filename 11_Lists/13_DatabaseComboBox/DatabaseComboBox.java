// DatabaseComboBox.java
// Приклад використання моделі DatabaseComboBoxModel
// Приклад застарів, тому не працює на нових версіях Java починаючи із 8-ї
import javax.swing.*;
import com.porty.swing.DatabaseComboBoxModel;
import java.sql.*;
import java.awt.*;

public class DatabaseComboBox extends JFrame {
  // параметри підключення до бази даних
  private static String
      dsn = "jdbc:odbc:Library",
      uid = "",
      pwd = "";
  // наша модель
  private DatabaseComboBoxModel cbm;
  public DatabaseComboBox() {
    super("DatabaseComboBox");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // налаштовуємо з'єднання із базою даних
    Connection conn = null;
    try {
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      // об'єкт-з'єднання із базою даних
      conn = DriverManager.getConnection(dsn, uid, pwd);
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery(
          "select * from readers.csv");
      // передаємо дані в модель
      cbm = new DatabaseComboBoxModel();
      cbm.setDataSource(rs, 2);
      rs.close();
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
    // приєднюємо модель до списку
    setLayout(new FlowLayout());
    add(new JComboBox(cbm));
    // виводимо вікно на екран
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new DatabaseComboBox(); } });
  }
}
