// AWTPainting.java
// Процес малювання в AWT дуже простий

import java.awt.*;
import java.awt.event.*;

public class AWTPainting extends Frame {

  public AWTPainting() {
    super("AWTPainting");
    // вихід при закритті вікна
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    setLayout(new FlowLayout());
    // спробуємо замалювати частину кнопки
    add(new Button("Перемалюємо кнопку!") {
      public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(2, 2, getWidth() - 5, getHeight() - 5);
      }
    });
    setSize(200, 200);
  }

  // у цьому методі відбувається малювання
  public void paint(Graphics g) {
    // заповнюємо все червоним кольором
    g.setColor(Color.RED);
    g.fillRect(0, 0, getWidth(), getHeight());
  }

  public static void main(String[] args) {
    new AWTPainting().setVisible(true);
  }
}
