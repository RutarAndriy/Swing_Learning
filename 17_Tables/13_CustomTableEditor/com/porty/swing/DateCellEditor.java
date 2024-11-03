// com/porty/swing/DateCellEditor.java
// Редактор для комірок таблиці, які відображають дати
package com.porty.swing;

import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class DateCellEditor extends AbstractCellEditor
    implements TableCellEditor {
  // редактор - прокручуваний список
  private JSpinner editor;
  // конструктор
  public DateCellEditor() {
    // налаштовуємо прокручуваний список
    SpinnerDateModel model = new SpinnerDateModel(
        new Date(), null, null, Calendar.DAY_OF_MONTH);
    editor = new JSpinner(model);
  }
  // повертаємо компонент, який застосовується для редагування
  public java.awt.Component getTableCellEditorComponent(
      JTable table, Object value, boolean isSelected,
      int row, int column) {
    // змінюємо значення і повертаємо список
    editor.setValue(value);
    return editor;
  }
  // повертає поточне значення в редакторі
  public Object getCellEditorValue() {
    return editor.getValue();
  }
}
