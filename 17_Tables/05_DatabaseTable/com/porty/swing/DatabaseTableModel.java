// com/porty/swing/DatabaseTableModel.java
// Модель даних таблиці, працююча
// із запитами до бази даних
package com.porty.swing;

import javax.swing.table.*;
import java.sql.*;
import java.util.*;

public class DatabaseTableModel
    extends AbstractTableModel {
  // тут ми будемо зберігати назви стовбців
  private ArrayList<String> columnNames = new ArrayList<String>();
  // список типів стовбців
  private ArrayList<Class> columnTypes = new ArrayList<Class>();
  // сховище для отриманих даних із бази даних
  private ArrayList<ArrayList<Object>> data
      = new ArrayList<ArrayList<Object>>();
  // признак редагування таблиці
  private boolean editable;
  // конструктор позволяє задати можливість редагування
  public DatabaseTableModel(boolean editable) {
    this.editable = editable;
  }
  // кількість рядків
  public int getRowCount() {
    return data.size();
  }
  // кількість стовбців
  public int getColumnCount() {
    return columnNames.size();
  }
  // тип даних стовбця
  public Class getColumnClass(int column) {
    return columnTypes.get(column);
  }
  // назва стовбця
  public String getColumnName(int column) {
    return columnNames.get(column);
  }
  // дані в комірці
  public Object getValueAt(int row, int column) {
    return (data.get(row)).get(column);
  }
  // можливість редагування
  public boolean isCellEditable(int row, int column) {
    return editable;
  }
  // заміна значення комірки
  public void setValueAt(
      Object value, int row, int column){
    (data.get(row)).set(column, value);
  }
  // отримання даних із об'єкту ResultSet
  public void setDataSource(
      ResultSet rs) throws Exception {
    // видаляємо попередні дані
    data.clear();
    columnNames.clear();
    columnTypes.clear();
    // отримуємо допоміжну інформацію про стовбці
    ResultSetMetaData rsmd = rs.getMetaData();
    int columnCount = rsmd.getColumnCount();
    for ( int i=0; i<columnCount; i++) {
      // назва стовбця
      columnNames.add(rsmd.getColumnName(i+1));
      // тип стовбця
      Class type =
          Class.forName(rsmd.getColumnClassName(i+1));
      columnTypes.add(type);
    }
    // отримуємо дані
    while ( rs.next() ) {
      // тут будемо зберігати комірки одного рядка
      ArrayList<Object> row = new ArrayList<Object>();
      for ( int i=0; i<columnCount; i++) {
        row.add(rs.getObject(i+1));
      }
      data.add(row);
    }
    // повідомляємо про зміни в структурі даних
    fireTableStructureChanged();
  }
}
