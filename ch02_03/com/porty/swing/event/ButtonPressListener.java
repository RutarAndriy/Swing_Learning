// com/porty/swing/event/ButtonPressListener.java
// ��������� ��������� ������� ������� ������
package com.porty.swing.event;

import java.util.EventListener;

public interface ButtonPressListener extends EventListener {
  // ������ ����� ����� ���������� ��� ������� ������
  void buttonPressed(ButtonPressEvent e);
}