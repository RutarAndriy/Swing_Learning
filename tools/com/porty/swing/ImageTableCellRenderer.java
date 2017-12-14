// com/porty/swing/ImageTableCellRenderer.java
// ������ ��� ���������� ������ � ������ � �������
package com.porty.swing;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class ImageTableCellRenderer
    extends DefaultTableCellRenderer {
  // ����� ���������� ��������� ��� ����������
  public Component getTableCellRendererComponent(
      JTable table, Object value, boolean isSelected,
      boolean hasFocus, int row, int column) {
    // �������� ������ ������� ����
    if ( value instanceof ImageListElement ) {
      ImageListElement imageCell = (ImageListElement)value;
      // �������� ����������� ������� �� �������� ������
      JLabel label = (JLabel)super.
          getTableCellRendererComponent(table,
              imageCell.getText(), isSelected, hasFocus,
              row, column);
      // ������������� ������ � ���������
      label.setIcon(imageCell.getIcon());
      label.setToolTipText(imageCell.getText());
      return label;
    } else {
      return super.getTableCellRendererComponent(
          table, value, isSelected, hasFocus, row, column);
    }
  }
}
