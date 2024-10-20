// ToolTipsTuning.java
// Налаштування підказок
import javax.swing.*;

public class ToolTipsTuning extends JFrame {
  public ToolTipsTuning() {
    super("ToolTipsTuning");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // додамо кнопки з підказками
    JPanel contents = new JPanel();
    JButton b1 = new JButton("Перша");
    b1.setToolTipText("Підказка для першої");
    JButton b2 = new JButton("Друга");
    b2.setToolTipText("Підказка для другої");
    contents.add(b1);
    contents.add(b2);
    // налаштування підказок
    ToolTipManager ttm =
        ToolTipManager.sharedInstance();
    ttm.setLightWeightPopupEnabled(false);
    ttm.setInitialDelay(1000);
    ttm.setDismissDelay(500);
    ttm.setReshowDelay(1000);
    // виводимо вікно на екран
    add(contents);
    setSize(200, 100);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ToolTipsTuning(); } });
  }
}
