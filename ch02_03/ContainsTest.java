// ContainsTest.java
// ��������� ��������� ���� � ����� contains()

import javax.swing.*;
import java.awt.*;

public class ContainsTest extends JFrame {
  public ContainsTest() {
    super("ContainsTest");
    // ��� �������� ���� - �����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������ � ������������� �����
    JButton button = new JButton("��������") {
      @Override
      public boolean contains(int x, int y) {
        // �� �������� �� ����� �����
        return false;
      }
    };
    // �������� ������ ����������� � ������� ���� �� �����
    setLayout(new FlowLayout());
    add(button);
    setSize(300, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new ContainsTest();
          }
        });
  }
}