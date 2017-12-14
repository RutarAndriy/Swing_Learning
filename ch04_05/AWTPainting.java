// AWTPainting.java
// ������� ��������� � AWT ����� �����

import java.awt.*;
import java.awt.event.*;

public class AWTPainting extends Frame {

  public AWTPainting() {
    super("AWTPainting");
    // ����� ��� �������� ����
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    setLayout(new FlowLayout());
    // ��������� ��������� ����� ������
    add(new Button("���������� ������!") {
      public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(2, 2, getWidth() - 5, getHeight() - 5);
      }
    });
    setSize(200, 200);
  }

  // � ���� ������ ������������ ���������
  public void paint(Graphics g) {
    // ��������� ��� ������� ������
    g.setColor(Color.RED);
    g.fillRect(0, 0, getWidth(), getHeight());
  }

  public static void main(String[] args) {
    new AWTPainting().setVisible(true);
  }
}
