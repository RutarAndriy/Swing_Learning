// com/porty/swing/HTMLComboBoxEditor.java
// Повнофункціональний редактор для списку
// JComboBox, використовуючого HTML
package com.porty.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HTMLComboBoxEditor
    implements ComboBoxEditor {
  // редактор для HTML
  private JEditorPane htmlEditor;
  public HTMLComboBoxEditor() {
    htmlEditor =
        new JEditorPane("text/html", "");
    htmlEditor.setBorder(BorderFactory.
        createEtchedBorder());
  }
  // повертаємо редактор
  public Component getEditorComponent() {
    return htmlEditor;
  }
  // сигнал вибрати весь текст і приступити
  // до редагування
  public void selectAll() {
    htmlEditor.selectAll();
    htmlEditor.requestFocus();
  }
  // повертає редагований елемент
  public Object getItem() {
    return htmlEditor.getText();
  }
  // отримує новий елемент для редагування
  public void setItem(Object item) {
    htmlEditor.setText(item.toString());
  }
  // методи для приєднання прослуховувачів
  // ActionListener, які сповіщають
  // про закінчення редагування
  public void addActionListener(
      ActionListener e) { }
  public void removeActionListener(
      ActionListener e) { }
}
