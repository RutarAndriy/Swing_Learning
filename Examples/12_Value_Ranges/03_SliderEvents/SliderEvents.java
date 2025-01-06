// SliderEvents.java
// Події повзунків
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class SliderEvents extends JFrame {
  public SliderEvents() {
    super("SliderEvents");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // створюємо повзунок і написи
    JSlider slider = new JSlider(0, 900, 0);
    slider.setMajorTickSpacing(100);
    slider.setPaintTicks(true);
    boost = new JLabel("Прискорення: ");
    // приєднюємо прослуховувача
    slider.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        // змінюємо напис
        int value =
            ((JSlider)e.getSource()).getValue();
        int percent = value/15;
        boost.setText("Прискорення: " + percent + " %");
      }
    });
    // додаємо компоненти в панель
    JPanel contents = new JPanel();
    contents.add(new JLabel("Розмір буфера:"));
    contents.add(slider);
    add(contents);
    add(boost, "South");
    // виводимо вікно на екран
    setSize(360, 100);
    setVisible(true);
  }
  private JLabel boost;
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SliderEvents(); } });
  }
}
