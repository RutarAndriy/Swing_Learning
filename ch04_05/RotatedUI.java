// RotatedUI.java
// �������� � �������� ����������� �����������
import javax.swing.*;
import java.awt.*;

public class RotatedUI extends JFrame {
  public RotatedUI() {
    super("RotatedUI");
    // ����� ��� �������� ����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ��������� ������ ������
    RotatingPanel rp = new RotatingPanel();
    add(rp);
    // ��������� � ������ ����������
    rp.add(new JButton("������!"));
    rp.add(new JTextField(20));
    // ������������� ���� RepaintManager
    RepaintManager.setCurrentManager(
        new RotatingRepaintManager());
    // ������� ���� �� �����
    setSize(200, 300);
    setVisible(true);
  }
  // ���������, ������� ������������ ���� ��������
  class RotatingPanel extends JPanel {
    // �������� �� ���������� ��������
    protected void paintChildren(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      g2.translate(50, 200);
      // ������� �� 45 ��������
      g2.rotate(-Math.PI/4);
      // ��������� ����������
      g2.shear(-0.1, -0.1);
      // ������� ��������� �������
      super.paintChildren(g);
    }
  }
  // ������ ��� RepaintManager
  class RotatingRepaintManager extends RepaintManager {
    // ��� ������� �� ����������� �������� ����
    public void addDirtyRegion(JComponent c,
        int x, int y, int w, int h) {
      // ���� ������� ������
      Container parent = c;
      while (! (parent instanceof RotatingPanel)) {
        parent = parent.getParent();
        if ( parent == null ) {
          // �� �� ����� ������ ������, �����
          parent = c;
          break;
        }
      }
      // �������������� ���� ��������� ���������
      super.addDirtyRegion((JComponent) parent,
          0, 0, parent.getWidth(), parent.getHeight());
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() { new RotatedUI(); } });
  }
}