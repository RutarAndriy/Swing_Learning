// WindowDecorations.java
// Спеціальне оформлення вікон Swing
import javax.swing.*;

public class WindowDecorations {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            // включимо декорації для вікон
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            // вікно з рамкою
            JFrame frame = new JFrame("Вікно з рамкою");
            frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
            frame.setSize(200, 200);
            frame.setVisible(true);
            // діалогове вікно
            JDialog dialog = new JDialog(frame, "Діалог");
            dialog.setDefaultCloseOperation(
                JDialog.DISPOSE_ON_CLOSE);
            dialog.setSize(150, 100);
            // так можна задавати тип оформлення вікна
            dialog.getRootPane().setWindowDecorationStyle(
                JRootPane.INFORMATION_DIALOG);
            dialog.setVisible(true);
          }
        });
  }
}
