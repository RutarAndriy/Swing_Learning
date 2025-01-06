// com/porty/swing/CheckBoxTree.java
// Дерево, яке може відображати в якості вузлів прапорці
package com.porty.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

public class CheckBoxTree extends JTree {
  // конструктор на основі моделі
  public CheckBoxTree(TreeModel model) {
    super(model);
    // задаємо власний відображуваний об'єкт
    setCellRenderer(new CheckBoxRenderer());
    // слідкуємо за клацаннями миші
    addMouseListener(new MouseL());
  }
  // стандартний об'єкт для відображення вузлів
  private DefaultTreeCellRenderer renderer =
      new DefaultTreeCellRenderer();
  // прапорець для відображення вузлів дерева
  class CheckBoxRenderer extends JCheckBox
      implements TreeCellRenderer {
    public CheckBoxRenderer() {
      // робимо прапорець прозорим
      setOpaque(false);
    }
    // даний метод повинен повернути компонент для вузла
    public Component getTreeCellRendererComponent(
        JTree tree, Object value, boolean selected,
        boolean expanded, boolean leaf, int row,
        boolean hasFocus) {
      // перевіряємо, що використовується стандартна модель
      if (!(value instanceof DefaultMutableTreeNode)) {
        // якщо ні, то використовуємо стандартний об'єкт
        return renderer.getTreeCellRendererComponent(
            tree, value, selected, expanded,
            leaf, row, hasFocus);
      }
      Object data = ((DefaultMutableTreeNode)value).
          getUserObject();
      // перевіряємо, чи підходить нам тип даних вузла
      if ( data instanceof CheckBoxListElement ) {
        CheckBoxListElement element =
            (CheckBoxListElement)data;
        // налаштовуємо прапорець
        setSelected(element.isSelected());
        setText(element.getText());
        return this;
      }
      // інакше використовуємо стандартний об'єкт
      return renderer.getTreeCellRendererComponent(tree,
          value, selected, expanded, leaf, row, hasFocus);
    }
  }
  // клас, який слідкує за клацаннями миші
  class MouseL extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
      // отримуємо шлях до вузла
      TreePath path = getClosestPathForLocation(
          e.getX(), e.getY());
      if ( path == null ) return;
      // перевіряємо, чи підходять нам дані вузла
      Object _node = path.getLastPathComponent();
      if (_node instanceof DefaultMutableTreeNode) {
        DefaultMutableTreeNode node =
            (DefaultMutableTreeNode)_node;
        Object data = node.getUserObject();
        if ( data instanceof CheckBoxListElement ) {
          // змінюємо стан прапорця
          CheckBoxListElement element =
              (CheckBoxListElement)data;
          element.setSelected(! element.isSelected());
          repaint(getPathBounds(path));
        }
      }
    }
  }
}
