// UsingViewport.java
// ������ � "�������������" JViewport
import javax.swing.*;
import java.awt.*;

public class UsingViewport extends JFrame {
  public UsingViewport() {
    super("UsingViewport");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� � ������� �������� �������
    JLabel bigLabel = new JLabel(
        "<html><h1>������� �������!<br>����� ������!");
    // "������������"
    JViewport viewport = new JViewport();
    // ������������� ��� � ������� ��������
    viewport.setView(bigLabel);
    viewport.setExtentSize(new Dimension(100, 60));
    // ����� ������ ������� �������
    viewport.setViewPosition(new Point(50, 50));
    // ��������� ������ "������������"
    viewport.setPreferredSize(new Dimension(100, 60));
    // ������� ���� �� �����
    setLayout(new FlowLayout());
    add(viewport);
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingViewport(); } });
  }
}