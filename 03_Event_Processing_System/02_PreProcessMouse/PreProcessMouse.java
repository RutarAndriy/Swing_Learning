// PreProcessMouse.java
// Перехоплення подій від миші перед їх поступленням до прослуховувачів

import javax.swing.*;
import java.awt.event.*;

public class PreProcessMouse extends JFrame {
  PreProcessMouse() {
    super("PreProcessMouse");
    // при закриванні вікна - вихід
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // додаємо прослуховувач подій від миші
    addMouseListener(new MouseL());
    // виводимо вікно на екран
    setSize(200, 200);
    setVisible(true);
  }

  // перехоплення подій від миші
  public void processMouseEvent(MouseEvent e) {
    if (e.getClickCount() == 1) {
      // одне клацання не пропускаємо до прослуховувача
      return;
    }
    // інакше викликаємо метод базового класу
    else super.processMouseEvent(e);
  }

  // у цьому прослуховувачі будемо слідкувати за клацанням миші
  class MouseL extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
      System.out.println(
          "ClickCount: " + e.getClickCount());
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new PreProcessMouse();
          }
        });
  }
}
