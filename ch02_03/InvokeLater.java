// InvokeLater.java
// ����� invokeLater() � ������ � ������� �������� �������

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InvokeLater extends JFrame {
  public InvokeLater() {
    super("InvokeLater");
    // ��� �������� ���� - �����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������ �� ����������
    button = new JButton("��������� ������� ������");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // �������� ��������� �����
        new ComplexJobThread().start();
        button.setText("���������...");
      }
    });
    // �������� ������ ����������� � ������� ���� �� �����
    setLayout(new FlowLayout());
    add(new JTextField(20));
    add(button);
    setSize(300, 200);
    setVisible(true);
  }

  private JButton button;

  // �����, ����������� "������� ������"
  class ComplexJobThread extends Thread {
    public void run() {
      try {
        // ��������� ��������
        sleep(3000);
        // ������ ���������, ����� �������� ���������
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            button.setText("������ ���������");
          }
        });
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new UsingSwingWorker();
          }
        });
  }
}
