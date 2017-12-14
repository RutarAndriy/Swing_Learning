// MaskingEvents.java
// ������������ �������

import java.awt.*;
import javax.swing.*;

public class MaskingEvents extends JFrame {
  public MaskingEvents() {
    super("MaskingEvents");
    // ��� �������� ���� - �����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // �������� ������� �� ����
    disableEvents(AWTEvent.WINDOW_EVENT_MASK);
    // ������� ������ ������
    JPanel contents = new JPanel();
    contents.add(new CustomButton("������!"));
    setContentPane(contents);
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }

  // ������ ������
  class CustomButton extends JButton {
    public CustomButton(String label) {
      super(label);
      // ��������� ������� � ���������� � �� ����
      disableEvents(AWTEvent.KEY_EVENT_MASK);
      disableEvents(AWTEvent.MOUSE_EVENT_MASK);
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new MaskingEvents();
          }
        });
  }
}
