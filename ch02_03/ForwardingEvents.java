// ForwardingEvents.java
// ������� ��������������� �������

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ForwardingEvents extends JFrame {
  public ForwardingEvents() {
    super("ForwardingEvents");
    // ��� �������� ���� - �����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ���������������� ������������
    getContentPane().setLayout(new FlowLayout());
    // ������� ���� ������
    button1 = new JButton("��");
    button2 = new JButton("������");
    getContentPane().add(button1);
    getContentPane().add(button2);
    // ����� ������� �� ��������� ������
    Forwarder forwarder = new Forwarder();
    button1.addActionListener(forwarder);
    button2.addActionListener(forwarder);
    // ������� ���� �� �����
    pack();
    setVisible(true);
  }

  JButton button1, button2;

  // ����� - ��������� ������� �� ������
  class Forwarder implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      // ��������� ������� �� �������
      if (e.getSource() == button1) onOK(e);
      if (e.getSource() == button2) onCancel(e);
    }
  }

  // ��������� ������� �� ������ "��"
  public void onOK(ActionEvent e) {
    System.out.println("onOK()");
  }

  // ��������� ������� �� ������ "������"
  public void onCancel(ActionEvent e) {
    System.out.println("onCancel()");
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new ForwardingEvents();
          }
        });
  }
}
