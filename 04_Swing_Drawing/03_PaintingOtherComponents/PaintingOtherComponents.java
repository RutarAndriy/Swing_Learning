// PaintingOtherComponents.java
// Промальовування інших компонентів як зображень
import javax.swing.*;
import java.awt.*;

public class PaintingOtherComponents extends JFrame {
  public PaintingOtherComponents() {
    super("PaintingOtherComponents");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(new CustomPaintComponent());
    setSize(400, 300);
    setVisible(true);
  }
  class CustomPaintComponent extends JPanel {
    // кнопка для промальовування
    private JButton button = new MyJButton("Привіт!");
    // метод для малювання в Swing
    protected void paintComponent(Graphics g) {
      // необхідно викликати для обробки властивості opaque
      super.paintComponent(g);
      // малюємо кнопки
      Graphics2D g2 = (Graphics2D) g;
      button.setSize(90, 30);
      // відключення подвійної буферизації - не завжди потрібно
      button.setDoubleBuffered(false);
      // переміщуємо позицію малювання
      g2.translate(100, 100);
      for (int i=1; i<=8; i++) {
        // обертання кнопки по колу
        g2.rotate(2*Math.PI / i);
        button.paint(g);
      }
    }
  }

  class MyJButton extends JButton {
    public MyJButton(String text) {
      super(text);
    }
    protected void paintComponent(Graphics g) {
      // код, який потрібен для правильного
      // промальовування на linux-системах
      g.setClip(0, 0, getWidth(), getHeight());
      super.paintComponent(g);
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() { new PaintingOtherComponents(); } });
  }
}
