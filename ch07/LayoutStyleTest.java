// LayoutStyleTest.java
// �������������� ����������� ����� ����������
import javax.swing.*;
import static javax.swing.LayoutStyle.ComponentPlacement.*;

public class LayoutStyleTest {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            // ����������
            JPanel panel = new JPanel();
            JTextField text = new JTextField();
            JLabel label = new JLabel("����");
            // ������ �� ������� ����������
            LayoutStyle style = LayoutStyle.getInstance();
            System.out.println("" + style.getContainerGap(
                text, SwingConstants.WEST, panel));
            // ���������� ����� ���������� ������������
            System.out.println("" + style.getPreferredGap(
                label, text, RELATED, SwingConstants.EAST, panel));
          } });
  }
}