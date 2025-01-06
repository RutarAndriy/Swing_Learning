// com/porty/swing/event/ButtonPressListener.java
// Інтерфейс прослуховувача події натискання кнопки
package com.porty.swing.event;

import java.util.EventListener;

public interface ButtonPressListener extends EventListener {
  // даний метод буде викликатися при натисканні кнопки
  void buttonPressed(ButtonPressEvent e);
}
