// MigLayoutStart.java
// ���������� � MigLayout
import net.miginfocom.swing.MigLayout;
import javax.swing.*;

public class MigLayoutStart extends JFrame {
  public MigLayoutStart() {
    super("MigLayoutStart");
    // ����� ��� �������� ����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������������� �������� ������������
    setLayout(new MigLayout());
    // ��������� ���������� � ��������� �����
    add(new JLabel("���:"), "gap, sg 1");
    add(new JTextField(10), "wrap");
    add(new JLabel("�������:"), "gap, sg 1");
    add(new JTextField(10), "wrap");
    // ������� ���� �� �����
    pack();
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new MigLayoutStart(); } });
  }
}