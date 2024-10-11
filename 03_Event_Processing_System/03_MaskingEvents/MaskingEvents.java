// MaskingEvents.java
// Маскування подій

import java.awt.*;
import javax.swing.*;

public class MaskingEvents extends JFrame {
  public MaskingEvents() {
    super("MaskingEvents");
    // при закритті вікна - вихід
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // відключаємо події від вікна
    // це код не працює - функцію викмнули із міркувань безпеки
    disableEvents(AWTEvent.WINDOW_EVENT_MASK);
    // додамо особливу кнопку
    JPanel contents = new JPanel();
    contents.add(new CustomButton("Привіт!"));
    setContentPane(contents);
    // виведемо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }

  // особлива кнопка
  class CustomButton extends JButton {
    public CustomButton(String label) {
      super(label);
      // вимикаємо події з клавіатури та миші
      // цей код також не працює - кнопка має внутрішнього прослуховувача
      disableEvents(AWTEvent.KEY_EVENT_MASK);
      disableEvents(AWTEvent.MOUSE_EVENT_MASK);
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new MaskingEvents();
          }
        });
  }
}
