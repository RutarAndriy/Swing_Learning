// SliderEvents.java
// ������� ���������
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class SliderEvents extends JFrame {
  public SliderEvents() {
    super("SliderEvents");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // ������� �������� � �������
    JSlider slider = new JSlider(0, 900, 0);
    slider.setMajorTickSpacing(100);
    slider.setPaintTicks(true);
    boost = new JLabel("���������: ");
    // ������������ ���������
    slider.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        // ������ �������
        int value =
            ((JSlider)e.getSource()).getValue();
        int percent = value/15;
        boost.setText("���������: " + percent + " %");
      }
    });
    // ��������� ���������� � ������
    JPanel contents = new JPanel();
    contents.add(new JLabel("������ ������:"));
    contents.add(slider);
    add(contents);
    add(boost, "South");
    // ������� ���� �� �����
    setSize(360, 100);
    setVisible(true);
  }
  private JLabel boost;
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SliderEvents(); } });
  }
}