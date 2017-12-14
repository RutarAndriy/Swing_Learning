// FirstEvents.java
// ������� - ������� ������ �� ����������
import javax.swing.*;
import java.awt.event.*;

public class FirstEvents extends JFrame {
  public FirstEvents() {
    super("FirstEvents");
    // ��� �������� ���� - �����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������������ ������ ���������
    addKeyListener(new KeyL());
    // ������� ���� �� �����
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

// ���� ����� ����� �������� ��������� � ��������
class KeyL implements KeyListener {
  // ������ �������
  public void keyTyped(KeyEvent k) {
    System.out.println(k);
  }

  // ������� �������
  public void keyPressed(KeyEvent k) {
    System.out.println(k);
  }

  // ���������� ������� �������
  public void keyReleased(KeyEvent k) {
    System.out.println(k);
  }
}
