// DatabaseTable.java
// Таблиця, працююча із базою даних за посередництва спеціальної моделі
// java -classpath h2-2.3.232.jar DatabaseTable.java
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import com.porty.swing.*;

public class DatabaseTable {
  // параметри підключення
  private static String
      dsn = "jdbc:h2:./Test",
      uid = "user",
      pwd = "";
  public static void main(String[] args) throws Exception {
    // ініціалізація JDBC
    Class.forName("org.h2.Driver");
    // об'єкт-з'єднання із БД
    Connection conn = DriverManager.getConnection(dsn, uid, pwd);
    Statement st = conn.createStatement();
    // виконуємо запит
    ResultSet rs = st.executeQuery(
        "SELECT * FROM USERS");
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
