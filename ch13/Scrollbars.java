// Scrollbars.java
// ������ ��������� JScrollBar
import javax.swing.*;
import java.awt.*;

public class Scrollbars extends JFrame {
  public Scrollbars() {
    super("Scrollbars");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ����������� ������
    BoundedRangeModel model =
        new DefaultBoundedRangeModel(10, 40, 0, 100);
    // ���� ����� ���������
    JScrollBar scrollbar1 = new JScrollBar(
        JScrollBar.HORIZONTAL);
    JScrollBar scrollbar2 = new JScrollBar(
        JScrollBar.VERTICAL);
    // ������������ ������
    scrollbar1.setModel(model);
    scrollbar2.setModel(model);
    // ��������� ���������� � ������
    add(scrollbar1, "South");
    add(scrollbar2, "East");
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new Scrollbars(); } });
  }
}
