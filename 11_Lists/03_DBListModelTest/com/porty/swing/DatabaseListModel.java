// DatabaseListModel.java
// Модель списку, працююча із базою даних
package com.porty.swing;

import javax.swing.*;
import java.sql.*;
import java.util.*;

public class DatabaseListModel extends AbstractListModel {
  // тут будемо зберігати дані
  private ArrayList<String> data = new ArrayList<String>();
  // завантаження даних із бази даних
  public void setDataSource(ResultSet rs, String column)
      throws SQLException {
    // отримуємо дані
    data.clear();
    while ( rs.next() ) {
      data.add(rs.getString(column));
    }
    // сповіщаємо види (якщо вони є)
    fireIntervalAdded(this, 0, data.size());
  }
  // методи моделі для видачі даних списку
  public int getSize() {
    return data.size();
  }
  public Object getElementAt(int idx) {
    return data.get(idx);
  }
}
