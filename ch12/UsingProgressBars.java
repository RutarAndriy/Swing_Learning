// UsingProgressBars.java
// ������������� �������� ������������ 
// ���������� JProgressBar
import javax.swing.*;
import java.awt.*;

public class UsingProgressBars extends JFrame {
  // ������������ �������� (100%)
  private int MAX = 100;
  // ����� ������������ ����� ������
  private BoundedRangeModel model;
  public UsingProgressBars() {
    super("UsingProgressBars");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ����������� ������
    model = new DefaultBoundedRangeModel(5, 0, 0, MAX);
    // �������������� ���������
    JProgressBar progress1 = new JProgressBar(model);
    progress1.setStringPainted(true);
    // ������������ ���������
    JProgressBar progress2 =
        new JProgressBar(JProgressBar.VERTICAL);
    progress2.setModel(model);
    progress2.setStringPainted(true);
    progress2.setString("������� ��������...");
    // ��������� ���������� � ����
    setLayout(new FlowLayout());
    add(progress1);
    add(progress2);
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
    // ��������� "�������"
    new LongProcess().execute();
  }
  // �������� ������� ��������
  class LongProcess extends SwingWorker<String,Integer> {
    // �������� �� ���������� ��������
    protected String doInBackground() throws Exception {
      int current = 5;
      while ( current <= MAX ) {
        // ��������� ������� ���
        publish(current++);
        // ��������� ��������
        Thread.sleep((int)(Math.random()*1000));
      }
      return "������";
    }
    // ����������� � ������ �������� �������
    public void process(java.util.List<Integer> chunks) {
      // ����������� ������� ��������
      model.setValue(chunks.get(0));
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingProgressBars(); } });
  }
}