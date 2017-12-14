// FocusKeysTest.java
// ��������� ������ �������� ������ �����
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashSet;

public class FocusKeysTest extends JFrame {
  public FocusKeysTest() {
    super("FocusKeysTest");
    // ����� ��� �������� ����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ��������� ���� ������
    setLayout(new FlowLayout());
    // ������ ������
    JButton button = new JButton("������");
    add(button);
    add(new JButton("�������"));
    // �������� ������� �������� ������
    HashSet<AWTKeyStroke> set = new HashSet<AWTKeyStroke>();
    set.add(AWTKeyStroke.getAWTKeyStroke(
        'Q', KeyEvent.CTRL_MASK));
    button.setFocusTraversalKeys(
        KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, set);
    // ������� ���� �� �����
    setSize(200, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new FocusKeysTest(); } });
  }
}
