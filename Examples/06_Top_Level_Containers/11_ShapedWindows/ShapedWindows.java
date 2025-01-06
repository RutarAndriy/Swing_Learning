// ShapedWindows.java
// Напівпрозорі вікна довільних форм
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.geom.RoundRectangle2D;

public class ShapedWindows extends JFrame {
  public ShapedWindows() {
    super("ShapedWindows");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // розмір вікна
    setSize(300, 200);
    // декілька компонентів у ряд
    setLayout(new FlowLayout());
    add(new JLabel("Текст:"));
    add(new JTextField(15));
    // задаємо округлену форму
    RoundRectangle2D.Float roundedShape =
        new RoundRectangle2D.Float(0, 0, 300, 200, 70, 70);
    setShape(roundedShape);
    // задаємо прозорість
    setOpacity(0.7f);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new ShapedWindows();
      }
    });
  }
}
