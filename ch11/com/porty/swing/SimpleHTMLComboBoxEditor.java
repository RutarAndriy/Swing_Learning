// com/porty/swing/
// SimpleHTMLComboBoxEditor.java
// ������� �������� ��� ��������������� ������,
// ������������� HTML
package com.porty.swing;
import javax.swing.plaf.basic.*;

public class SimpleHTMLComboBoxEditor
    extends BasicComboBoxEditor {
  // � ���� ����� ���������� ����� �������
  // ��� ��������������
  public void setItem(Object item) {
    // �������� ��������� �������������
    String text = item.toString();
    // �������� ��� ���� � ������� ����������� ���������
    String noHTMLString = text.replaceAll("\\<.*?\\>", "");
    // �������� "���������" ������
    // ������������ �������
    super.setItem(noHTMLString);
  }
}