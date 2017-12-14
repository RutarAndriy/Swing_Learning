// SwingPainting.java
// ������ �������� ���������� Swing

import javax.swing.*;
import java.awt.*;

public class SwingPainting extends JFrame {

  public SwingPainting() {
    super("SwingPainting");
    // ��� �������� ���� ��������� ������
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ��������� � ������ ����������� ��� ���������
    getContentPane().add(new SwingComponent());
    // ������� ���� �� �����
    setSize(200, 200);
    setVisible(true);
  }

  // ���������, ������������ ����������� Swing
  class SwingComponent extends JComponent {
    // ���������� ����������
    public void paintComponent(Graphics g) {
      System.out.println("paintComponent");
      super.paintComponent(g);
      g.setColor(Color.red);
      g.fillOval(10, 10, 50, 50);
    }

    // ���������� �����
    public void paintBorder(Graphics g) {
      System.out.println("paintBorder");
      super.paintBorder(g);
    }

    // ���������� ��������
    public void paintChildren(Graphics g) {
      System.out.println("paintChildren");
      super.paintChildren(g);
    }
  }

  public static void main(String[] args) {
    new SwingPainting();
  }
}
