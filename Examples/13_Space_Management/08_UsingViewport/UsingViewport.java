// UsingViewport.java
// Робота з "відеошукачем" JViewport
import javax.swing.*;
import java.awt.*;

public class UsingViewport extends JFrame {
  public UsingViewport() {
    super("UsingViewport");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // напис із текстом великого розміру
    JLabel bigLabel = new JLabel(
        "<html><h1>Великий напис!<br>Багато тексту!");
    // "відеошукач"
    JViewport viewport = new JViewport();
    // задаємо вид та видимий діапазон
    viewport.setView(bigLabel);
    viewport.setExtentSize(new Dimension(100, 60));
    // точка початку видимої області
    viewport.setViewPosition(new Point(50, 50));
    // обмежимо розмір "відеошукача"
    viewport.setPreferredSize(new Dimension(100, 60));
    // виводимо вікно на екран
    setLayout(new FlowLayout());
    add(viewport);
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingViewport(); } });
  }
}
