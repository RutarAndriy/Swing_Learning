// DatabaseTable.java
// �������, ���������� � ����� ������
// ����������� ����������� ������
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import com.porty.swing.*;

public class DatabaseTable {
  // ��������� �����������
  private static String
      dsn = "jdbc:odbc:Library",
      uid = "",
      pwd = "";
  public static void main(String[] args) throws Exception {
    // ������������� JDBC
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    // ������-���������� � ��
    Connection conn = DriverManager.getConnection(dsn, uid, pwd);
    Statement st = conn.createStatement();
    // ��������� ������
    ResultSet rs = st.executeQuery(
        "select * from readers.csv");
    // ���� ������
    final DatabaseTableModel dbm =
        new DatabaseTableModel(true);
    // ��������� ������ � �������
    dbm.setDataSource(rs);
    // ������� � ����
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