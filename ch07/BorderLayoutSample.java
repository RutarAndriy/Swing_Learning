// BorderLayoutSample.java
// �������� ������������
import javax.swing.*;
import java.awt.*;

public class BorderLayoutSample extends JFrame {
  public BorderLayoutSample()  {
    super("BorderLayoutSample");
    setSize(400, 300);
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // ��������� ����������
    // � �������� ���������� ����� ������������ ������
    add(new JButton("�����"), "North");
    add(new JButton("��"), "South");
    // � ��� ��������� �� ������ BorderLayout
    add(new JLabel("�����"), BorderLayout.WEST);
    add(new JLabel("������"), BorderLayout.EAST);
    // ���� �������� �� ��������� �����, ���������
    // ������������� ��������� � �����
    add(new JButton("�����"));
    // ������� ���� �� �����
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new BorderLayoutSample(); } });
  }
}
