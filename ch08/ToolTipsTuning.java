// ToolTipsTuning.java
// ��������� ���������
import javax.swing.*;

public class ToolTipsTuning extends JFrame {
  public ToolTipsTuning() {
    super("ToolTipsTuning");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������ � �����������
    JPanel contents = new JPanel();
    JButton b1 = new JButton("������");
    b1.setToolTipText("��������� ��� ������");
    JButton b2 = new JButton("������");
    b2.setToolTipText("��������� ��� ������");
    contents.add(b1);
    contents.add(b2);
    // ��������� ���������
    ToolTipManager ttm =
        ToolTipManager.sharedInstance();
    ttm.setLightWeightPopupEnabled(false);
    ttm.setInitialDelay(1000);
    ttm.setDismissDelay(500);
    ttm.setReshowDelay(1000);
    // ������� ���� �� �����
    add(contents);
    setSize(200, 100);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ToolTipsTuning(); } });
  }
}
