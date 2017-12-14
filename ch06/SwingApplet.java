// SwingApplet.java
// ������� ������ � �������������� Swing
import javax.swing.*;
import java.awt.*;

public class SwingApplet extends JApplet {
  // ���� ����� ���������� ��� �������� �������
  @Override
  public void init() {
    // �������� ����������
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            JPanel contents = new JPanel();
            contents.add(new JTextField(10));
            contents.add(new JButton("����"));
            setContentPane(contents);
        }});
  }
}