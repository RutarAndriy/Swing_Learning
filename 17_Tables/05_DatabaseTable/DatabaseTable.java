// DatabaseTable.java
// Таблиця, працююча із базою даних за посередництва спеціальної моделі
// Приклад застарів, тому не працює на нових версіях Java починаючи із 8-ї
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import com.porty.swing.*;

public class DatabaseTable {
  // параметри підключення
  private static String
      dsn = "jdbc:odbc:Library",
      uid = "",
      pwd = "";
  public static void main(String[] args) throws Exception {
    // ініціалізація JDBC
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    // об'єкт-з'єднання із БД
    Connection conn = DriverManager.getConnection(dsn, uid, pwd);
    Statement st = conn.createStatement();
    // виконуємо запит
    ResultSet rs = st.executeQuery(
        "select * from readers.csv");
    // наша модель
    final DatabaseTableModel dbm =
        new DatabaseTableModel(true);
    // зчитуємо дані в таблицю
    dbm.setDataSource(rs);
    // таблиця і вікно
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            JTable table = new JTable(dbm);
            JFrame frame = new JFrame("DatabaseTable");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.add(new JScrollPane(table));
            frame.setVisible(true);
          }});
    rs.close();
    conn.close();
  }
}
