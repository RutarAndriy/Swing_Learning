// com/porty/swing/GUITools.java
// Набір інструментів для кінцевого
// шліфування та надання блиску інтерфейсу
package com.porty.swing;

import javax.swing.*;
import java.awt.*;

public class GUITools {
  // інструмент для надання групі компонентів
  // однакових розмірів (мінімальних,
  // бажаних та максимальних)
  public static void makeSameSize(JComponent... cs) {
    // визначення максимального розміру
    Dimension maxSize = cs[0].getPreferredSize();
    for (JComponent c: cs) {
      if ( c.getPreferredSize().width > maxSize.width ) {
        maxSize = c.getPreferredSize();
      }
    }
    // задання однакових розмірів
    for (JComponent c : cs) {
      c.setPreferredSize(maxSize);
      c.setMinimumSize(maxSize);
      c.setMaximumSize(maxSize);
    }
  }
  // дозволяє виправити погрішність
  // розмірів текстового поля JTextField
  public static void fixTextFieldSize(JTextField field) {
    Dimension size = field.getPreferredSize();
    // щоб текстове поле по-старому могло
    // збільшувати свій розмір в довжину
    size.width = field.getMaximumSize().width;
    // тепер текстове поле не стане вище
    // своєї оптимальної висоти
    field.setMaximumSize(size);
  }
}
