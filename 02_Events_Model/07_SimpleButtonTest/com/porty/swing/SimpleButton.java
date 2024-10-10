// com/porty/swing/SimpleButton.java
// Приклад компонента зі своєю власною подією
package com.porty.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import com.porty.swing.event.*;

public class SimpleButton extends JComponent {
  // список прослуховувачів
  private ArrayList<ButtonPressListener>
      listenerList = new ArrayList<ButtonPressListener>();
  // один об'єкт-подія на всі випадки життя
  private ButtonPressEvent event =
      new ButtonPressEvent(this);

  // конструктор - приєднює до кнопки прослуховувача
  // подій від миші
  public SimpleButton() {
    addMouseListener(new PressL());
    // задамо розмір компонента
    setPreferredSize(new Dimension(100, 100));
  }

  // приєднує прослуховувача натискання кнопки
  public void addButtonPressListener(
      ButtonPressListener l) {
    listenerList.add(l);
  }

  // відє'днує прослуховувача натискання кнопки
  public void removeButtonPressListener(
      ButtonPressListener l) {
    listenerList.remove(l);
  }

  // промальовує кнопку
  public void paintComponent(Graphics g) {
    // заливаємо зеленим кольором
    g.setColor(Color.green);
    g.fillRect(0, 0, getWidth(), getHeight());
    // рамка
    g.setColor(Color.black);
    g.draw3DRect(0, 0, getWidth(), getHeight(), true);
  }

  // сповіщаємо прослуховувачів про подію
  protected void fireButtonPressed() {
    for (ButtonPressListener l :
        listenerList) {
      l.buttonPressed(event);
    }
  }

  // внутрішній клас, слідкує за натисканням миші
  class PressL extends MouseAdapter {
    // натискання миші в області кнопки
    public void mousePressed(MouseEvent e) {
      // сповіщаємо прослуховувачів
      fireButtonPressed();
    }
  }
}
