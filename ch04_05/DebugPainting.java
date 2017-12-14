// DebugPainting.java
// ������������ ������������ ������� ������� � Swing
import java.awt.*;
import javax.swing.*;

public class DebugPainting extends JFrame {
  public DebugPainting() {
    super("DebugPainting");
    // ����� ��� �������� ����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ��������� �������� ���������
    PaintingComponent pc = new PaintingComponent();
    add(pc);
    // �������� ��� ���� ������� �������
    RepaintManager.currentManager(pc).
        setDoubleBufferingEnabled(false);
    pc.setDebugGraphicsOptions(DebugGraphics.LOG_OPTION
        | DebugGraphics.FLASH_OPTION);
    DebugGraphics.setFlashTime(50);
    DebugGraphics.setFlashCount(3);
    // ������� ���� �� �����
    setSize(200, 200);
    setVisible(true);
  }

  // ���������, ������� ���-�� ������
  class PaintingComponent extends JPanel {
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      // ��� ������� ������
      g.setColor(Color.orange);
      g.fillRect(10, 10, 100, 100);
      g.setColor(Color.green);
      g.drawOval(50, 50, 50, 50);
      g.setColor(Color.blue);
      g.fillOval(100, 20, 50, 50);
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() { new DebugPainting(); } });
  }
}
