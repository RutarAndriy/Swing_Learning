// RadioButtons.java
// ������������� ��������������
import javax.swing.*;
import java.awt.*;

public class RadioButtons extends JFrame {
  public RadioButtons() {
    super("RadioButtons");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // ���������� ���������������� ������������
    setLayout(new FlowLayout());
    // ��������� �������������
    JRadioButton r = new JRadioButton("��� �� ����");
    // ������ ��������� �������������� � �����
    // ����������� ������
    JPanel panel = new JPanel(new GridLayout(0, 1, 0, 5));
    panel.setBorder(
        BorderFactory.createTitledBorder("������� ���"));
    ButtonGroup bg = new ButtonGroup();
    String[] names = { "������� ��� Java",
        "MS Windows", "Aqua (Mac)" };
    for (String name : names) {
      JRadioButton radio = new JRadioButton(name);
      panel.add(radio);
      bg.add(radio);
    }
    // ��������� ��� � ���������
    add(r);
    add(panel);
    // ������� ���� �� �����
    pack();
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new RadioButtons(); } });
  }
}
