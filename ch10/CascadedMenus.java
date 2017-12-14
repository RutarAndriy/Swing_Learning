// CascadedMenus.java
// �������� ��������� ���� ����� ���������
import javax.swing.*;
import java.awt.*;

public class CascadedMenus extends JFrame {
  public CascadedMenus() {
    super("CascadedMenus");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // ������� ������ �������� ����
    JMenuBar menuBar = new JMenuBar();
    // ������� ���������� ����
    JMenu text = new JMenu("�����");
    // � ��������� ��������� ����
    JMenu style = new JMenu("�����");
    JMenuItem bold = new JMenuItem("������");
    JMenuItem italic = new JMenuItem("������");
    JMenu font = new JMenu("�����");
    JMenuItem arial = new JMenuItem("Arial");
    JMenuItem times = new JMenuItem("Times");
    font.add(arial);
    font.add(times);
    // ��������� ��� � ������ �������
    style.add(bold);
    style.add(italic);
    style.addSeparator();
    style.add(font);
    text.add(style);
    menuBar.add(text);
    // �������� ���� � ����
    setJMenuBar(menuBar);
    // ����������� ����� ���� ������� �� ������ � ����
    ((JComponent)getContentPane()).setBorder(
      BorderFactory.createEmptyBorder(0, 5, 0, 0));
    add(new JSeparator(SwingConstants.VERTICAL), "West");
    // ������� ���� �� �����
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new CascadedMenus(); } });
  }
}