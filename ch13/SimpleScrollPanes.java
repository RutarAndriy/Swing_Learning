// SimpleScrollPanes.java
// ��������� ��������� ������� ������� ������� ���������
import javax.swing.*;
import java.awt.*;

public class SimpleScrollPanes extends JFrame {
  public SimpleScrollPanes() {
    super("SimpleScrollPanes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // �������
    JLabel label = new JLabel(new ImageIcon("image.jpg"));
    // ������ ����������� ������ ���������
    JScrollPane scrollPane = new JScrollPane(label,
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    // ��������� ��������
    scrollPane.setViewportBorder(
        BorderFactory.createLineBorder(Color.BLUE));
    scrollPane.setWheelScrollingEnabled(false);
    // ������� ���� �� �����
    add(scrollPane);
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleScrollPanes(); } });
  }
}