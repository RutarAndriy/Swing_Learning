// com/porty/swing/ImageListCellRenderer.java
// Клас для промальовки у скиску одночасно
// значка та тексту
package com.porty.swing;

import javax.swing.*;
import java.awt.*;

public class ImageListCellRenderer
    extends DefaultListCellRenderer {
  // метод, який повертає для елемента малюючий компонент
  public Component getListCellRendererComponent(
      JList list, Object data, int idx, boolean isSelected,
      boolean hasFocus) {
    // перевіряємо, чи елемент потрібного нам типу
    if ( data instanceof ImageListElement ) {
      ImageListElement lie =
          (ImageListElement)data;
      // отримуємо текст і значок
      Icon icon = lie.getIcon();
      String text = lie.getText();
      // використовуємо можливості базового класу
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
