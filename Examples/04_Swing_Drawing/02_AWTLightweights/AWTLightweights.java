// AWTLightweights.java
// Використання легких компонентів в AWT
import java.awt.*;
import java.awt.event.*;

public class AWTLightweights extends Frame {

  public AWTLightweights() {
    super("AWTLightweights");
    // при закриванні вікна програма завершується
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    // додаємо декілька легких компонентів
    LightweightRect rect1 =
        new LightweightRect(Color.BLUE, true);
    LightweightRect rect2 =
        new LightweightRect(Color.RED, true);
    LightweightRect transparentRect =
        new LightweightRect(Color.BLACK, false);
    // вкажемо координати вручну, щоб
    // компоненти перекривалися
    setLayout(null);
    rect1.setBounds(40, 40, 100, 100);
    rect2.setBounds(50, 50, 100, 100);
    transparentRect.setBounds(35, 35, 150, 150);
    add(transparentRect);
    add(rect1);
    add(rect2);
    // останнім добаємо важкий компонент
    Button button = new Button("Важка!");
    button.setBounds(50, 175, 80, 30);
    add(button);
    // выводим окно на экран
    setSize(250, 250);
    setVisible(true);
  }

  // легкий компонент - кольоровий прямокутник
  class LightweightRect extends Component {
    private Color color;
    private boolean fill;

    // параметри - колір і чи потрібно замальовувати всю область
    public LightweightRect(Color color, boolean fill) {
      this.color = color;
      this.fill = fill;
    }
    public void paint(Graphics g) {
      g.setColor(color);
      if (fill)
        g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
      else
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }
  }

  public static void main(String[] args) {
    new AWTLightweights();
  }
}
