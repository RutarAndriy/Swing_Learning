// PaintingWithBorders.java
// Малювання компонента із врахуванням рамки
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;

public class PaintingWithBorders extends JFrame {
  public PaintingWithBorders() {
    super("PaintingWithBorders");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // додамо до нашого компонента рамку
    CustomComponent cc = new CustomComponent();
    cc.setBorder(BorderFactory.
        createTitledBorder("Рамка!"));
    // додамо компонент у вікно
    getContentPane().add(cc);
    setSize(400, 300);
    setVisible(true);
  }
  // компонент із своїм власним методом перемальовування
  class CustomComponent extends JComponent {
    public void paintComponent(Graphics g) {
      // отримуємо підходящий прямокутник
      Rectangle rect = AbstractBorder.
          getInteriorRectangle(this, getBorder(),
              0, 0, getWidth(), getHeight());
      // малюємо в ньому
      g.setColor(Color.white);
      g.fillRect(
          rect.x, rect.y, rect.width, rect.height);
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new PaintingWithBorders(); } });
  }
}
