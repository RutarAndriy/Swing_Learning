// UsingSpinnerModels.java
// Використання стандартних моделей лічильника
import javax.swing.*;
import java.awt.*;

public class UsingSpinnerModels extends JFrame {
  // набір даних для лічильника
  private String[] data = {
    "Холодно", "Прохолодно", "Тепло", "Гаряче"
  };
  public UsingSpinnerModels() {
    super("UsingSpinnerModels");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // модель лічильника для вибору із набору даних
    SpinnerModel list = new SpinnerListModel(data);
    JSpinner spinner1 = new JSpinner(list);
    // модель лічильника для вибору цілих чисел
    SpinnerModel numbers = new SpinnerNumberModel(
      4, 0, 100, 1);
    JSpinner spinner2 = new JSpinner(numbers);
    // додамо лічильники до панелі вмісту
    setLayout(new FlowLayout());
    add(spinner1);
    add(spinner2);
    // виводимо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingSpinnerModels(); } });
  }
}
