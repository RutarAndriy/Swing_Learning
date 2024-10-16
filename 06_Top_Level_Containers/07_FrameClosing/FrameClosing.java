// FrameClosing.java
// Використання вікна з рамкою
import javax.swing.*;

public class FrameClosing extends JFrame {
  public FrameClosing() {
    super("Заголовок Вікна");
    // дія при закриванні вікна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // значок для вікна
    setIconImage(getToolkit().getImage("Icon.gif"));
    // вивід на екран
    setSize(300, 100);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new FrameClosing(); } });
  }
}
