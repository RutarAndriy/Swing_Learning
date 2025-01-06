// HeadersAndCorners.java
// Заголовки та "кутники" панелі прокручування JScrollPane
import javax.swing.*;
import java.awt.*;

public class HeadersAndCorners extends JFrame {
  // напис із великим зображенням
  private JLabel label = new JLabel(
      new ImageIcon("Image.jpg"));
  public HeadersAndCorners() {
    super("HeadersAndCorners");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо панель прокрутки
    JScrollPane scroll = new JScrollPane(label);
    // встановлюємо заголовки
    scroll.setColumnHeaderView(new XHeader());
    scroll.setRowHeaderView(new YHeader());
    // встановлюємо лівий верхній "кутник"
    scroll.setCorner(JScrollPane.UPPER_LEFT_CORNER,
        new JButton(new ImageIcon("Print16.gif")));
    // виводимо вікно на екран
    add(scroll);
    setSize(400, 300);
    setVisible(true);
  }
  // заголовок по осі X
  class XHeader extends JPanel {
    // розмір заголовку
    public Dimension getPreferredSize() {
      return new Dimension(
          label.getPreferredSize().width, 20);
    }
    // промальовуємо лінійку
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      int width = getWidth();
      for (int i=0; i<width; i+=50) {
        g.drawString("" + i, i, 15);
      }
    }
  }
  // заголовок по осі  Y
  class YHeader extends JPanel {
    // розмір заголовку
    public Dimension getPreferredSize() {
      return new Dimension(
          20, label.getPreferredSize().height);
    }
    // промальовуємо лінійку
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      int height = getHeight();
      for (int i=0; i<height; i+=50) {
        g.drawString("" + i, 0, i);
      }
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new HeadersAndCorners(); } });
  }
}
