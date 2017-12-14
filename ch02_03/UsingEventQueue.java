// UsingEventQueue.java
// ������������� ������� �������

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UsingEventQueue extends JFrame {
  public UsingEventQueue() {
    super("UsingEventQueue");
    // ����� ��� �������� ����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������ � �� ���������
    JButton button = new JButton("������������ �������");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // ���������� ������� �������� ����
        getToolkit().getSystemEventQueue().postEvent(
            new WindowEvent(UsingEventQueue.this,
                WindowEvent.WINDOW_CLOSING));
      }
    });
    // ������� ������ � ������ �����������
    setLayout(new FlowLayout());
    add(button);
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new UsingEventQueue();
          }
        });
  }
}
