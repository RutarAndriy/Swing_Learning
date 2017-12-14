// com/porty/swing/GUITools.java
// ����� ������������ ��� �������������
// �������� � �������� ������ ����������
package com.porty.swing;

import javax.swing.*;
import java.awt.*;

public class GUITools {
  // ���������� ��� �������� ������ �����������
  // ���������� �������� (�����������,
  // ���������������� � ������������).
  public static void makeSameSize(JComponent... cs) {
    // ����������� ������������� �������
    Dimension maxSize = cs[0].getPreferredSize();
    for (JComponent c: cs) {
      if ( c.getPreferredSize().width > maxSize.width ) {
        maxSize = c.getPreferredSize();
      }
    }
    // �������� ���������� ��������
    for (JComponent c : cs) {
      c.setPreferredSize(maxSize);
      c.setMinimumSize(maxSize);
      c.setMaximumSize(maxSize);
    }
  }
  // ��������� ��������� ���������� �
  // �������� ���������� ���� JTextField
  public static void fixTextFieldSize(JTextField field) {
    Dimension size = field.getPreferredSize();
    // ����� ��������� ���� ��-�������� �����
    // ����������� ���� ������ � �����
    size.width = field.getMaximumSize().width;
    // ������ ��������� ���� �� ������ ����
    // ����� ����������� ������
    field.setMaximumSize(size);
  }
}