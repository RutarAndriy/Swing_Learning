// com/porty/swing/HTMLComboBoxEditor.java
// ������������������� �������� ��� ������
// JComboBox, ������������� HTML
package com.porty.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HTMLComboBoxEditor
    implements ComboBoxEditor {
  // �������� ��� HTML
  private JEditorPane htmlEditor;
  public HTMLComboBoxEditor() {
    htmlEditor =
        new JEditorPane("text/html", "");
    htmlEditor.setBorder(BorderFactory.
        createEtchedBorder());
  }
  // ���������� ��������
  public Component getEditorComponent() {
    return htmlEditor;
  }
  // ������ ������� ���� ����� � ����������
  // � ��������������
  public void selectAll() {
    htmlEditor.selectAll();
    htmlEditor.requestFocus();
  }
  // ���������� ������������� �������
  public Object getItem() {
    return htmlEditor.getText();
  }
  // �������� ����� ������� ��� ��������������
  public void setItem(Object item) {
    htmlEditor.setText(item.toString());
  }
  // ������ ��� ������������� ����������
  // ActionListener, ������� �����������
  // �� ��������� ��������������
  public void addActionListener(
      ActionListener e) { }
  public void removeActionListener(
      ActionListener e) { }
}