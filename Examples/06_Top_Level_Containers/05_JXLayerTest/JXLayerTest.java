// JXLayerTest.java
// java -classpath jxlayer-3.0.4.jar JXLayerTest.java
// Приклад використання шарів JXLayer
import org.jdesktop.jxlayer.JXLayer;
import org.jdesktop.jxlayer.plaf.BufferedLayerUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class JXLayerTest extends JFrame {
  public JXLayerTest() {
    super("JXLayerTest");
    // вихід при закриванні вікна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо простий вміст
    JPanel p = new JPanel();
    p.add(new JTextField(10));
    p.add(new JButton("ОК"));
    // покладемо вміст в шар
    JXLayer<JPanel> layer = new JXLayer<JPanel>(p);
    // створимо шар реагуючий на події
    layer.setUI(new BufferedLayerUI<JPanel>() {
      private int lastX, lastY;
      // промальовка шару
      public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        g.setColor(Color.RED);
        g.fillOval(lastX, lastY, 15, 15);
      }
      // отримання подій в межах шару
      protected void processMouseMotionEvent(MouseEvent e,
               JXLayer<? extends JPanel> layer) {
        lastX = SwingUtilities.convertMouseEvent(
            (Component) e.getSource(), e, layer).getX();
        lastY = SwingUtilities.convertMouseEvent(
            (Component) e.getSource(), e, layer).getY();
        repaint();
      }
    });
    // JXLayer потрібно додати в контейнер
    add(layer);
    // вивід вікна на екран
    setSize(400, 150);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new JXLayerTest(); } });
  }
}
