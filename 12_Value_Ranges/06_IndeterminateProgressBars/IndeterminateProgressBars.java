// IndeterminateProgressBars.java
// Індикатор у стані "невизначеності"
import javax.swing.*;
import java.awt.*;

public class IndeterminateProgressBars extends JFrame {
  public IndeterminateProgressBars() {
    super("IndeterminateProgressBars");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // невизначений індикатор
    JProgressBar progress = new JProgressBar(0, 100);
    progress.setIndeterminate(true);
    progress.setStringPainted(true);
    // додаємо його у вікно та виводимо на екран
    setLayout(new FlowLayout());
    add(new JLabel("З'єднання:"));
    add(progress);
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new IndeterminateProgressBars(); } });
  }
}
