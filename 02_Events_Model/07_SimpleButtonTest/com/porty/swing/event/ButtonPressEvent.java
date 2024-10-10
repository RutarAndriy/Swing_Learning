// com/porty/swing/event/ButtonPressEvent.java
// Клас події для кнопки SimpleButton
package com.porty.swing.event;

import java.util.EventObject;

public class ButtonPressEvent extends EventObject {
  // конструктор. Вимагає задати джерело події
  public ButtonPressEvent(Object source) {
    super(source);
  }
}
