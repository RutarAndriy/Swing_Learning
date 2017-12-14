// SimpleButtonTest.java
// ��������� ������� ������ ����������

import javax.swing.*;

import com.porty.swing.*;
import com.porty.swing.event.*;

import java.awt.*;

public class SimpleButtonTest extends JFrame {
  public SimpleButtonTest() {
    super("SimpleButtonTest");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������ � ����������� ����������
    SimpleButton button = new SimpleButton();
    // ��������� �����
    button.addButtonPressListener(
        new ButtonPressListener() {
          public void buttonPressed(ButtonPressEvent e) {
            System.out.println("1!");
          }
        });
    // ���������� �����
    button.addButtonPressListener(new ButtonL());
    // ������� ������ � ����
    JPanel contents = new JPanel();
    contents.add(button);
    setContentPane(contents);
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }

  class ButtonL implements ButtonPressListener {
    public void buttonPressed(ButtonPressEvent e) {
      System.out.println("2!");
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new SimpleButtonTest();
          }
        });
  }
}
