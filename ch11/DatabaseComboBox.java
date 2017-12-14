// DatabaseComboBox.java
// ������ ������������� ������ DatabaseComboBoxModel
import javax.swing.*;
import com.porty.swing.DatabaseComboBoxModel;
import java.sql.*;
import java.awt.*;

public class DatabaseComboBox extends JFrame {
  // ��������� ����������� � ���� ������
  private static String
      dsn = "jdbc:odbc:Library",
      uid = "",
      pwd = "";
  // ���� ������
  private DatabaseComboBoxModel cbm;
  public DatabaseComboBox() {
    super("DatabaseComboBox");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ����������� ���������� � ����� ������
    Connection conn = null;
    try {
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      // ������-���������� � ����� ������
      conn = DriverManager.getConnection(dsn, uid, pwd);
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery(
          "select * from readers.csv");
      // �������� ������ � ������
      cbm = new DatabaseComboBoxModel();
      cbm.setDataSource(rs, 2);
      rs.close();
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
    // ������������ ������ � ������
    setLayout(new FlowLayout());
    add(new JComboBox(cbm));
    // ������� ���� �� �����
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new DatabaseComboBox(); } });
  }
}