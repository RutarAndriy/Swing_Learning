// ShapedWindows.java
// �������������� ���� ������������ ����
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.geom.RoundRectangle2D;

public class ShapedWindows extends JFrame {
  public ShapedWindows() {
    super("ShapedWindows");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������ ����
    setSize(300, 200);
    // ��������� ����������� � ���
    setLayout(new FlowLayout());
    add(new JLabel("�����:"));
    add(new JTextField(15));
    // ������ �������� �����
    RoundRectangle2D.Float roundedShape =
        new RoundRectangle2D.Float(0, 0, 300, 200, 70, 70);
    setShape(roundedShape);
    // ������ ������������
    setOpacity(0.7f);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new ShapedWindows();
        
      }
    });
  }
}