// SliderAdditionalFeatures.java
// �������������� ����������� ���������
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class SliderAdditionalFeatures extends JFrame {
  public SliderAdditionalFeatures() {
    super("SliderAdditionalFeatures");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ���������� ����������� ������
    BoundedRangeModel model =
        new DefaultBoundedRangeModel(10, 0, 0, 60);
    // ������� � ���������
    Dictionary labels = new Hashtable();
    labels.put(0, new JLabel(
        "<html><font color=red size=4>����"));
    labels.put(10, new JLabel(
        "<html><font color=green size=3>��������"));
    labels.put(50, new JLabel(
        "<html><font color=yellow size=5>�����"));
    labels.put(60, new JLabel(
        new ImageIcon("caution.gif")));
    // ��������� ������� ��������
    JSlider slider1 = new JSlider(JSlider.VERTICAL);
    slider1.setModel(model);
    slider1.setLabelTable(labels);
    slider1.setPaintLabels(true);
    // "�����������" ��������������� ��������
    JSlider slider2 = new JSlider(model);
    slider2.putClientProperty(
        "JSlider.isFilled", Boolean.TRUE);
    slider2.setInverted(true);
    slider2.setPaintTicks(true);
    slider2.setMajorTickSpacing(10);
    // ��������� ���������� � ����
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
          public void run() { new SliderAdditionalFeatures(); } });
  }
}