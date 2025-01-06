// ProgressBarTricks.java
// Невеликі хитрощі індикаторів прогресу
import javax.swing.*;
import java.awt.*;

public class ProgressBarTricks extends JFrame {
  // максимальне значення індикатора
  private final int MAX = 100;
  public ProgressBarTricks() {
    super("ProgressBarTricks");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // налаштуємо параметри для UI-представників
    UIManager.put("ProgressBar.cellSpacing", 2);
    UIManager.put("ProgressBar.cellLength", 6);
    // стандартна модель
    final DefaultBoundedRangeModel model =
        new DefaultBoundedRangeModel(0, 0, 0, MAX);
    // створимо простий індикатор процесу
    // на основі отриманої моделі
    JProgressBar progress = new JProgressBar(model);
    // додамо його у вікно
    setLayout(new FlowLayout());
    add(progress);
    // виводимо вікно на екран
    setSize(300, 200);
    setVisible(true);
    // створимо "процес"
    Thread process = new Thread(new Runnable() {
      public void run() {
        // збільшуємо поточне значення модели до
        // досягнення максимального значення
        int value = 0;
        while ( ++value <= MAX ) {
          final int passValue = value;
          SwingUtilities.invokeLater(
              new Runnable() {
                public void run() {
                  model.setValue(passValue); }});
          try {
            Thread.sleep(200);
          } catch (Exception ex) { }
        }
      }
    });
    // запускаємо потік
    process.start();
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ProgressBarTricks(); } });
  }
}
