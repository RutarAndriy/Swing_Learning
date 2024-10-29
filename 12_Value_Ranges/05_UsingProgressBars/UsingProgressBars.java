// UsingProgressBars.java
// Використання основних можливостей 
// компонента JProgressBar
import javax.swing.*;
import java.awt.*;

public class UsingProgressBars extends JFrame {
  // максимальне значення (100%)
  private int MAX = 100;
  // будемо використовувати спільну модель
  private BoundedRangeModel model;
  public UsingProgressBars() {
    super("UsingProgressBars");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо стандартну модель
    model = new DefaultBoundedRangeModel(5, 0, 0, MAX);
    // горизонтальний індикатор
    JProgressBar progress1 = new JProgressBar(model);
    progress1.setStringPainted(true);
    // вертикальний індикатор
    JProgressBar progress2 =
        new JProgressBar(JProgressBar.VERTICAL);
    progress2.setModel(model);
    progress2.setStringPainted(true);
    progress2.setString("Трохи терпіння...");
    // додаємо індикатори у вікно
    setLayout(new FlowLayout());
    add(progress1);
    add(progress2);
    // виводимо вікно на екран
    setSize(400, 300);
    setVisible(true);
    // запускаємо "процес"
    new LongProcess().execute();
  }
  // емуляція довгого процесу
  class LongProcess extends SwingWorker<String,Integer> {
    // працюємо до завершення процесу
    protected String doInBackground() throws Exception {
      int current = 5;
      while ( current <= MAX ) {
        // оновлюємо зовнішній вигляд
        publish(current++);
        // випадкова затримка
        Thread.sleep((int)(Math.random()*1000));
      }
      return "Готово";
    }
    // виконується у потоці розсилки подій
    public void process(java.util.List<Integer> chunks) {
      // збільшуємо поточне значення
      model.setValue(chunks.get(0));
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingProgressBars(); } });
  }
}
