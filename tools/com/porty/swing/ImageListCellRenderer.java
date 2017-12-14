// com/porty/swing/ImageListCellRenderer.java
// ����� ��� ���������� � ������ ������������
// ������ � ������
package com.porty.swing;

import javax.swing.*;
import java.awt.*;

public class ImageListCellRenderer
    extends DefaultListCellRenderer {
  // �����, ������������ ��� �������� �������� ���������
  public Component getListCellRendererComponent(
      JList list, Object data, int idx, boolean isSelected,
      boolean hasFocus) {
    // ���������, ������� �� ������� ����
    if ( data instanceof ImageListElement ) {
      ImageListElement lie =
          (ImageListElement)data;
      // �������� ����� � ������
      Icon icon = lie.getIcon();
      String text = lie.getText();
      // ���������� ����������� �������� ������
      JLabel label = (JLabel)
          super.getListCellRendererComponent(
              list, text, idx, isSelected, hasFocus);
      label.setIcon(icon);
      return label;
    } else
      return super.getListCellRendererComponent(
          list, data, idx, isSelected, hasFocus);
  }
}