// UsingBorderFactory.java
// Фабрика рамок BorderFactory
import javax.swing.*;

public class UsingBorderFactory extends JFrame {
  public UsingBorderFactory() {
    super("UsingBorderFactory");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // рамка для панелі вмісту
    JPanel cp = (JPanel)getContentPane();
    cp.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createRaisedBevelBorder(),
        "Зроблено на фариці рамок"));
    // виводимо вікно на екран
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingBorderFactory(); } });
  }
}
