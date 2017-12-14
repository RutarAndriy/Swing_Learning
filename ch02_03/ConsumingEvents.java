// ConsumingEvents.java
// ���������� �������

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConsumingEvents extends JFrame {
  public ConsumingEvents() {
    super("ConsumingEvents");
    // ��� �������� ���� - �����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ���������, ����������� ��������� ��������
    KeyListener kl = new KeyAdapter() {
      @Override
      public void keyTyped(KeyEvent e) {
        e.consume();
      }
    };
    // ��������� ��������� ����
    setLayout(new FlowLayout());
    JTextField swingField = new JTextField(10);
    swingField.addKeyListener(kl);
    add(swingField);
    TextField awtField = new TextField(10);
    add(awtField);
    awtField.addKeyListener(kl);
    // ������
    JButton button = new JButton("�����!");
    add(button);
    // ��������� �������� ��������� ������� �� ����
    button.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        e.consume();
      }
    });
    // ������� ���� �� �����
    setSize(300, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new ConsumingEvents();
          }
        });
  }
}
