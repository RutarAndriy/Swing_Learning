// CheckBoxList.java
// ������ � ��������
package com.porty.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class CheckBoxList extends JList {
  // ��������� ��� ������������
  public CheckBoxList(ListModel model) {
    super(model);
    initList();
  }
  public CheckBoxList(Object[] data) {
    super(data);
    initList();
  }
  public CheckBoxList(Vector data) {
    super(data);
    initList();
  }
  // ����������� ��������� ������
  private void initList() {
    setCellRenderer(new CheckBoxCellRenderer());
    setSelectionMode(
        ListSelectionModel.SINGLE_SELECTION);
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        // ������ �� ��������
        if ( e.getClickCount() == 1 &&
            SwingUtilities.isLeftMouseButton(e) ) {
          // ������ ��� ������
          int pos =
              locationToIndex(e.getPoint());
          CheckBoxListElement cbel =
              (CheckBoxListElement)getModel().
                  getElementAt(pos);
          cbel.setSelected(! cbel.isSelected());
          // ������ ������ ������ ��� ������ ������
          repaint(getCellBounds(pos, pos));
        }
      }
    });
  }
  // ������������ ������ ������
  public static class CheckBoxCellRenderer
      extends JCheckBox implements ListCellRenderer {
    public Component getListCellRendererComponent(
        JList list, Object data, int idx,
        boolean isSelected, boolean hasFocus) {
      // ��������, ��� ������ ������ ������� ����
      CheckBoxListElement
          cbel = (CheckBoxListElement)data;
      // ����������� ������
      if ( isSelected ) {
        setBackground(list.getSelectionBackground());
        setForeground(list.getSelectionForeground());
      } else {
        setBackground(list.getBackground());
        setForeground(list.getForeground());
      }
      setSelected(cbel.isSelected());
      setText(cbel.getText());
      return this;
    }
  }
}