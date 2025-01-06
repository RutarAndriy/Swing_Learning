// SliderDefaultModel.java
// Використання в повзунках стандартної моделі
import javax.swing.*;
import java.awt.*;

public class SliderDefaultModel extends JFrame {
  // наша модель
  private BoundedRangeModel model;
  public SliderDefaultModel() {
    super("SliderDefaultModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створимо модель і пару повзунків
    model = new DefaultBoundedRangeModel(10, 10, 0, 100);
    JSlider slider1 = new JSlider(model);
    JSlider slider2 = new JSlider(JSlider.VERTICAL);
    slider2.setModel(model);
    // додамо повзунок у вікно
    setLayout(new FlowLayout());
    add(slider1);
    add(slider2);
    // виводимо вікно на екран
    setSize(300, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SliderDefaultModel(); } });
  }
}
