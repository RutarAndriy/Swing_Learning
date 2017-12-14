// TrickyMenuBar.java
// ������� ���� JMenuBar ����� ������
import javax.swing.*;
import java.awt.*;

public class TrickyMenuBar extends JFrame {
  public TrickyMenuBar() {
    super("TrickyMenuBar");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // ������� ������� ������� ����
    JMenuBar menuBar = new JMenuBar();
    // ��������� � ��� ���������� ����
    menuBar.add(new JMenu("����"));
    menuBar.add(new JMenu("������"));
    // �� �����, ��� ������������ �������
    // ������������, ��� ��� �����������
    // ������ �������
    menuBar.add(Box.createHorizontalGlue());
    // ������ �������� � ������� ����
    // �� ���������� ����, � ������� �� �������
    JLabel icon = new JLabel(
        new ImageIcon("images/download.gif"));
    icon.setBorder(
        BorderFactory.createLoweredBevelBorder());
    menuBar.add(icon);
    // �������� ���� � ���� ����
    setJMenuBar(menuBar);
    // ������� ���� �� �����
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new TrickyMenuBar(); } });
  }
}
