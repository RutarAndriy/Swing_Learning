// PaintingOtherComponents.java
// ���������� ������ ����������� ��� �����������
import javax.swing.*;
import java.awt.*;

public class PaintingOtherComponents extends JFrame {
  public PaintingOtherComponents() {
    super("PaintingOtherComponents");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(new CustomPaintComponent());
    setSize(400, 300);
    setVisible(true);
  }
  class CustomPaintComponent extends JPanel {
    // ������ ��� ����������
    private JButton button = new JButton("������!");
    // ����� ��� ��������� � Swing
    protected void paintComponent(Graphics g) {
      // ���������� ������� ��� ��������� �������� opaque
      super.paintComponent(g);
      // ������ ������
      Graphics2D g2 = (Graphics2D) g;
      button.setSize(80, 30);
      // ���������� ������� ����������� - �� ������ �����
      button.setDoubleBuffered(false);
      // ���������� ������� ���������
      g2.translate(100, 100);
      for (int i=1; i<=8; i++) {
        // �������� ������ �� �����
        g2.rotate(2*Math.PI / i);
        button.paint(g);
      }
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() { new PaintingOtherComponents(); } });
  }
}
