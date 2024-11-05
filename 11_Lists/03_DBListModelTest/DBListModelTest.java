// DBListModelTest.java
// Використання моделі списку для работи із базами даних
// java -classpath h2-2.3.232.jar DBListModelTest.java
import javax.swing.*;
import java.sql.*;
import java.awt.*;

import com.porty.swing.*;

public class DBListModelTest {
  // параметри дази даних
  private static String
      dsn = "jdbc:h2:./Test",
      uid = "user",
      pwd = "",
      query = "SELECT * FROM USERS";
  public static void main(String[] args) throws Exception {
    // ініціалізація JDBC
    Class.forName("org.h2.Driver");
    // об'єкт-з'єднання із базою даних
    Connection conn = DriverManager.getConnection(dsn, uid, pwd);
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(query);
    // створюємо модель
    final DatabaseListModel dblm = new DatabaseListModel();
    // завантажуємо дані
    dblm.setDataSource(rs, "NAME");
    rs.close();
    // інтерфейс створюємо у потоці розсилання подій
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            // приєднюємо список
            JList<String> list = new JList<>(dblm);
            // поміщаємо список у вікно
            JFrame frame = new JFrame("DBListModelTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            frame.add(new JScrollPane(list));
            frame.setVisible(true);
          } });
  }
}
