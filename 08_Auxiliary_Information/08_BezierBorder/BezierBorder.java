// BezierBorder.java
// Рамка, складена із кривих Безьє
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.geom.*;

public class BezierBorder implements Border {
  // властивості рамки
  private Color color, shadow;
  private float thickness;

  // значення властивостей передаються в конструкторі
  public BezierBorder(Color color, Color shadow,
                      float thickness) {
    this.color = color;
    this.shadow = shadow;
    this.thickness = thickness;
  }

  // місце, яке займає рамка
  public Insets getBorderInsets(Component comp) {
    return new Insets(9, 9, 9, 9);
  }
  // наша рамка частково прозора
  public boolean isBorderOpaque() {
    return false;
  }
  // метод промальовування рамки
  public void paintBorder(Component c, Graphics g,
                          int x, int y, int width, int height) {
    // використовуємо новий об'єкт Graphics
    Graphics2D g2 = (Graphics2D)g.create();
    // налаштування пера, координат та кольору
    g2.setStroke(new BasicStroke(thickness));
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    x += 5; y += 5; width -= 10; height -= 10;
    g2.setColor(shadow);
    // промальовуємо тінь та рамку
    for (int i=0; i<2; i++) {
      CubicCurve2D left = new CubicCurve2D.Double( x, y,
          x-5, y+height*1/3, x+5, y+height*1/3,
          x, y+height);
      CubicCurve2D right = new CubicCurve2D.Double(
          x+width, y, x+width-5, y+height*1/3, x+width+5,
          y+height*2/3, x+width, y+height);
      CubicCurve2D top = new CubicCurve2D.Double( x, y,
          x+width*1/3, y+5, x+width*2/3, y-5, x+width, y);
      CubicCurve2D bottom = new CubicCurve2D.Double( x,
          y+height, x+width*1/3, y+height+5, x+width*2/3,
          y+height+5, x+width, y+height);
      g2.draw(left);
      g2.draw(right);
      g2.draw(top);
      g2.draw(bottom);
      // на другому кроці малюємо саму рамку
      x--; y--; width--; height--;
      g2.setColor(color);
    }
    g2.dispose();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            JFrame frame = new JFrame("BezierBorder");
            // створюємо панель з нашою рамкою
            JPanel p = new JPanel(new BorderLayout());
            Border b = new TitledBorder(new BezierBorder(
                Color.GREEN, Color.DARK_GRAY, 3f), "Bezier");
            p.setBorder(b);
            p.add(new JTextArea());
            // виводимо вікно на екран
            frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
            frame.add(p);
            frame.setSize(200, 200);
            frame.setVisible(true);
          } });
  }

}
