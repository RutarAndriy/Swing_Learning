// JXLayerTest.java
// ������ ������������� ����� JXLayer
import org.jdesktop.jxlayer.JXLayer;
import org.jdesktop.jxlayer.plaf.BufferedLayerUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class JXLayerTest extends JFrame {
  public JXLayerTest() {
    super("JXLayerTest");
    // ����� ��� �������� ����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // �������� ������� ����������
    JPanel p = new JPanel();
    p.add(new JTextField(10));
    p.add(new JButton("��"));
    // �������� ���������� � ����
    JXLayer<JPanel> layer = new JXLayer<JPanel>(p);
    // �������� ���� ����������� �� �������
    layer.setUI(new BufferedLayerUI<JPanel>() {
      private int lastX, lastY;
      // ���������� ����
      public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        g.setColor(Color.RED);
        g.fillOval(lastX, lastY, 15, 15);
      }
      // ��������� ������� � �������� ����
      protected void processMouseMotionEvent(MouseEvent e,
               JXLayer<? extends JPanel> layer) {
        lastX = SwingUtilities.convertMouseEvent(
            (Component) e.getSource(), e, layer).getX();
        lastY = SwingUtilities.convertMouseEvent(
            (Component) e.getSource(), e, layer).getY();
        repaint();
      }
    });
    // JXLayer ���������� ��������� � ���������
    add(layer);
    // ������� ���� �� �����
    setSize(400, 150);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new JXLayerTest(); } });
  }
}