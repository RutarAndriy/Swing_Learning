// com/porty/swing/CheckBoxTree.java
// ������, ��������� ���������� � �������� ����� ������
package com.porty.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

public class CheckBoxTree extends JTree {
  // ����������� �� ������ ������
  public CheckBoxTree(TreeModel model) {
    super(model);
    // ������ ����������� ������������ ������
    setCellRenderer(new CheckBoxRenderer());
    // ������ �� �������� ����
    addMouseListener(new MouseL());
  }
  // ����������� ������ ��� ����������� �����
  private DefaultTreeCellRenderer renderer =
      new DefaultTreeCellRenderer();
  // ������ ��� ����������� ����� ������
  class CheckBoxRenderer extends JCheckBox
      implements TreeCellRenderer {
    public CheckBoxRenderer() {
      // ������ ������ ����������
      setOpaque(false);
    }
    // ������ ����� ������ ������� ��������� ��� ����
    public Component getTreeCellRendererComponent(
        JTree tree, Object value, boolean selected,
        boolean expanded, boolean leaf, int row,
        boolean hasFocus) {
      // ���������, ��� ������������ ����������� ������
      if (!(value instanceof DefaultMutableTreeNode)) {
        // ���� ���, �� ���������� ����������� ������
        return renderer.getTreeCellRendererComponent(
            tree, value, selected, expanded,
            leaf, row, hasFocus);
      }
      Object data = ((DefaultMutableTreeNode)value).
          getUserObject();
      // ���������, �������� �� ��� ��� ������ ����
      if ( data instanceof CheckBoxListElement ) {
        CheckBoxListElement element =
            (CheckBoxListElement)data;
        // ����������� ������
        setSelected(element.isSelected());
        setText(element.getText());
        return this;
      }
      // ����� ����������� ����������� ������
      return renderer.getTreeCellRendererComponent(tree,
          value, selected, expanded, leaf, row, hasFocus);
    }
  }
  // �����, �������� �� �������� ����
  class MouseL extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
      // ������� ���� � ����
      TreePath path = getClosestPathForLocation(
          e.getX(), e.getY());
      if ( path == null ) return;
      // ��������, �������� �� ��� ������ ����
      Object _node = path.getLastPathComponent();
      if (_node instanceof DefaultMutableTreeNode) {
        DefaultMutableTreeNode node =
            (DefaultMutableTreeNode)_node;
        Object data = node.getUserObject();
        if ( data instanceof CheckBoxListElement ) {
          // ������ ��������� ������
          CheckBoxListElement element =
              (CheckBoxListElement)data;
          element.setSelected(! element.isSelected());
          repaint(getPathBounds(path));
        }
      }
    }
  }
}