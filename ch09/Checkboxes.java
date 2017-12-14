// Checkboxes.java
// ������������� ������� JCheckBox
import javax.swing.*;
import java.awt.*;

public class Checkboxes extends JFrame {
  public Checkboxes() {
    super("Checkboxes");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // ���������� ���������������� ������������
    setLayout(new FlowLayout());
    // ��������� ������
    JCheckBox ch = new JCheckBox("� ����� JFC", true);
    // ������ ��������� ������� � �����
    // ����������� ������
    JPanel panel = new JPanel(new GridLayout(0, 1, 0, 5));
    panel.setBorder(
        BorderFactory.createTitledBorder("���������"));
    String[] names = { "����-�����",
        "��� � ������", "����������" };
    for (String name : names) {
      JCheckBox check = new JCheckBox(name);
      panel.add(check);
    }
    // ��������� ��� � ���������
    add(ch);
    add(panel);
    // ������� ���� �� �����
    pack();
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new Checkboxes(); } });
  }
}
