// com/porty/swing/event/ButtonPressEvent.java
// ����� ������� ��� ������ SimpleButton
package com.porty.swing.event;

import java.util.EventObject;

public class ButtonPressEvent extends EventObject {
  // �����������. ������� ������ �������� �������
  public ButtonPressEvent(Object source) {
    super(source);
  }
}