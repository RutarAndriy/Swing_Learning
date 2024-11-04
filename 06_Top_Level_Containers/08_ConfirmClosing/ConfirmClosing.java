// ConfirmClosing.java
// Підтвердження виходу з програми
import javax.swing.*;
import java.awt.event.*;

public class ConfirmClosing extends JFrame {
  public ConfirmClosing() {
    super("ConfirmClosing");
    // відключаємо дію закриття
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    // додаємо прослуховувач подій від вікна
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        // підтвердження виходу
        int res = JOptionPane.
         showConfirmDialog(null, "Справді вийти?");
        if ( res == JOptionPane.YES_OPTION )
         System.exit(0);
      }
      });
    // виводимо вікно на екран
    setSize(200, 100);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new ConfirmClosing(); } });
  }
}
