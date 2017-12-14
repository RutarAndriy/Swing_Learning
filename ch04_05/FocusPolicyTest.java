// FocusPolicyTest.java
// ��������� ��������� �������� ������ �����
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FocusPolicyTest extends JFrame {
  public FocusPolicyTest() {
    super("FocusPolicyTest");
    // ��� �������� ���� �����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ��������� ��� ������
    add(new JButton("�����"), "West");
    // ��������� ��� ������ ������, �� ��� ����� ����
    // ���� ������ ������
    JButton button = new JButton("�������");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // ��� ������� ������ �������� ��� ����
        setFocusTraversalPolicy(
            new ContainerOrderFocusTraversalPolicy());
      }
    });
    add(button, "South");
    add(new JButton("������"), "East");
    // ������� ���� �� �����
    setSize(200, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new FocusPolicyTest(); } });
  }
}
