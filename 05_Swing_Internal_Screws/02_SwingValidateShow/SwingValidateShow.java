// SwingValidateShow.java
// Валідація Swing - більшість компонентів
// потурбуються про себе самі. В іншому метож revalidate()
// позволяє не задумуватися про деталі
import javax.swing.*;

public class SwingValidateShow extends JFrame {
  private static JButton button, newButton;

  public SwingValidateShow() {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(400, 300);
    JPanel contents = new JPanel();
    button = new JButton("Текст");
    JButton button2 = new JButton("Текст 2");
    contents.add(button);
    contents.add(button2);
    add(contents);
  }

  public static void main(String[] args)
      throws InterruptedException {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new SwingValidateShow().setVisible(true);
      }
    });
    Thread.sleep(2000);
    // Кнопка при зміні мараметра сама викличе
    // revalidate() і ми зразу побачимо зміни
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        button.setText("Дуже довгий текст");
      }
    });
    // при додаванні в контейнер revalidate()
    // автоматично не викличеться
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        newButton = new JButton("Новачок");
        button.getParent().add(newButton);
      }
    });
    Thread.sleep(2000);
    // revalidate() может бути викиканий із будь-якого потоку
    newButton.revalidate();
  }
}
