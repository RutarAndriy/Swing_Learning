// SimpleScrollPanes.java
// Налащтування деяких простих властивостей панелі прокрутки
import javax.swing.*;
import java.awt.*;

public class SimpleScrollPanes extends JFrame {
  public SimpleScrollPanes() {
    super("SimpleScrollPanes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // напис
    JLabel label = new JLabel(new ImageIcon("Image.jpg"));
    // особливий конструктор панелі прокрутки
    JScrollPane scrollPane = new JScrollPane(label,
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    // деякі властивості
    scrollPane.setViewportBorder(
        BorderFactory.createLineBorder(Color.BLUE));
    scrollPane.setWheelScrollingEnabled(false);
    // виводимо вікно на екран
    add(scrollPane);
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleScrollPanes(); } });
  }
}
