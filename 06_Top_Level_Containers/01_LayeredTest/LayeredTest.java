// LayeredTest.java
// Можливості багатошарової панелі
import javax.swing.*;
import java.awt.*;

public class LayeredTest extends JFrame {
  public LayeredTest() {
    super("LayeredTest");
    // вихід при закриванні вікна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // отримуємо багатошарову панель
    JLayeredPane lp = getLayeredPane();
    // три фігури
    Figure fg1 = new Figure(Color.red, 0, "POPUP");
    Figure fg2 = new Figure(Color.blue, 0, "PALETTE1");
    Figure fg3 = new Figure(Color.green, 1, "PALETTE2");
    // розміщення фігур у вікні
    fg1.setBounds(10, 10, 120, 120);
    fg2.setBounds(60, 80, 160, 180);
    fg3.setBounds(90, 15, 250, 180);
    // додаємо у різні шари
    lp.add(fg1, JLayeredPane.POPUP_LAYER);
    lp.add(fg2, JLayeredPane.PALETTE_LAYER);
    lp.add(fg3, JLayeredPane.PALETTE_LAYER);
    // зміна позиції однієї з фігур
    lp.setPosition(fg3, 0);
    // виводимо вікно на екран
    setSize(300, 200);
    setVisible(true);
  }
  // клас, дозволяючий малювати два типи фігур з текстом
  class Figure extends JComponent {
    private Color color;
    private int type;
    private String text;
    // параметри: колір та тип фігури
    Figure(Color color, int type, String text) {
      this.color = color;
      this.type = type;
      this.text = text;
      setOpaque(false);
    }
    public void paintComponent(Graphics g) {
      // промальовка фігур
      g.setColor(color);
      switch (type) {
        case 0: g.fillOval(0, 0, 90, 90); break;
        case 1: g.fillRect(0, 0, 130, 80); break;
      }
      g.setColor(Color.white);
      g.drawString(text, 10, 35);
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new LayeredTest(); } });
  }
}
