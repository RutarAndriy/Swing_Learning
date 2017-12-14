// GridBagStart.java
// ������ ����� � ������������� GridBagLayout
import java.awt.*;
import javax.swing.*;

public class GridBagStart extends JFrame {
  public GridBagStart() {
    super("GridBagStart");
    // ����� ��� �������� ����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������������� ������������ �����������
    setLayout(new GridBagLayout());
    // ��������� ��� ������, ������ �� ���������
    add(new JButton("������"));
    add(new JButton("������"));
    // ��������� ������ ��� ���������� ����
    GridBagConstraints textFieldConstraints =
        new GridBagConstraints();
    // ���������� ������ �� �����������
    textFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
    // ������ ������ ��� ���������� ������
    textFieldConstraints.gridwidth =
        GridBagConstraints.REMAINDER;
    textFieldConstraints.weightx = 1.0f;
    add(new JTextField(10), textFieldConstraints);
    // ������� ���� �� �����
    setSize(400, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new GridBagStart(); } });
  }
}