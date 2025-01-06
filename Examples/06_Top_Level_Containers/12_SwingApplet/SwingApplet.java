// SwingApplet.java
// Простий аплет з використанням Swing
import javax.swing.*;
import java.awt.*;

public class SwingApplet extends JApplet {
  // цей метод викликається при створенні аплета
  @Override
  public void init() {
    // створення інтерфейсу
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            JPanel contents = new JPanel();
            contents.add(new JTextField(10));
            contents.add(new JButton("Ввід"));
            setContentPane(contents);
        }});
  }
}
