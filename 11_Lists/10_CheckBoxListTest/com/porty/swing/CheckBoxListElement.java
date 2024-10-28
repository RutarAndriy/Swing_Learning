// com/porty/swing/CheckBoxListElement.java
// Дані елемента списку із прапорцями
package com.porty.swing;

public class CheckBoxListElement {
  // дані елемента
  private boolean selected;
  private String text;
  // зручний конструктор
  public CheckBoxListElement(boolean selected, String text){
    this.selected = selected;
    this.text = text;
  }
  // методи для доступу до значка та тексту
  public boolean isSelected() {  return selected; }
  public String getText() { return text; }
  public void setSelected(boolean selected) {
    this.selected = selected;
  }
  public void setText(String text) { this.text = text; }
}
