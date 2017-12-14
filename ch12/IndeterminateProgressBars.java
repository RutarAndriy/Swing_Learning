// IndeterminateProgressBars.java
// ���������� � ��������� "����������������"
import javax.swing.*;
import java.awt.*;

public class IndeterminateProgressBars extends JFrame {
  public IndeterminateProgressBars() {
    super("IndeterminateProgressBars");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // �������������� ���������
    JProgressBar progress = new JProgressBar(0, 100);
    progress.setIndeterminate(true);
    progress.setStringPainted(true);
    // ��������� ��� � ���� � ������� �� �����
    setLayout(new FlowLayout());
    add(new JLabel("����������:"));
    add(progress);
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new IndeterminateProgressBars(); } });
  }
}
