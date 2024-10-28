// com/porty/swing/DatabaseComboBoxModel.java
// Модель випадаючого списку для роботи із базами даних
package com.porty.swing;

import javax.swing.*;
import java.sql.*;

public class DatabaseComboBoxModel
    extends DefaultComboBoxModel {
  // отримуємоо дані із запиту ResultSet
  public void setDataSource(ResultSet rs, int column)
      throws SQLException {
    // очистимо список
    removeAllElements();
    // додамо нові елементи із бази даних
    while ( rs.next() ) {
      // отримуємо строки із стовпця column
      addElement(rs.getString(column));
    }
  }
}
