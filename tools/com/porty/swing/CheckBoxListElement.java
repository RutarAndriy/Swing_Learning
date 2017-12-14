// com/porty/swing/CheckBoxListElement.java
// ������ �������� ������ � ��������
package com.porty.swing;

public class CheckBoxListElement {
  // ������ ��������
  private boolean selected;
  private String text;
  // ������� �����������
  public CheckBoxListElement(boolean selected, String text){
    this.selected = selected;
    this.text = text;
  }
  // ������ ��� ������� � ������ � ������
  public boolean isSelected() {  return selected; }
  public String getText() { return text; }
  public void setSelected(boolean selected) {
    this.selected = selected;
  }
  public void setText(String text) { this.text = text; }
}