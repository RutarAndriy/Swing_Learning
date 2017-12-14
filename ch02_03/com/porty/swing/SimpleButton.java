// com/porty/swing/SimpleButton.java
// ������ ���������� �� ����� ����������� ��������
package com.porty.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import com.porty.swing.event.*;

public class SimpleButton extends JComponent {
  // ������ ����������
  private ArrayList<ButtonPressListener>
      listenerList = new ArrayList<ButtonPressListener>();
  // ���� ������-������� �� ��� ������ �����
  private ButtonPressEvent event =
      new ButtonPressEvent(this);

  // ����������� - ������������ � ������ ���������
  // ������� �� ����
  public SimpleButton() {
    addMouseListener(new PressL());
    // ������� ������� ����������
    setPreferredSize(new Dimension(100, 100));
  }

  // ������������ ��������� ������� ������
  public void addButtonPressListener(
      ButtonPressListener l) {
    listenerList.add(l);
  }

  // ����������� ��������� ������� ������
  public void removeButtonPressListener(
      ButtonPressListener l) {
    listenerList.remove(l);
  }

  // ������������� ������
  public void paintComponent(Graphics g) {
    // ������ ������� ������
    g.setColor(Color.green);
    g.fillRect(0, 0, getWidth(), getHeight());
    // �����
    g.setColor(Color.black);
    g.draw3DRect(0, 0, getWidth(), getHeight(), true);
  }

  // ��������� ���������� � �������
  protected void fireButtonPressed() {
    for (ButtonPressListener l :
        listenerList) {
      l.buttonPressed(event);
    }
  }

  // ���������� �����, ������ �� ��������� ����
  class PressL extends MouseAdapter {
    // ������� ���� � ������� ������
    public void mousePressed(MouseEvent e) {
      // ��������� ����������
      fireButtonPressed();
    }
  }
}
