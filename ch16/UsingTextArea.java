// UsingTextArea.java
// ������������� ������������� �����
import javax.swing.*;
import java.awt.*;

public class UsingTextArea extends JFrame {
  public UsingTextArea() {
    super("UsingTextArea");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ���� ������������� �����
    JTextArea area1 = new JTextArea(
        "������������� ����", 5, 10);
    // ������������� ����� � ���������
    area1.setFont(new Font("Dialog", Font.PLAIN, 14));
    area1.setTabSize(10);
    JTextArea area2 = new JTextArea(15, 10);
    // ��������� �������� ����
    area2.setLineWrap(true);
    area2.setWrapStyleWord(true);
    // ������� ���� � ����
    setLayout(new FlowLayout());
    add(new JScrollPane(area1));
    add(new JScrollPane(area2));
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingTextArea(); } });
  }
}