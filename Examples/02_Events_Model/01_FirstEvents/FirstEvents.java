// FirstEvents.java
// Події - натискання клавіш на клавіатурі
import javax.swing.*;
import java.awt.event.*;

public class FirstEvents extends JFrame {
  public FirstEvents() {
    super("FirstEvents");
    // при закритті вікна - вихід
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // реєструємо нового прослуховувача
    addKeyListener(new KeyL());
    // виводимо вікно на екран
    setSize(200, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new FirstEvents();
          }
        });
  }
}

// цей клас буде отримувати сповіщення про події
class KeyL implements KeyListener {
  // друкування символа
  public void keyTyped(KeyEvent k) {
    System.out.println(k);
  }

  // натискання клавіші
  public void keyPressed(KeyEvent k) {
    System.out.println(k);
  }

  // відпускання натиснутої клавіші
  public void keyReleased(KeyEvent k) {
    System.out.println(k);
  }
}
