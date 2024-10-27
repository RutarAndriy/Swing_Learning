// com/porty/swing/ImageListElement.java
// Клас, зберігаючий значок та текст елемента
package com.porty.swing;

import javax.swing.*;

public class ImageListElement {
  // значок та текст
  private Icon icon;
  private String text;
	// зручний конструктор
	public ImageListElement(Icon icon, String text) {
		this.icon = icon;
		this.text = text;
	}
  // методи для доступу до значка і тексту
  public Icon getIcon() {  return icon; }
  public String getText() { return text; }
  public void setIcon(Icon icon) { this.icon = icon; }
  public void setText(String text) { this.text = text; }
}
