// UsingSplitPanes.java
// ������������� ����������� �������
import javax.swing.*;
import java.awt.*;

public class UsingSplitPanes extends JFrame {
  // ���� ������ ����� ������������ � ��������
  private Icon icon = new ImageIcon("image.jpg");
  public UsingSplitPanes() {
    super("UsingSplitPanes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������ ����������� ������
    JSplitPane splitMain = new JSplitPane();
    splitMain.setOneTouchExpandable(true);
    // ������ ������
    splitMain.setDividerSize(20);
    // ������������ ����������� ������
    JSplitPane split2 = new JSplitPane(
        JSplitPane.VERTICAL_SPLIT, true);
    // �������� �� ����������
    split2.setTopComponent(
        new JScrollPane(new JLabel(icon)));
    split2.setBottomComponent(
        new JScrollPane(new JLabel(icon)));
    // �������� ���������� ������ ������
    splitMain.setLeftComponent(
        new JScrollPane(new JLabel(icon)));
    splitMain.setRightComponent(split2);
    // ������� ������ � ������� ���� �� �����
    add(splitMain);
    setSize(600, 400);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingSplitPanes(); } });
  }
}