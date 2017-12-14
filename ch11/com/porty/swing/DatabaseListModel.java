// DatabaseListModel.java
// ������ ������, ���������� � ����� ������
package com.porty.swing;

import javax.swing.*;
import java.sql.*;
import java.util.*;

public class DatabaseListModel extends AbstractListModel {
  // ����� ����� ������� ������
  private ArrayList<String> data = new ArrayList<String>();
  // �������� �� ���� ������
  public void setDataSource(ResultSet rs, String column)
      throws SQLException {
    // �������� ������
    data.clear();
    while ( rs.next() ) {
      data.add(rs.getString(column));
    }
    // ��������� ���� (���� ��� ����)
    fireIntervalAdded(this, 0, data.size());
  }
  // ������ ������ ��� ������ ������ ������
  public int getSize() {
    return data.size();
  }
  public Object getElementAt(int idx) {
    return data.get(idx);
  }
}
