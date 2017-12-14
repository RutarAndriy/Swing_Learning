// ProgressBarTricks.java
// ��������� �������� ����������� ��������
import javax.swing.*;
import java.awt.*;

public class ProgressBarTricks extends JFrame {
  // ������������ �������� ����������
  private final int MAX = 100;
  public ProgressBarTricks() {
    super("ProgressBarTricks");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // �������� ��������� ��� UI-��������������
    UIManager.put("ProgressBar.cellSpacing", 2);
    UIManager.put("ProgressBar.cellLength", 6);
    // ����������� ������
    final DefaultBoundedRangeModel model =
        new DefaultBoundedRangeModel(0, 0, 0, MAX);
    // �������� ������� ��������� ��������
    // �� ������ ���������� ������
    JProgressBar progress = new JProgressBar(model);
    // ������� ��� � ����
    setLayout(new FlowLayout());
    add(progress);
    // ������� ���� �� �����
    setSize(300, 200);
    setVisible(true);
    // �������� "�������"
    Thread process = new Thread(new Runnable() {
      public void run() {
        // ����������� ������� �������� ������ ��
        // ���������� ������������� ��������
        int value = 0;
        while ( ++value <= MAX ) {
          final int passValue = value;
          SwingUtilities.invokeLater(
              new Runnable() {
                public void run() {
                  model.setValue(passValue); }});
          try {
            Thread.sleep(200);
          } catch (Exception ex) { }
        }
      }
    });
    // �������� �����
    process.start();
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ProgressBarTricks(); } });
  }
}
