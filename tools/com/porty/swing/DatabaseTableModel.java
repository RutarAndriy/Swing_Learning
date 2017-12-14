// com/porty/swing/DatabaseTableModel.java
// ������ ������ �������, ����������
// � ��������� � ����� ������
package com.porty.swing;

import javax.swing.table.*;
import java.sql.*;
import java.util.*;

public class DatabaseTableModel
    extends AbstractTableModel {
  // ����� �� ����� ������� �������� ��������
  private ArrayList<String> columnNames = new ArrayList<String>();
  // ������ ����� ��������
  private ArrayList<Class> columnTypes = new ArrayList<Class>();
  // ��������� ��� ���������� ������ �� ���� ������
  private ArrayList<ArrayList<Object>> data
      = new ArrayList<ArrayList<Object>>();
  // ������� �������������� �������
  private boolean editable;
  // ����������� ��������� ������ ����������� ��������������
  public DatabaseTableModel(boolean editable) {
    this.editable = editable;
  }
  // ���������� �����
  public int getRowCount() {
    return data.size();
  }
  // ���������� ��������
  public int getColumnCount() {
    return columnNames.size();
  }
  // ��� ������ �������
  public Class getColumnClass(int column) {
    return columnTypes.get(column);
  }
  // �������� �������
  public String getColumnName(int column) {
    return columnNames.get(column);
  }
  // ������ � ������
  public Object getValueAt(int row, int column) {
    return (data.get(row)).get(column);
  }
  // ����������� ��������������
  public boolean isCellEditable(int row, int column) {
    return editable;
  }
  // ������ �������� ������
  public void setValueAt(
      Object value, int row, int column){
    (data.get(row)).set(column, value);
  }
  // ��������� ������ �� ������� ResultSet
  public void setDataSource(
      ResultSet rs) throws Exception {
    // ������� ������� ������
    data.clear();
    columnNames.clear();
    columnTypes.clear();
    // �������� ��������������� ���������� � ��������
    ResultSetMetaData rsmd = rs.getMetaData();
    int columnCount = rsmd.getColumnCount();
    for ( int i=0; i<columnCount; i++) {
      // �������� �������
      columnNames.add(rsmd.getColumnName(i+1));
      // ��� �������
      Class type =
          Class.forName(rsmd.getColumnClassName(i+1));
      columnTypes.add(type);
    }
    // �������� ������
    while ( rs.next() ) {
      // ����� ����� ������� ������ ����� ������
      ArrayList<Object> row = new ArrayList<Object>();
      for ( int i=0; i<columnCount; i++) {
        row.add(rs.getObject(i+1));
      }
      data.add(row);
    }
    // �������� �� ���������� � ��������� ������
    fireTableStructureChanged();
  }
}