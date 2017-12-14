// com/porty/swing/DateCellEditor.java
// �������� ��� ����� �������, ������������ ����
package com.porty.swing;

import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class DateCellEditor extends AbstractCellEditor
    implements TableCellEditor {
  // �������� - ���������������� ������
  private JSpinner editor;
  // �����������
  public DateCellEditor() {
    // ����������� ���������������� ������
    SpinnerDateModel model = new SpinnerDateModel(
        new Date(), null, null, Calendar.DAY_OF_MONTH);
    editor = new JSpinner(model);
  }
  // ���������� ���������, ����������� ��� ��������������
  public java.awt.Component getTableCellEditorComponent(
      JTable table, Object value, boolean isSelected,
      int row, int column) {
    // ������ �������� � ���������� ������
    editor.setValue(value);
    return editor;
  }
  // ���������� ������� �������� � ���������
  public Object getCellEditorValue() {
    return editor.getValue();
  }
}
