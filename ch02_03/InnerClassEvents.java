// InnerClassEvents.java
// ���������� ������ ��� ��������� �������

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InnerClassEvents extends JFrame {
  private JTextField text;
  private JButton button;

  public InnerClassEvents() {
    super("InnerClassEvents");
    // ��� �������� ���� - �����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ���������������� ������������
    setLayout(new FlowLayout());
    // ������� ��������� ����
    add(text = new JTextField(10));
    // � ������
    add(button = new JButton("�������"));
    // ����� ������� �� ��������� ������
    button.addActionListener(new ButtonL());
    // ������� ���� �� �����
    pack();
    setVisible(true);
  }

  // ����� - ��������� ������� �� ������
  class ButtonL implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      System.out.println(text.getText());
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new InnerClassEvents();
          }
        });
  }
}
