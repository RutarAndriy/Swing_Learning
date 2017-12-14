// FrameClosing.java
// ������������� ���� � ������
import javax.swing.*;

public class FrameClosing extends JFrame {
  public FrameClosing() {
    super("��������� ����");
    // �������� ��� �������� ����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������ ��� ����
    setIconImage(getToolkit().getImage("icon.gif"));
    // ����� �� �����
    setSize(300, 100);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new FrameClosing(); } });
  }
}