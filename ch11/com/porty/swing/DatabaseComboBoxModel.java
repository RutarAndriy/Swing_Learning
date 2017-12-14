// com/porty/swing/DatabaseComboBoxModel.java
// ������ ��������������� ������ ��� ������ � ������ ������
package com.porty.swing;

import javax.swing.*;
import java.sql.*;

public class DatabaseComboBoxModel
    extends DefaultComboBoxModel {
  // ��������� ������ �� ������� ResultSet
  public void setDataSource(ResultSet rs, int column)
      throws SQLException {
    // ������� ������
    removeAllElements();
    // ������� ����� �������� �� ���� ������
    while ( rs.next() ) {
      // �������� ������ �� ������� column
      addElement(rs.getString(column));
    }
  }
}
