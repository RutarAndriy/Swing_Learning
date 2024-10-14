// RotatedUI.java
// Крутіння та вертіння стандартних компонентів
import javax.swing.*;
import java.awt.*;

public class RotatedUI extends JFrame {
  public RotatedUI() {
    super("RotatedUI");
    // вихід при закриванні вікна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // додаємо особливу панель
    RotatingPanel rp = new RotatingPanel();
    add(rp);
    // добавляємо в панель компоненти
    rp.add(new JButton("Привіт!"));
    rp.add(new JTextField(20));
    // встановлюємо свій RepaintManager
    RepaintManager.setCurrentManager(
        new RotatingRepaintManager());
    // виводимо вікно на екран
    setSize(200, 300);
    setVisible(true);
  }
  // компонент, який повертає всіх своїх нащадків
  class RotatingPanel extends JPanel {
    // відповідає за промальовку нащадків
    protected void paintChildren(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      g2.translate(50, 200);
      // поворот на 45 градусів
      g2.rotate(-Math.PI/4);
      // невелике розтягнення
      g2.shear(-0.1, -0.1);
      // звичайне малювання предків
      super.paintChildren(g);
    }
  }
  // особливий тип RepaintManager
  class RotatingRepaintManager extends RepaintManager {
    // всі запити на перемальовку потрапляють сюди
    public void addDirtyRegion(JComponent c,
        int x, int y, int w, int h) {
      // шукамо потрібного предка
      Container parent = c;
      while (! (parent instanceof RotatingPanel)) {
        parent = parent.getParent();
        if ( parent == null ) {
          // ми не знайшли нашого предка, відміна
          parent = c;
          break;
        }
      }
      // перемальовуємо весь компонент повністю
      super.addDirtyRegion((JComponent) parent,
          0, 0, parent.getWidth(), parent.getHeight());
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() { new RotatedUI(); } });
  }
}
