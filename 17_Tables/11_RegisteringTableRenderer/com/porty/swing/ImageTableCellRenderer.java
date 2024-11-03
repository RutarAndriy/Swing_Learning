// com/porty/swing/ImageTableCellRenderer.java
// Об'єкт для промальовування значка і тексту в таблиці
package com.porty.swing;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class ImageTableCellRenderer
    extends DefaultTableCellRenderer {
  // метод повертає об'єкт для промальовування
  public Component getTableCellRendererComponent(
      JTable table, Object value, boolean isSelected,
      boolean hasFocus, int row, int column) {
    // отримуємо об'єкт потрібного типу
    if ( value instanceof ImageListElement ) {
      ImageListElement imageCell = (ImageListElement)value;
      // отримуємо налаштований напис від базового класу
      JLabel label = (JLabel)super.
          getTableCellRendererComponent(table,
              imageCell.getText(), isSelected, hasFocus,
              row, column);
      // встановлюємо значок і підказку
      label.setIcon(imageCell.getIcon());
      label.setToolTipText(imageCell.getText());
      return label;
    } else {
      return super.getTableCellRendererComponent(
          table, value, isSelected, hasFocus, row, column);
    }
  }
}
