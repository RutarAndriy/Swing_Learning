// FloatingWindow.java
// ���� ��� �����, ������ ����������
// ���� ��������� ���� ����������
import javax.swing.*;

public class FloatingWindow extends JFrame {
  public FloatingWindow() {
    super("FloatingWindow");
    // ����� ��� �������� ����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
    // ������� ��������� ����
    JWindow window = new JWindow(this);
    // ������ ��� ������� ������
    window.setAlwaysOnTop(true);
    window.setType(Type.UTILITY);
    // ������� ���� �� �����
    window.setSize(100, 300);
    window.setVisible(true);

  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
      new Runnable() {
        public void run() { new FloatingWindow(); } });
  }
}