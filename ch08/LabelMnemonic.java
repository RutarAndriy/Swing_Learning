// LabelMnemonic.java
// ������������� �������� ��� ������ ��������
import javax.swing.*;
import java.awt.*;

public class LabelMnemonic extends JFrame {
  public LabelMnemonic() {
    super("LabelMnemonic");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ���� ��������� �����
    JPanel contents = new JPanel(new GridLayout(2,2));
    JTextField tf = new JTextField(10);
    JLabel label = new JLabel("���� ���:");
    // ��������� ���������
    label.setLabelFor(tf);
    label.setDisplayedMnemonic('�');
    // ��������� ���������� � �������
    contents.add(new JLabel("���� �������:"));
    contents.add(new JTextField(10));
    contents.add(label);
    contents.add(tf);
    // ������� ���� �� �����
    setContentPane(contents);
    pack();
    setVisible(true);
  }
  public static void main(String args[]) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new LabelMnemonic(); } });
  }
}
