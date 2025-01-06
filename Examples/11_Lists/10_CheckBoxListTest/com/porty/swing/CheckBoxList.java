// CheckBoxList.java
// Список із прапорцями
package com.porty.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class CheckBoxList extends JList<CheckBoxListElement> {
  // зберігаємо усі конструктори
  public CheckBoxList(ListModel<CheckBoxListElement> model) {
    super(model);
    initList();
  }
  public CheckBoxList(CheckBoxListElement[] data) {
    super(data);
    initList();
  }
  public CheckBoxList(Vector<CheckBoxListElement> data) {
    super(data);
    initList();
  }
  // спеціальне налаштування списку
  private void initList() {
    setCellRenderer(new CheckBoxCellRenderer());
    setSelectionMode(
        ListSelectionModel.SINGLE_SELECTION);
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        // слідкуємо за клацаннями
        if ( e.getClickCount() == 1 &&
            SwingUtilities.isLeftMouseButton(e) ) {
          // потрібне нам клацання
          int pos =
              locationToIndex(e.getPoint());
          CheckBoxListElement cbel =
              (CheckBoxListElement)getModel().
                  getElementAt(pos);
          cbel.setSelected(! cbel.isSelected());
          // заново малюємо тільки цю комірку списку
          repaint(getCellBounds(pos, pos));
        }
      }
    });
  }
  // відображаючий прапорці об'єкт
  public static class CheckBoxCellRenderer
      extends JCheckBox implements ListCellRenderer<CheckBoxListElement> {
    public Component getListCellRendererComponent(
        JList list, CheckBoxListElement data, int idx,
        boolean isSelected, boolean hasFocus) {
      // налаштовуємо прапорець
      if ( isSelected ) {
        setBackground(list.getSelectionBackground());
        setForeground(list.getSelectionForeground());
      } else {
        setBackground(list.getBackground());
        setForeground(list.getForeground());
      }
      setSelected(data.isSelected());
      setText(data.getText());
      return this;
    }
  }
}
