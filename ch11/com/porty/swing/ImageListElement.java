// com/porty/swing/ImageListElement.java
// �����, �������� ������ � ����� ��������
package com.porty.swing;

import javax.swing.*;

public class ImageListElement {
  // ������ � �����
  private Icon icon;
  private String text;
	// ������� �����������
	public ImageListElement(Icon icon, String text) {
		this.icon = icon;
		this.text = text;
	}
  // ������ ��� ������� � ������ � ������
  public Icon getIcon() {  return icon; }
  public String getText() { return text; }
  public void setIcon(Icon icon) { this.icon = icon; }
  public void setText(String text) { this.text = text; }
}