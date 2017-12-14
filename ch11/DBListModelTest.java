// DBListModelTest.java
// ������������� ������ ������ 
// ��� ������ � ������ ������
import javax.swing.*;
import java.sql.*;
import java.awt.*;

import com.porty.swing.*;

public class DBListModelTest {
  // ��������� ���� ������
  private static String
      dsn = "jdbc:odbc:Library",
      uid = "",
      pwd = "",
      query = "select * from readers.csv";
  public static void main(String[] args) throws Exception {
    // ������������� JDBC
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    // ������-���������� � ����� ������
    Connection conn = DriverManager.getConnection(dsn, uid, pwd);
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(query);
    // ������� ������
    final DatabaseListModel dblm = new DatabaseListModel();
    // ��������� ������
    dblm.setDataSource(rs, "surname");
    rs.close();
    // ��������� ������� � ������ �������� �������
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            // ������������ ������
            JList list = new JList(dblm);
            // �������� ������ � ����
            JFrame frame = new JFrame("DBList");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(200, 200);
            frame.add(new JScrollPane(list));
            frame.setVisible(true);
          } });
  }
}
