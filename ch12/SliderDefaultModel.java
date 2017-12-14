// SliderDefaultModel.java
// ������������� � ��������� ����������� ������
import javax.swing.*;
import java.awt.*;

public class SliderDefaultModel extends JFrame {
  // ���� ������
  private BoundedRangeModel model;
  public SliderDefaultModel() {
    super("SliderDefaultModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // �������� ������ � ���� ���������
    model = new DefaultBoundedRangeModel(10, 10, 0, 100);
    JSlider slider1 = new JSlider(model);
    JSlider slider2 = new JSlider(JSlider.VERTICAL);
    slider2.setModel(model);
    // ��������� �������� � ����
    setLayout(new FlowLayout());
    add(slider1);
    add(slider2);
    // ������� ���� �� �����
    setSize(300, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SliderDefaultModel(); } });
  }
}
